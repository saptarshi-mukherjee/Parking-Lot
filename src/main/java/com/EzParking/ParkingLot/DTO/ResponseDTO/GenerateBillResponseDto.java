package com.EzParking.ParkingLot.DTO.ResponseDTO;

public class GenerateBillResponseDto {
    private String reg_no;
    private String entry_time;
    private String exit_time;
    private Double units_consumed;
    private Double bill_value;

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

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

    public Double getUnits_consumed() {
        return units_consumed;
    }

    public void setUnits_consumed(Double units_consumed) {
        this.units_consumed = units_consumed;
    }

    public Double getBill_value() {
        return bill_value;
    }

    public void setBill_value(Double bill_value) {
        this.bill_value = bill_value;
    }
}
