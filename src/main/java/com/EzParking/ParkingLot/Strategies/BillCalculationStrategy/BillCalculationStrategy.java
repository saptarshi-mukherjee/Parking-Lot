package com.EzParking.ParkingLot.Strategies.BillCalculationStrategy;

import com.EzParking.ParkingLot.Repositories.SlabRepository;

import java.time.LocalDateTime;

public interface BillCalculationStrategy {
    public Double calculateBillAmount(LocalDateTime entry_time, LocalDateTime exit_time, Double units_consumed,
                                      SlabRepository slab_repo);
}
