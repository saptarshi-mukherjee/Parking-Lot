package com.EzParking.ParkingLot.Controllers;

import com.EzParking.ParkingLot.DTO.ResponseDTO.OperatorAssignmentResponseDto;
import com.EzParking.ParkingLot.Models.Gate;
import com.EzParking.ParkingLot.Services.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
