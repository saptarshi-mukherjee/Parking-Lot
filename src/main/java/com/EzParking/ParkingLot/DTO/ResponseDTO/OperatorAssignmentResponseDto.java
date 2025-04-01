package com.EzParking.ParkingLot.DTO.ResponseDTO;

public class OperatorAssignmentResponseDto {
    private long gate_id;
    private String operator_name;

    public long getGate_id() {
        return gate_id;
    }

    public void setGate_id(long gate_id) {
        this.gate_id = gate_id;
    }

    public String getOperator_name() {
        return operator_name;
    }

    public void setOperator_name(String operator_name) {
        this.operator_name = operator_name;
    }
}
