package com.EzParking.ParkingLot.Services;

import com.EzParking.ParkingLot.Models.ParkingLot;

public interface ParkingLotService {
    public ParkingLot createParkingLot(String name, String address, int floor_num, int petro_spot_num, int ev_spot_num, int entry_gate_num, int exit_gate_num);
    public ParkingLot deleteParkingLot(String name, String address);
}
