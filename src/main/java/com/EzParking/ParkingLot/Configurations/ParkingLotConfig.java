package com.EzParking.ParkingLot.Configurations;


import com.EzParking.ParkingLot.Beans.SlabDeterminationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParkingLotConfig {

    @Bean(initMethod = "createSlabs")
    public SlabDeterminationBean determineSlab() {
        return new SlabDeterminationBean();
    }
}
