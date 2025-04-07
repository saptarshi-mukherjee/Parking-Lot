package com.EzParking.ParkingLot.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Slab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer start_time, end_time;
    Double weekday_rate, weekend_rate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStart_time() {
        return start_time;
    }

    public void setStart_time(Integer start_time) {
        this.start_time = start_time;
    }

    public Integer getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Integer end_time) {
        this.end_time = end_time;
    }

    public Double getWeekday_rate() {
        return weekday_rate;
    }

    public void setWeekday_rate(Double weekday_rate) {
        this.weekday_rate = weekday_rate;
    }

    public Double getWeekend_rate() {
        return weekend_rate;
    }

    public void setWeekend_rate(Double weekend_rate) {
        this.weekend_rate = weekend_rate;
    }
}
