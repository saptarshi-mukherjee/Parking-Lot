package com.EzParking.ParkingLot.Strategies.OperatorAssignmentStrategy;

import com.EzParking.ParkingLot.Models.Gate;
import com.EzParking.ParkingLot.Models.Operator;
import com.EzParking.ParkingLot.Repositories.GateRepository;
import com.EzParking.ParkingLot.Repositories.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AssignFirstAvailable implements AssignOperatorStrategy {

    GateRepository gate_repo;
    OperatorRepository operator_repo;

    public AssignFirstAvailable(GateRepository gate_repo, OperatorRepository operator_repo) {
        this.gate_repo=gate_repo;
        this.operator_repo=operator_repo;
    }

    @Override
    public Gate assign(Gate gate) {
        List<Operator> operators=gate.getFloor().getParking_lot().getOperators();
        boolean is_filled=true;
        for(Operator operator : operators) {
            if(operator.getGate()==null) {
                is_filled=false;
                operator.setGate(gate);
                operator_repo.save(operator);
                gate.setOperator(operator);
                gate_repo.save(gate);
                break;
            }
        }
        if(is_filled)
            System.out.println("Operator limit reached");
        return gate;
    }
}
