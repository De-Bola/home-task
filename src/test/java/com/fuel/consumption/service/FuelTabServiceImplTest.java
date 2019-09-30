package com.fuel.consumption.service;

import com.fuel.consumption.dao.dtos.ConsumptionRecordDTO;
import com.fuel.consumption.util.exceptions.InvalidMonthNumberException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FuelTabServiceImplTest {
    @Autowired
    FuelTabService fuelTabService;

    @Test
    public void getConsumptionRecordsByMonthAndId() throws InvalidMonthNumberException{
        List<ConsumptionRecordDTO> recordDTOS = fuelTabService.getConsumptionRecordsByMonthAndId(12345L, 2);
        assertFalse(recordDTOS.isEmpty());
    }
}
