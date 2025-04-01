package com.EzParking.ParkingLot.Repositories;

import com.EzParking.ParkingLot.Models.Meter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeterRepository extends JpaRepository<Meter,Long> {
}
