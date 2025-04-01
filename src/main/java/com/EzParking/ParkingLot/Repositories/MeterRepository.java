package com.EzParking.ParkingLot.Repositories;

import com.EzParking.ParkingLot.Models.Meter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeterRepository extends JpaRepository<Meter,Long> {
}
