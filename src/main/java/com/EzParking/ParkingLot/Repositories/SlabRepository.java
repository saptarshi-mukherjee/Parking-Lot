package com.EzParking.ParkingLot.Repositories;

import com.EzParking.ParkingLot.Models.Slab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlabRepository extends JpaRepository<Slab,Long> {


    @Query(value = "select * from slab where id = :id", nativeQuery = true)
    public Slab fetchById(@Param("id") Long id);

    @Query(value = "select * from slab\n" +
            "order by start_time", nativeQuery = true)
    public List<Slab> fetchAllSlabs();
}
