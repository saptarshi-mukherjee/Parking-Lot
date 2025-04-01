package com.EzParking.ParkingLot.Services;

import com.EzParking.ParkingLot.Models.EVSpot;
import com.EzParking.ParkingLot.Models.Floor;
import com.EzParking.ParkingLot.Models.Meter;
import com.EzParking.ParkingLot.Models.SpotType;
import com.EzParking.ParkingLot.Repositories.EVSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EVSpotServiceImpl implements EVSpotService {

    @Autowired
    EVSpotRepository ev_spot_repo;
    @Autowired
    MeterService meter_service;

    @Override
    public List<EVSpot> createEVSpots(int EV_spot_num, Floor floor) {
        List<EVSpot> ev_spot_list=new ArrayList<>();
        for(int i=0;i<EV_spot_num;i++) {
            Meter meter= meter_service.createMeter();
            EVSpot ev_spot=new EVSpot();
            ev_spot.setType(SpotType.EV);
            ev_spot.setFloor(floor);
            ev_spot.setMeter(meter);
            ev_spot_list.add(ev_spot_repo.save(ev_spot));
        }
        return ev_spot_list;
    }
}
