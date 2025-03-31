package com.EzParking.ParkingLot.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class EVSpot extends Spot {
    private SpotType type;
    @OneToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Meter meter;

    public SpotType getType() {
        return type;
    }

    public void setType(SpotType type) {
        this.type = type;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Meter getMeter() {
        return meter;
    }

    public void setMeter(Meter meter) {
        this.meter = meter;
    }
}
