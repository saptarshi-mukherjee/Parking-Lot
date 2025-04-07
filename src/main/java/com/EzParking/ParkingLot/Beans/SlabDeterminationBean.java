package com.EzParking.ParkingLot.Beans;


import com.EzParking.ParkingLot.Models.Slab;
import com.EzParking.ParkingLot.Repositories.SlabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

@DependsOn("slabRepository")
public class SlabDeterminationBean {

    @Autowired
    SlabRepository slab_repo;
//
//    public SlabDeterminationBean(SlabRepository slab_repo) {
//        this.slab_repo=slab_repo;
//    }

    public void createSlabs() {
        if(slab_repo.fetchById(1L)!=null) {
            Slab slab = new Slab();
            slab.setStart_time(0);
            slab.setEnd_time(1);
            slab.setWeekday_rate(30.0);
            slab.setWeekend_rate(50.0);
            slab_repo.save(slab);
            slab = new Slab();
            slab.setStart_time(1);
            slab.setEnd_time(3);
            slab.setWeekday_rate(20.0);
            slab.setWeekend_rate(35.0);
            slab_repo.save(slab);
            slab = new Slab();
            slab.setStart_time(3);
            slab.setEnd_time(6);
            slab.setWeekday_rate(15.0);
            slab.setWeekend_rate(25.0);
            slab_repo.save(slab);
            slab = new Slab();
            slab.setStart_time(6);
            slab.setEnd_time(12);
            slab.setWeekday_rate(10.0);
            slab.setWeekend_rate(20.0);
            slab_repo.save(slab);
            slab = new Slab();
            slab.setStart_time(12);
            slab.setEnd_time(24);
            slab.setWeekday_rate(5.0);
            slab.setWeekend_rate(10.0);
            slab_repo.save(slab);
        }
    }
}
