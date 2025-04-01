package com.EzParking.ParkingLot.Repositories;

import com.EzParking.ParkingLot.Models.PetroleumSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetroleumSpotRepository extends JpaRepository<PetroleumSpot,Long> {
}
