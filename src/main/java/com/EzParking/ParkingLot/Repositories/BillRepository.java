package com.EzParking.ParkingLot.Repositories;

import com.EzParking.ParkingLot.Models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill,Long> {


}
