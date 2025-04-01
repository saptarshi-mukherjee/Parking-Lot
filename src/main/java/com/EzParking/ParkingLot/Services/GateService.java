package com.EzParking.ParkingLot.Services;

import com.EzParking.ParkingLot.Models.Floor;
import com.EzParking.ParkingLot.Models.Gate;

import java.util.List;

public interface GateService {
    public List<Gate> createGates(int entry_gate_num, int exit_gate_num, Floor floor);
    public Gate assignOperator(long gate_id);
}
