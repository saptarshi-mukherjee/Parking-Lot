package com.EzParking.ParkingLot.Services;

import com.EzParking.ParkingLot.Models.Floor;
import com.EzParking.ParkingLot.Models.ParkingLot;

import java.util.List;

public interface FloorService {
    public List<Floor> createFloors(int floor_num, int petro_spot_num, int ev_spot_num, int entry_gate_num,
                                    int exit_gate_num, ParkingLot parking_lot);
}
