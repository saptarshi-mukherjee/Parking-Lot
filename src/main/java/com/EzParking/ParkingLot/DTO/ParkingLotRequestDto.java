package com.EzParking.ParkingLot.DTO;

public class ParkingLotRequestDto {
    private String name, address;
    private int floors;
    private int petroleum_spots_per_floor, ev_spots_per_floor;
    private int entry_per_floor, exit_per_floor;

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

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getPetroleum_spots_per_floor() {
        return petroleum_spots_per_floor;
    }

    public void setPetroleum_spots_per_floor(int petroleum_spots_per_floor) {
        this.petroleum_spots_per_floor = petroleum_spots_per_floor;
    }

    public int getEv_spots_per_floor() {
        return ev_spots_per_floor;
    }

    public void setEv_spots_per_floor(int ev_spots_per_floor) {
        this.ev_spots_per_floor = ev_spots_per_floor;
    }

    public int getEntry_per_floor() {
        return entry_per_floor;
    }

    public void setEntry_per_floor(int entry_per_floor) {
        this.entry_per_floor = entry_per_floor;
    }

    public int getExit_per_floor() {
        return exit_per_floor;
    }

    public void setExit_per_floor(int exit_per_floor) {
        this.exit_per_floor = exit_per_floor;
    }
}
