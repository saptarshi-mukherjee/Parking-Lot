package com.EzParking.ParkingLot.Repositories;

import com.EzParking.ParkingLot.Models.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ParkingLotRepository extends JpaRepository<ParkingLot,Long> {


    @Query(value = "select * from parking_lot\n" +
            "where name=:name and address=:address", nativeQuery = true)
    public ParkingLot fetchByNameAndAddress(@Param("name") String name, @Param("address") String address);
}
