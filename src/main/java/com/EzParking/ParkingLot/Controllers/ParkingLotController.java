package com.EzParking.ParkingLot.Controllers;


import com.EzParking.ParkingLot.DTO.ParkingLotDeleteRequestDto;
import com.EzParking.ParkingLot.DTO.ParkingLotRequestDto;
import com.EzParking.ParkingLot.Models.ParkingLot;
import com.EzParking.ParkingLot.Services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
