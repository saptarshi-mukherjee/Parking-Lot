package com.EzParking.ParkingLot.Models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ticket_id;
    LocalDateTime entry_time;
    @ManyToOne
    @JsonBackReference
    Vehicle vehicle;
    @OneToOne(mappedBy = "ticket")
    @JsonManagedReference
    Bill bill;
    TicketStatus status;


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

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
