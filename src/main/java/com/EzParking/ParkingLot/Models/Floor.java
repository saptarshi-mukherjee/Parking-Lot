package com.EzParking.ParkingLot.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer floor_no;
    private FloorStatus status;
    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Spot> spots;
    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Gate> gate;
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

    public Integer getFloor_no() {
        return floor_no;
    }

    public void setFloor_no(Integer floor_no) {
        this.floor_no = floor_no;
    }

    public FloorStatus getStatus() {
        return status;
    }

    public void setStatus(FloorStatus status) {
        this.status = status;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    public List<Gate> getGate() {
        return gate;
    }

    public void setGate(List<Gate> gate) {
        this.gate = gate;
    }
}
