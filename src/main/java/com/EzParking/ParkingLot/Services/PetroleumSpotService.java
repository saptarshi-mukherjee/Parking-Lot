package com.EzParking.ParkingLot.Services;

import com.EzParking.ParkingLot.Models.Floor;
import com.EzParking.ParkingLot.Models.PetroleumSpot;

import java.util.List;

public interface PetroleumSpotService {
    public List<PetroleumSpot> createPetroleumSpots(int petro_spot_num, Floor floor);
}
