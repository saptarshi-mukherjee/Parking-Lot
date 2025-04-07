package com.EzParking.ParkingLot.Repositories;

import com.EzParking.ParkingLot.Models.Vehicle;
import com.EzParking.ParkingLot.Models.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

    @Query(value = "select * from vehicle where match(reg_no)\n" +
            "against(:reg_no)", nativeQuery = true)
    public Vehicle fetchByRegNo(@Param("reg_no") String reg_no);
}
