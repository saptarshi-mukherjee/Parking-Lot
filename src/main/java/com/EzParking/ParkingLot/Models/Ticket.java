package com.EzParking.ParkingLot.Models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ticket_id;
    LocalDateTime entry_time;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    Vehicle vehicle;


    public Long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public LocalDateTime getEntry_time() {
        return entry_time;
    }

    public void setEntry_time() {
        this.entry_time = LocalDateTime.now();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
