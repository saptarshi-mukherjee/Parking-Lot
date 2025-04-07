package com.EzParking.ParkingLot.Controllers;


import com.EzParking.ParkingLot.DTO.RequestDTO.*;
import com.EzParking.ParkingLot.DTO.ResponseDTO.GenerateBillResponseDto;
import com.EzParking.ParkingLot.DTO.ResponseDTO.VehicleEntryResponseDto;
import com.EzParking.ParkingLot.Models.Bill;
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


    @GetMapping("/exit")
    public GenerateBillResponseDto getBill(@RequestBody GenerateBillRequestDto request) {
        GenerateBillResponseDto response=new GenerateBillResponseDto();
        Bill bill=parking_lot_service.vehicleExit(request.getReg_no(), request.getUnits_consumed());
        response.setEntry_time(bill.getEntry_time().toString());
        response.setExit_time(bill.getExit_time().toString());
        response.setReg_no(bill.getVehicle().getReg_no());
        response.setUnits_consumed(request.getUnits_consumed());
        response.setBill_value(bill.getBill_value());
        return response;
    }
}
