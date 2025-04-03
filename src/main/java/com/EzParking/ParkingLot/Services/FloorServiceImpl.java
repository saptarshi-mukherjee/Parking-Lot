package com.EzParking.ParkingLot.Services;

import com.EzParking.ParkingLot.Models.*;
import com.EzParking.ParkingLot.Repositories.FloorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class FloorServiceImpl implements FloorService {

    @Autowired
    FloorRepository floor_repo;
    @Autowired
    PetroleumSpotService petro_spot_service;
    @Autowired
    EVSpotService ev_spot_service;
    @Autowired
    GateService gate_service;

    @Override
    public List<Floor> createFloors(int floor_num, int petro_spot_num, int ev_spot_num, int entry_gate_num, int exit_gate_num, ParkingLot parking_lot) {
        List<Floor> floor_list=new ArrayList<>();
        for(int i=0;i<floor_num;i++) {
            Floor floor=new Floor();
            floor.setStatus(FloorStatus.AVAILABLE);
            floor.setParking_lot(parking_lot);
            floor=floor_repo.save(floor);
            List<PetroleumSpot> petro_spot_list=petro_spot_service.createPetroleumSpots(petro_spot_num,floor);
            List<EVSpot> ev_spot_list=ev_spot_service.createEVSpots(ev_spot_num,floor);
            List<Gate> gate_list=gate_service.createGates(entry_gate_num,exit_gate_num,floor);
            List<Spot> spot_list=new ArrayList<>();
            spot_list.addAll(petro_spot_list);
            spot_list.addAll(ev_spot_list);
            floor.setSpots(spot_list);
            floor.setGate(gate_list);
            floor_list.add(floor_repo.save(floor));
        }
        return floor_list;
    }
}
