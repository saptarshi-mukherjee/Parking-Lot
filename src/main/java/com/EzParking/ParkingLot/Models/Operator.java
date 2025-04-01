package com.EzParking.ParkingLot.Models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
public class Operator {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private ParkingLot parking_lot;

    public ParkingLot getParking_lot() {
        return parking_lot;
    }

    public void setParking_lot(ParkingLot parking_lot) {
        this.parking_lot = parking_lot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
