package com.EzParking.ParkingLot.Repositories;

import com.EzParking.ParkingLot.Models.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpotRepository extends JpaRepository<Spot,Long> {
}
