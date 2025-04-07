package com.EzParking.ParkingLot.Factories;

import com.EzParking.ParkingLot.Repositories.SlabRepository;
import com.EzParking.ParkingLot.Strategies.HourlyFeesCalculationStrategy.FeesCalculationStrategy;
import com.EzParking.ParkingLot.Strategies.HourlyFeesCalculationStrategy.WeekdayStrategy;
import com.EzParking.ParkingLot.Strategies.HourlyFeesCalculationStrategy.WeekendStrategy;

import java.time.DayOfWeek;

public class DayTypeFactory {
    public static FeesCalculationStrategy findDayType(DayOfWeek day, SlabRepository slab_repo) {
        if(day!=DayOfWeek.SATURDAY && day!=DayOfWeek.SUNDAY)
            return new WeekdayStrategy(slab_repo);
        else
            return new WeekendStrategy(slab_repo);
    }
}
