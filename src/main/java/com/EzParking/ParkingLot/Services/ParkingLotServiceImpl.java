package com.EzParking.ParkingLot.Services;

import com.EzParking.ParkingLot.Factories.SpotTypeFactory;
import com.EzParking.ParkingLot.Models.*;
import com.EzParking.ParkingLot.Repositories.*;
import com.EzParking.ParkingLot.Strategies.BillCalculationStrategy.BillCalculationStrategy;
import com.EzParking.ParkingLot.Strategies.SpotAssignmentStrategy.AssignFirstAvailableSpot;
import com.EzParking.ParkingLot.Strategies.SpotAssignmentStrategy.AssignSpotStrategy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional
public class ParkingLotServiceImpl implements ParkingLotService {

    @Autowired
    ParkingLotRepository parking_lot_repo;
    @Autowired
    FloorService floor_service;
    @Autowired
    OperatorService operator_service;
    @Autowired
    VehicleRepository vehicle_repo;
    @Autowired
    TicketRepository ticket_repo;
    @Autowired
    GateRepository gate_repo;
    @Autowired
    FloorRepository floor_repo;
    @Autowired
    SpotRepository spot_repo;
    @Autowired
    BillRepository bill_repo;
    @Autowired
    SlabRepository slab_repo;

    @Override
    public ParkingLot createParkingLot(String name, String address, int floor_num, int petro_spot_num, int ev_spot_num, int entry_gate_num, int exit_gate_num) {
        ParkingLot parking_lot=new ParkingLot();
        parking_lot.setName(name);
        parking_lot.setAddress(address);
        parking_lot=parking_lot_repo.save(parking_lot);
        parking_lot.setFloors(floor_service.createFloors(floor_num,petro_spot_num,ev_spot_num,entry_gate_num,exit_gate_num,parking_lot));
        return parking_lot_repo.save(parking_lot);
    }

    @Override
    public ParkingLot deleteParkingLot(String name, String address) {
        ParkingLot parking_lot=parking_lot_repo.fetchByNameAndAddress(name, address);
        parking_lot_repo.delete(parking_lot);
        return parking_lot;
    }

    @Override
    public List<Operator> addOperator(String name, String phone, String lot_name) {
        ParkingLot parking_lot=parking_lot_repo.fetchByName(lot_name);
        if(parking_lot!=null) {
            Operator operator = operator_service.addNewOperator(name, phone, parking_lot);
            parking_lot.getOperators().add(operator);
            return parking_lot_repo.save(parking_lot).getOperators();
        }
        else {
            System.out.println("NULL PARKING LOT");
            return null;
        }
    }

    @Override
    public List<Operator> getAllOperators(String lot_name) {
        ParkingLot parking_lot=parking_lot_repo.fetchByName(lot_name);
        return parking_lot.getOperators();
    }

    @Override
    public Ticket vehicleEntry(long gate_id, String vehicle_type, String reg_no) throws Exception {
        AssignSpotStrategy strategy=new AssignFirstAvailableSpot();
        Vehicle vehicle=vehicle_repo.fetchByRegNo(reg_no);
        if(vehicle==null) {
            vehicle = new Vehicle();
            vehicle.setType(VehicleType.valueOf(vehicle_type.toUpperCase()));
            vehicle.setReg_no(reg_no);
            vehicle = vehicle_repo.save(vehicle);
        }
        Ticket ticket=new Ticket();
        ticket.setEntry_time();
        ticket.setVehicle(vehicle);
        ticket.setStatus(TicketStatus.OPEN);
        ticket=ticket_repo.save(ticket);
        Gate gate=gate_repo.fetchGateById(gate_id);
        gate.getVehicle().add(vehicle);
        Spot spot= strategy.assignSpot(gate.getFloor().getParking_lot().getFloors(), vehicle, vehicle.getType());
        Floor floor=setFloorStatus(spot.getFloor());
        floor_repo.save(floor);
        vehicle.setGate(gate);
        vehicle.setSpot(spot);
        spot.setVehicle(vehicle);
        vehicle.getTickets().add(ticket);
        vehicle=vehicle_repo.save(vehicle);
        System.out.println(spot.getVehicle().getId());
        spot_repo.save(spot);
        gate_repo.save(gate);
        return vehicle.getTickets().getLast();

    }

    @Override
    public Bill vehicleExit(String reg_no, Double unis_consumed) {
        Vehicle vehicle=vehicle_repo.fetchByRegNo(reg_no);
        Spot spot= vehicle.getSpot();
        Ticket ticket=vehicle.getTickets().getLast();
        LocalDateTime entry_time=vehicle.getTickets().getLast().getEntry_time();
        LocalDateTime exit_time=LocalDateTime.now();
        BillCalculationStrategy strategy= SpotTypeFactory.findSpotType(spot);
        Double bill_val= strategy.calculateBillAmount(entry_time,exit_time,unis_consumed, slab_repo);
        spot.setVehicle(null);
        vehicle.setSpot(null);
        Bill bill=new Bill();
        bill.setVehicle(vehicle);
        bill.setEntry_time(entry_time);
        bill.setExit_time(exit_time);
        bill.setTicket(vehicle.getTickets().getLast());
        bill.setBill_value(bill_val);
        ticket.setBill(bill);
        ticket.setStatus(TicketStatus.CLOSED);
        vehicle.getBills().add(bill);
        spot_repo.save(spot);
        vehicle_repo.save(vehicle);
        ticket_repo.save(ticket);
        bill=bill_repo.save(bill);
        return bill;
    }

    private Floor setFloorStatus(Floor floor) {
        boolean is_out_of_service=true;
        for(Spot spot : floor.getSpots()) {
            if(spot.getVehicle()==null) {
                is_out_of_service=false;
                break;
            }
        }
        if(is_out_of_service)
            floor.setStatus(FloorStatus.OUT_OF_SERVICE);
        else
            floor.setStatus(FloorStatus.AVAILABLE);
        return floor;
    }
}
