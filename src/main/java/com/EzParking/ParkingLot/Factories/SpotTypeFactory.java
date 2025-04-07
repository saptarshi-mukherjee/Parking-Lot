package com.EzParking.ParkingLot.Factories;

import com.EzParking.ParkingLot.Models.PetroleumSpot;
import com.EzParking.ParkingLot.Models.Spot;
import com.EzParking.ParkingLot.Strategies.BillCalculationStrategy.BillCalculationStrategy;
import com.EzParking.ParkingLot.Strategies.BillCalculationStrategy.EVBillStrategy;
import com.EzParking.ParkingLot.Strategies.BillCalculationStrategy.PetroleumBillStrategy;

public class SpotTypeFactory {
    public static BillCalculationStrategy findSpotType(Spot spot) {
        if(spot instanceof PetroleumSpot)
            return new PetroleumBillStrategy();
        else
            return new EVBillStrategy();
    }
}
