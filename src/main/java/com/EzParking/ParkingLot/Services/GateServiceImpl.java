package com.EzParking.ParkingLot.Services;

import com.EzParking.ParkingLot.Models.Floor;
import com.EzParking.ParkingLot.Models.Gate;
import com.EzParking.ParkingLot.Models.GateType;
import com.EzParking.ParkingLot.Repositories.GateRepository;
import com.EzParking.ParkingLot.Repositories.OperatorRepository;
import com.EzParking.ParkingLot.Strategies.OperatorAssignmentStrategy.AssignFirstAvailable;
import com.EzParking.ParkingLot.Strategies.OperatorAssignmentStrategy.AssignOperatorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
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
}
