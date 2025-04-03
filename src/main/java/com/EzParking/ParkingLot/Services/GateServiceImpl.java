package com.EzParking.ParkingLot.Services;

import com.EzParking.ParkingLot.Models.Floor;
import com.EzParking.ParkingLot.Models.Gate;
import com.EzParking.ParkingLot.Models.GateType;
import com.EzParking.ParkingLot.Repositories.GateRepository;
import com.EzParking.ParkingLot.Repositories.OperatorRepository;
import com.EzParking.ParkingLot.Strategies.OperatorAssignmentStrategy.AssignFirstAvailable;
import com.EzParking.ParkingLot.Strategies.OperatorAssignmentStrategy.AssignOperatorStrategy;
import com.EzParking.ParkingLot.Strategies.OperatorReassignmentStrategy.RandomReassignmentStrategy;
import com.EzParking.ParkingLot.Strategies.OperatorReassignmentStrategy.ReassignOperatorStrategy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class GateServiceImpl implements GateService {

    @Autowired
    GateRepository gate_repo;
    @Autowired
    OperatorRepository operator_repo;

    @Override
    public List<Gate> createGates(int entry_gate_num, int exit_gate_num, Floor floor) {
        List<Gate> gate_list=new ArrayList<>();
        for(int i=0;i<entry_gate_num;i++) {
            Gate gate=new Gate();
            gate.setType(GateType.ENTRY);
            gate.setFloor(floor);
            gate_list.add(gate_repo.save(gate));
        }
        for(int i=0;i<exit_gate_num;i++) {
            Gate gate=new Gate();
            gate.setType(GateType.EXIT);
            gate.setFloor(floor);
            gate_list.add(gate_repo.save(gate));
        }
        return gate_list;
    }

    @Override
    public Gate assignOperator(long gate_id) {
        AssignOperatorStrategy strategy=new AssignFirstAvailable(gate_repo,operator_repo);
        Gate gate=gate_repo.fetchGateById(gate_id);
        return strategy.assign(gate);
    }

    @Override
    public List<Gate> resetOperators() {
        List<Gate> gates=gate_repo.fetchAllGates();
        for(Gate gate : gates) {
            gate.setOperator(null);
            gate_repo.save(gate);
        }
        return gates;
    }

    @Override
    public Gate reassignOperator(Long gate_id) {
        Gate gate=gate_repo.fetchGateById(gate_id);
        if(gate.getOperator()==null)
            System.out.println("ASSIGN OPERATOR FIRST");
        else {
            ReassignOperatorStrategy strategy=new RandomReassignmentStrategy(gate_repo,operator_repo);
            gate= strategy.reassign(gate);
        }
        return gate;
    }
}
