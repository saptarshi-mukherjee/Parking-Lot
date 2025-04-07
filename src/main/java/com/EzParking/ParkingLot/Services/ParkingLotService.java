package com.EzParking.ParkingLot.Services;

import com.EzParking.ParkingLot.Models.Bill;
import com.EzParking.ParkingLot.Models.Operator;
import com.EzParking.ParkingLot.Models.ParkingLot;
import com.EzParking.ParkingLot.Models.Ticket;

import java.util.List;

public interface ParkingLotService {
    public ParkingLot createParkingLot(String name, String address, int floor_num, int petro_spot_num, int ev_spot_num, int entry_gate_num, int exit_gate_num);
    public ParkingLot deleteParkingLot(String name, String address);
    public List<Operator> addOperator(String name, String phone, String lot_name);
    public List<Operator> getAllOperators(String lot_name);
    public Ticket vehicleEntry(long gate_id, String vehicle_type, String reg_no) throws Exception;
    public Bill vehicleExit(String reg_no, Double unis_consumed);
}
