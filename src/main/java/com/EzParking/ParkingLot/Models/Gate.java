package com.EzParking.ParkingLot.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Gate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private GateType type;
    //private Integer gate_no;
    @OneToOne
    @JsonManagedReference
    private Operator operator;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Floor floor;
    @OneToMany(mappedBy = "gate")
    @JsonManagedReference
    List<Vehicle> vehicle=new ArrayList<>();

    public List<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(List<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GateType getType() {
        return type;
    }

    public void setType(GateType type) {
        this.type = type;
    }

//    public Integer getGate_no() {
//        return gate_no;
//    }
//
////    public void setGate_no(Integer gate_no) {
////        this.gate_no = gate_no;
////    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
