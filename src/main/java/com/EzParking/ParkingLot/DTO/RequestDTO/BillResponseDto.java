package com.EzParking.ParkingLot.DTO.RequestDTO;

public class BillResponseDto {
    String entry_time, exit_time;
    Double bill_value;

    public String getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(String entry_time) {
        this.entry_time = entry_time;
    }

    public String getExit_time() {
        return exit_time;
    }

    public void setExit_time(String exit_time) {
        this.exit_time = exit_time;
    }

    public Double getBill_value() {
        return bill_value;
    }

    public void setBill_value(Double bill_value) {
        this.bill_value = bill_value;
    }
}
