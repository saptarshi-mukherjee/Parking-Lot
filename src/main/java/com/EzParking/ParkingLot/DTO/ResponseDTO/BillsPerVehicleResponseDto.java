package com.EzParking.ParkingLot.DTO.ResponseDTO;

import com.EzParking.ParkingLot.DTO.RequestDTO.BillResponseDto;

import java.util.ArrayList;
import java.util.List;

public class BillsPerVehicleResponseDto {
    String reg_no;
    List<BillResponseDto> bills=new ArrayList<>();

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public List<BillResponseDto> getBills() {
        return bills;
    }

    public void setBills(List<BillResponseDto> bills) {
        this.bills = bills;
    }
}
