package com.EzParking.ParkingLot.Services;

import com.EzParking.ParkingLot.Models.EVSpot;
import com.EzParking.ParkingLot.Models.Floor;

import java.util.List;

public interface EVSpotService {
    public List<EVSpot> createEVSpots(int EV_spot_num, Floor floor);
}
