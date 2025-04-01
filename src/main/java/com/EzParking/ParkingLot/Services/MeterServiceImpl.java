package com.EzParking.ParkingLot.Services;

import com.EzParking.ParkingLot.Models.Meter;
import com.EzParking.ParkingLot.Repositories.MeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MeterServiceImpl implements MeterService {

    @Autowired
    MeterRepository meter_repo;

    @Override
    public Meter createMeter() {
        Meter meter=new Meter();
        meter.setUnits_consumed(0.0);
        return meter_repo.save(meter);
    }
}
