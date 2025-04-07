package com.EzParking.ParkingLot.Strategies.HourlyFeesCalculationStrategy;

import com.EzParking.ParkingLot.Models.Slab;
import com.EzParking.ParkingLot.Repositories.SlabRepository;
import org.antlr.v4.runtime.misc.DoubleKeyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class WeekendStrategy implements FeesCalculationStrategy {


    SlabRepository slab_repo;

    public WeekendStrategy(SlabRepository slab_repo) {
        this.slab_repo = slab_repo;
    }

    @Override
    public Double calculateFees(long hours) {

        if(hours==0)
            return 50.0;
        if(hours>24)
            return 1000.0;

        List<Slab> slabs=slab_repo.fetchAllSlabs();
        Integer current_index=0, current_time=0;
        Double amount=0.0;
        while(current_time<hours) {
            if(current_time>=slabs.get(current_index).getEnd_time())
                current_index++;
            amount+=slabs.get(current_index).getWeekend_rate();
            current_time++;
        }
        return amount;
    }
}
