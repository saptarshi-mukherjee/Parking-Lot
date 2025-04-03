package com.EzParking.ParkingLot.Strategies.SpotAssignmentStrategy;

import com.EzParking.ParkingLot.Models.*;

import java.util.List;

public class AssignFirstAvailableSpot implements AssignSpotStrategy {
    @Override
    public Spot assignSpot(List<Floor> floors, Vehicle vehicle, VehicleType vehicle_type) throws Exception {
        boolean is_filled=true;
        Floor available_floor=null;
        Spot available_Spot=null;
       outer:
        for(Floor floor : floors) {
            if (floor.getStatus() == FloorStatus.AVAILABLE) {
                available_floor = floor;
                for(Spot spot : available_floor.getSpots()) {
                    if(isPetroleumAvailable(spot) && vehicle_type==VehicleType.PETROLEUM) {
                        is_filled=false;
                        available_Spot=spot;
                        available_Spot.setVehicle(vehicle);
                        break outer;
                    }
                    else if(isEVAvailable(spot) && vehicle_type==VehicleType.EV) {
                        is_filled=false;
                        available_Spot=spot;
                        //available_Spot.setVehicle(vehicle);
                        break outer;
                    }
                }
            }
        }
        if(available_floor==null)
            throw new Exception("Floors not available");
        if(is_filled)
            throw new Exception("Required spot not available");
        return available_Spot;
    }


    private boolean isPetroleumAvailable(Spot spot) {
        return spot.getVehicle()==null && spot instanceof PetroleumSpot;
    }

    private boolean isEVAvailable(Spot spot) {
        return spot.getVehicle()==null && spot instanceof EVSpot;
    }
}
