package com.EzParking.ParkingLot.DTO.ResponseDTO;

import java.time.LocalDateTime;

public class VehicleEntryResponseDto {
    long ticket_id, gate_id, spot_id;
    String reg_no;
    LocalDateTime entry_time;
    String spot_type;

    public long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public long getGate_id() {
        return gate_id;
    }

    public void setGate_id(long gate_id) {
        this.gate_id = gate_id;
    }

    public long getSpot_id() {
        return spot_id;
    }

    public void setSpot_id(long spot_id) {
        this.spot_id = spot_id;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public LocalDateTime getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(LocalDateTime entry_time) {
        this.entry_time = entry_time;
    }

    public String getSpot_type() {
        return spot_type;
    }

    public void setSpot_type(String spot_type) {
        this.spot_type = spot_type;
    }
}
