package com.EzParking.ParkingLot.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class PetroleumSpot extends Spot {
    private SpotType type;


    public SpotType getType() {
        return type;
    }

    public void setType(SpotType type) {
        this.type = type;
    }

//    public Vehicle getVehicle() {
//        return vehicle;
//    }
//
//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }
}
