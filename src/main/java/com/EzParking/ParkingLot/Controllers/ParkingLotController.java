package com.EzParking.ParkingLot.Controllers;


import com.EzParking.ParkingLot.DTO.RequestDTO.AddOperatorRequestDto;
import com.EzParking.ParkingLot.DTO.RequestDTO.GenerateTicketRequestDto;
import com.EzParking.ParkingLot.DTO.RequestDTO.ParkingLotDeleteRequestDto;
import com.EzParking.ParkingLot.DTO.RequestDTO.ParkingLotRequestDto;
import com.EzParking.ParkingLot.DTO.ResponseDTO.VehicleEntryResponseDto;
import com.EzParking.ParkingLot.Models.Operator;
import com.EzParking.ParkingLot.Models.ParkingLot;
import com.EzParking.ParkingLot.Models.Ticket;
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

    @GetMapping("/entry")
    public VehicleEntryResponseDto getTicket(@RequestBody GenerateTicketRequestDto request) throws Exception {
        Ticket ticket = parking_lot_service.vehicleEntry(request.getGate_id(), request.getVehicle_type(), request.getReg_no());
        VehicleEntryResponseDto response=new VehicleEntryResponseDto();
        response.setTicket_id(ticket.getTicket_id());
        response.setEntry_time(ticket.getEntry_time());
        response.setGate_id(ticket.getVehicle().getGate().getId());
        response.setReg_no(ticket.getVehicle().getReg_no());
        response.setSpot_id(ticket.getVehicle().getSpot().getId());
        response.setSpot_type(ticket.getVehicle().getType().toString());
        return response;
    }
}
