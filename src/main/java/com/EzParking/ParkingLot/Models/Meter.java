package com.EzParking.ParkingLot.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Meter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double units_consumed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getUnits_consumed() {
        return units_consumed;
    }

    public void setUnits_consumed(Double units_consumed) {
        this.units_consumed = units_consumed;
    }
}
