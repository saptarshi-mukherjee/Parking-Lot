package com.EzParking.ParkingLot.DTO.RequestDTO;

public class ParkingLotDeleteRequestDto {
    private String name, address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
