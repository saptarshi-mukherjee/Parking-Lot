package com.EzParking.ParkingLot.Repositories;

import com.EzParking.ParkingLot.Models.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends JpaRepository<Operator,Long> {
}
