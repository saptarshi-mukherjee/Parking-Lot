package com.EzParking.ParkingLot.Strategies.SpotAssignmentStrategy;

import com.EzParking.ParkingLot.Models.Floor;
import com.EzParking.ParkingLot.Models.Spot;
import com.EzParking.ParkingLot.Models.Vehicle;
import com.EzParking.ParkingLot.Models.VehicleType;

import java.util.List;

public interface AssignSpotStrategy {
    public Spot assignSpot(List<Floor> floors, Vehicle vehicle, VehicleType vehicle_type) throws Exception;
}
