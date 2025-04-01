package com.EzParking.ParkingLot.Controllers;


import com.EzParking.ParkingLot.DTO.RequestDTO.AddOperatorRequestDto;
import com.EzParking.ParkingLot.DTO.RequestDTO.ParkingLotDeleteRequestDto;
import com.EzParking.ParkingLot.DTO.RequestDTO.ParkingLotRequestDto;
import com.EzParking.ParkingLot.Models.Operator;
import com.EzParking.ParkingLot.Models.ParkingLot;
import com.EzParking.ParkingLot.Services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lot")
public class ParkingLotController {

    @Autowired
    ParkingLotService parking_lot_service;

    @PostMapping("/post")
    public ParkingLot createNewParkingLot(@RequestBody ParkingLotRequestDto request) {
        return parking_lot_service.createParkingLot(request.getName(), request.getAddress(), request.getFloors(),
                request.getPetroleum_spots_per_floor(), request.getEv_spots_per_floor(), request.getEntry_per_floor(), request.getExit_per_floor());
    }

    @DeleteMapping("/delete")
    public ParkingLot deleteParkingLot(@RequestBody ParkingLotDeleteRequestDto request) {
        return parking_lot_service.deleteParkingLot(request.getName(), request.getAddress());
    }

    @PostMapping("/post/operator")
    public List<Operator> addOperator(@RequestBody AddOperatorRequestDto request) {
        return parking_lot_service.addOperator(request.getOperator_name(), request.getPhone(), request.getParking_lot_name());
    }

    @GetMapping("/get/operator/all/{lot_name}")
    public List<Operator> getAllOperators(@PathVariable("lot_name") String lot_name) {
        return parking_lot_service.getAllOperators(lot_name);
    }
}
