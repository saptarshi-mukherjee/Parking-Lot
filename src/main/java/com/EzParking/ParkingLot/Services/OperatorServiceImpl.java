package com.EzParking.ParkingLot.Services;


import com.EzParking.ParkingLot.Models.Operator;
import com.EzParking.ParkingLot.Models.ParkingLot;
import com.EzParking.ParkingLot.Repositories.OperatorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    OperatorRepository operator_repo;

    @Override
    public Operator addNewOperator(String name, String phone, ParkingLot parking_lot) {
        Operator operator=new Operator();
        operator.setName(name);
        operator.setPhone(phone);
        operator.setParking_lot(parking_lot);
        operator=operator_repo.save(operator);
        return operator;
    }
}
