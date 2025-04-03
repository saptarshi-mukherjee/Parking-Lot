package com.EzParking.ParkingLot.Strategies.OperatorReassignmentStrategy;

import com.EzParking.ParkingLot.Models.Gate;
import com.EzParking.ParkingLot.Models.Operator;
import com.EzParking.ParkingLot.Repositories.GateRepository;
import com.EzParking.ParkingLot.Repositories.OperatorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomReassignmentStrategy implements ReassignOperatorStrategy {


    GateRepository gate_repo;
    OperatorRepository operator_repo;

    public RandomReassignmentStrategy(GateRepository gate_repo, OperatorRepository operator_repo) {
        this.gate_repo = gate_repo;
        this.operator_repo = operator_repo;
    }

    @Override
    public Gate reassign(Gate gate) {
        List<Operator> operator_list=gate.getFloor().getParking_lot().getOperators();
        Operator current_operator= gate.getOperator();
        Operator new_operator=null;
        List<Integer> available=new ArrayList<>();
        int n=operator_list.size(), i, m;
        for(i=0;i<n;i++) {
            if(operator_list.get(i).getGate()==null)
                available.add(i);
        }
        m=available.size();
        Random random=new Random();
        int index= random.nextInt(m);
        new_operator=operator_list.get(available.get(index));
        current_operator.setGate(null);
        operator_repo.save(current_operator);
        gate.setOperator(null);
        gate.setOperator(new_operator);
        new_operator.setGate(gate);
        gate=gate_repo.save(gate);
        operator_repo.save(new_operator);
        return gate;
    }
}
