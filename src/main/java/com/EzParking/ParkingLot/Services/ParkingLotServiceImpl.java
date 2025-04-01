package com.EzParking.ParkingLot.Services;

import com.EzParking.ParkingLot.Models.Operator;
import com.EzParking.ParkingLot.Models.ParkingLot;
import com.EzParking.ParkingLot.Repositories.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    @Autowired
    ParkingLotRepository parking_lot_repo;
    @Autowired
    FloorService floor_service;
    @Autowired
    OperatorService operator_service;

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
}
