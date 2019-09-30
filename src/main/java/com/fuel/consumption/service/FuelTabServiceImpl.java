package com.fuel.consumption.service;

import com.fuel.consumption.domain.FuelTab;
import com.fuel.consumption.domain.FuelType;
import com.fuel.consumption.dtos.ConsumptionRecordDTO;
import com.fuel.consumption.dtos.FuelTabDTO;
import com.fuel.consumption.dtos.MonthlyStatsDTO;
import com.fuel.consumption.dtos.SumDataDTO;
import com.fuel.consumption.dtos.pojos.ConsumptionRecord;
import com.fuel.consumption.dtos.pojos.MonthlyStats;
import com.fuel.consumption.dtos.pojos.SumData;
import com.fuel.consumption.exceptions.InvalidMonthNumberException;
import com.fuel.consumption.repository.BulkInsertRepository;
import com.fuel.consumption.repository.FuelTabRepository;
import com.fuel.consumption.util.Adapters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class FuelTabServiceImpl implements FuelTabService {
    private final FuelTabRepository fuelTabRepository;
    private Adapters adapter = new Adapters();
    private final BulkInsertRepository bulkInsertRepository;

    @Autowired
    public FuelTabServiceImpl(FuelTabRepository fuelTabRepository, BulkInsertRepository bulkInsertRepository) {
        this.fuelTabRepository = fuelTabRepository;
        this.bulkInsertRepository = bulkInsertRepository;
    }

    @Override
    public List<FuelTabDTO> getAllByDriverID(Long driverID) {
        List<FuelTab> fuelTabs = fuelTabRepository.getAllById(driverID);
        List<FuelTabDTO> fuelTabDTOS = new ArrayList<>();

        fuelTabs.forEach(fuelTab -> {
            FuelTabDTO dto = adapter.convertTabToTabDto(fuelTab);
            fuelTabDTOS.add(dto);
        });

        return fuelTabDTOS;
    }

    @Override
    public List<FuelTab> getAllForAllDrivers() {
        return fuelTabRepository.findAll();
    }

    @Override
    public List<SumDataDTO> getMonthlySumForAllDrivers() {
        List<SumData> monthlySum = fuelTabRepository.getMonthlySum();
        List<SumDataDTO> sumDataDTOS = new ArrayList<>();

        monthlySum.forEach(sumData -> {
            SumDataDTO dto = adapter.convertSumDataToDto(sumData);
            sumDataDTOS.add(dto);
        });

        return sumDataDTOS;
    }

    @Override
    public FuelTab addFuelData(FuelTabDTO fuelTabDTO) {
        FuelTab fuelTab = adapter.convertTabDtoToTab(fuelTabDTO);
        return fuelTabRepository.save(fuelTab);
    }
    @Override
    public List<FuelTab> addFuelDataInBatch(List<FuelTabDTO> fuelTabDTOS) {
        List<FuelTab> fuelTabs = new ArrayList<>();

        fuelTabDTOS.forEach(fuelTabDTO -> {FuelTab tab = adapter.convertTabDtoToTab(fuelTabDTO);
        fuelTabs.add(tab);});

        return bulkInsertRepository.save(fuelTabs);
    }

    @Override
    public List<SumDataDTO> getMonthlySumByDriverId(Long driverID) {
        List<SumData> monthlySum = fuelTabRepository.getMonthlySumById(driverID);
        List<SumDataDTO> sumDataDTOS = new ArrayList<>();

        monthlySum.forEach(sumData -> {SumDataDTO dto = adapter.convertSumDataToDto(sumData);
        sumDataDTOS.add(dto);});

        return sumDataDTOS;
    }

    @Override
    public List<ConsumptionRecordDTO> getConsumptionRecordsByMonth(int month)throws InvalidMonthNumberException{
        if (month < 1 || month > 12) {
            throw new InvalidMonthNumberException("Month number cannot be less than 1 or greater than 12");
        }
        List<ConsumptionRecordDTO> recordDTOS = new ArrayList<>();
        List<ConsumptionRecord> consumptionRecords = fuelTabRepository.getConsumptionRecords(month);

        consumptionRecords.forEach(consumptionRecord -> {ConsumptionRecordDTO dto = adapter.convertConsumptionRecordToDto(consumptionRecord);
        recordDTOS.add(dto);});

        return recordDTOS;
    }

    @Override
    public List<ConsumptionRecordDTO> getConsumptionRecordsByMonthAndId(Long driverId, Integer month) throws InvalidMonthNumberException{
        if (month < 1 || month > 12) {
            throw new InvalidMonthNumberException("Month number cannot be less than 1 or greater than 12");
        }

        List<ConsumptionRecord> consumptionRecords = fuelTabRepository.getConsumptionRecordsById(month, driverId);
        List<ConsumptionRecordDTO> recordDTOS = new ArrayList<>();

        consumptionRecords.forEach(consumptionRecord -> {ConsumptionRecordDTO dto = adapter.convertConsumptionRecordToDto(consumptionRecord);
            recordDTOS.add(dto);});
        return recordDTOS;
    }

 /*   @Override
    public List<MonthlyStatsDTO> getMonthlyStatistics(){
        List<MonthlyStats> statsList1 = fuelTabRepository.getMonthlyStatistics();
        List<MonthlyStatsDTO> statsDTOList1 = new ArrayList<>();
        statsList1.forEach(stats -> {MonthlyStatsDTO statsDTO = adapter.convertMonthlyStatsToDto(stats);
            statsDTOList1.add(statsDTO);});
        return statsDTOList1;
    }


    @Override
    public List<MonthlyStatsDTO> getMonthlyStatisticsById(Long driverId) {
        List<MonthlyStats> monthlyStatsList = fuelTabRepository.getMonthlyStatisticsById(driverId);
        List<MonthlyStatsDTO> monthlyStatsDTOList = new ArrayList<>();

        monthlyStatsList.forEach(monthlyStats -> {MonthlyStatsDTO statsDTO = adapter.convertMonthlyStatsToDto(monthlyStats);
        monthlyStatsDTOList.add(statsDTO);});

        return monthlyStatsDTOList;
    }
*/

    @Override
    public void deleteAllRecords(){
        fuelTabRepository.deleteAll();
    }
}