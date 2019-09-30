package com.fuel.consumption.service;

import com.fuel.consumption.domain.FuelTab;
import com.fuel.consumption.dtos.ConsumptionRecordDTO;
import com.fuel.consumption.dtos.FuelTabDTO;
import com.fuel.consumption.dtos.MonthlyStatsDTO;
import com.fuel.consumption.dtos.SumDataDTO;
import com.fuel.consumption.exceptions.InvalidMonthNumberException;

import java.util.List;

public interface FuelTabService {
    List<FuelTabDTO> getAllByDriverID(Long driverID);

    List<FuelTab> getAllForAllDrivers();

    List<SumDataDTO> getMonthlySumByDriverId(Long driverID);

    FuelTab addFuelData(FuelTabDTO fuelTabDTO);

    List<ConsumptionRecordDTO> getConsumptionRecordsByMonth(int month) throws InvalidMonthNumberException;

    List<ConsumptionRecordDTO> getConsumptionRecordsByMonthAndId(Long driverId, Integer month) throws InvalidMonthNumberException;

/*    List<MonthlyStatsDTO> getMonthlyStatistics();

    List<MonthlyStatsDTO> getMonthlyStatisticsById(Long driverId);*/

    List<SumDataDTO> getMonthlySumForAllDrivers();

    List<FuelTab> addFuelDataInBatch(List<FuelTabDTO> fuelTabDTOS);

    void deleteAllRecords();
}
