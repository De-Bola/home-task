package com.fuel.consumption.service;

import com.fuel.consumption.dtos.ConsumptionRecordDTO;
import com.fuel.consumption.exceptions.InvalidMonthNumberException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;

@SpringBootTest
@RunWith(SpringRunner.class)
@Sql("/test-single-insert.sql")
public class FuelTabServiceImplTest {
    @Autowired
    FuelTabService fuelTabService;

    @Test
    public void getConsumptionRecordsByMonthAndId() throws InvalidMonthNumberException{
        List<ConsumptionRecordDTO> recordDTOS = fuelTabService.getConsumptionRecordsByMonthAndId(12345L, 2);
        assertFalse(recordDTOS.isEmpty());
    }
}
