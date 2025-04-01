package com.EzParking.ParkingLot.Repositories;

import com.EzParking.ParkingLot.Models.EVSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EVSpotRepository extends JpaRepository<EVSpot,Long> {
}
