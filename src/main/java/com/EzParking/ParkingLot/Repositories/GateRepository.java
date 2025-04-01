package com.EzParking.ParkingLot.Repositories;

import com.EzParking.ParkingLot.Models.Gate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GateRepository extends JpaRepository<Gate,Long> {
}
