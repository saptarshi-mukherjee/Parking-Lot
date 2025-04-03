package com.EzParking.ParkingLot.DTO.RequestDTO;

public class GenerateTicketRequestDto {
    private Long gate_id;
    private String reg_no, vehicle_type;


    public Long getGate_id() {
        return gate_id;
    }

    public void setGate_id(Long gate_id) {
        this.gate_id = gate_id;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }
}
