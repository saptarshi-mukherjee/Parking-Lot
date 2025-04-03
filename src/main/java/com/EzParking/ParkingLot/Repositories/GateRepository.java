package com.EzParking.ParkingLot.Repositories;

import com.EzParking.ParkingLot.Models.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GateRepository extends JpaRepository<Gate,Long> {

    @Query(value = "select * from gate\n" +
            "where id=:id", nativeQuery = true)
    public Gate fetchGateById(@Param("id") long id);


    @Query(value = "select * from gate", nativeQuery = true)
    public List<Gate> fetchAllGates();
}
