package com.EzParking.ParkingLot.Strategies.BillCalculationStrategy;

import com.EzParking.ParkingLot.Factories.DayTypeFactory;
import com.EzParking.ParkingLot.Repositories.SlabRepository;
import com.EzParking.ParkingLot.Strategies.HourlyFeesCalculationStrategy.FeesCalculationStrategy;

import java.time.Duration;
import java.time.LocalDateTime;

public class EVBillStrategy implements BillCalculationStrategy {

    private static final Double unit_rate=10.0;

    @Override
    public Double calculateBillAmount(LocalDateTime entry_time, LocalDateTime exit_time, Double units_consumed, SlabRepository slab_repo) {
        long hours= Duration.between(entry_time,exit_time).toHours();
        FeesCalculationStrategy strategy= DayTypeFactory.findDayType(entry_time.getDayOfWeek(), slab_repo);
        Double amount= strategy.calculateFees(hours) + (unit_rate*units_consumed);
        return amount;
    }
}
