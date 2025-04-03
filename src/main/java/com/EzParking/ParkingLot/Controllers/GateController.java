package com.EzParking.ParkingLot.Controllers;

import com.EzParking.ParkingLot.DTO.ResponseDTO.OperatorAssignmentResponseDto;
import com.EzParking.ParkingLot.Models.Gate;
import com.EzParking.ParkingLot.Services.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gate")
public class GateController {

    @Autowired
    GateService gate_service;

    @PostMapping("/assign/operator/{gate_id}")
    public OperatorAssignmentResponseDto assignOperator(@PathVariable("gate_id") Long gate_id) {
        Gate gate= gate_service.assignOperator(gate_id);
        OperatorAssignmentResponseDto response=new OperatorAssignmentResponseDto();
        response.setGate_id(gate.getId());
        response.setOperator_name(gate.getOperator().getName());
        return response;
    }

    @PutMapping("/reset")
    public List<Gate> resetAllGates() {
        return gate_service.resetOperators();
    }

    @PutMapping("/reassign/operator/{gate_id}")
    public Gate reassignOperator(@PathVariable("gate_id") long gate_id) {
        return gate_service.reassignOperator(gate_id);
    }
}
