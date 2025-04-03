package com.EzParking.ParkingLot.Services;

import com.EzParking.ParkingLot.Models.Floor;
import com.EzParking.ParkingLot.Models.PetroleumSpot;
import com.EzParking.ParkingLot.Models.SpotType;
import com.EzParking.ParkingLot.Repositories.PetroleumSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PetroleumSpotServiceImpl implements PetroleumSpotService {

    @Autowired
    PetroleumSpotRepository petro_spot_repo;

    @Override
    public List<PetroleumSpot> createPetroleumSpots(int petro_spot_num, Floor floor) {
        List<PetroleumSpot> petro_spot_list=new ArrayList<>();
        for(int i=0;i<petro_spot_num;i++) {
            PetroleumSpot petro_spot=new PetroleumSpot();
            petro_spot.setType(SpotType.PETROLEUM);
            petro_spot.setFloor(floor);
            petro_spot_list.add(petro_spot_repo.save(petro_spot));
        }
        return petro_spot_list;
    }
}
