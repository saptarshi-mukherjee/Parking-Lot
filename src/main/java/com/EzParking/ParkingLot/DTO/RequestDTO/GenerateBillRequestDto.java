package com.EzParking.ParkingLot.DTO.RequestDTO;

public class GenerateBillRequestDto {
    private String reg_no;
    private Double units_consumed;

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public Double getUnits_consumed() {
        return units_consumed;
    }

    public void setUnits_consumed(Double units_consumed) {
        this.units_consumed = units_consumed;
    }
}
