package com.EzParking.ParkingLot.Services;

import com.EzParking.ParkingLot.Models.Operator;
import com.EzParking.ParkingLot.Models.ParkingLot;

public interface OperatorService {
    public Operator addNewOperator(String name, String phone, ParkingLot parking_lot);
}
