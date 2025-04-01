package com.EzParking.ParkingLot.Repositories;

import com.EzParking.ParkingLot.Models.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<Floor,Long> {
}
