package com.fuel.consumption.service;

import com.fuel.consumption.domain.FuelTab;
import com.fuel.consumption.domain.FuelType;
import com.fuel.consumption.dao.dtos.ConsumptionRecordDTO;
import com.fuel.consumption.dao.dtos.FuelTabDTO;
import com.fuel.consumption.dao.dtos.MonthlyStatsDTO;
import com.fuel.consumption.dao.dtos.SumDataDTO;
import com.fuel.consumption.dao.pojos.ConsumptionRecord;
import com.fuel.consumption.dao.pojos.MonthlyStats;
import com.fuel.consumption.dao.pojos.SumData;
import com.fuel.consumption.util.exceptions.InvalidMonthNumberException;
import com.fuel.consumption.repository.BulkInsertRepository;
import com.fuel.consumption.repository.FuelTabRepository;
import com.fuel.consumption.util.Adapters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

   @Override
    public List<MonthlyStatsDTO> getMonthlyStatistics(){
        List<MonthlyStats> statsList1 = fuelTabRepository.getMonthlyStatistics(FuelType.D.getFuelTypes());
        List<MonthlyStats> statsList2 = fuelTabRepository.getMonthlyStatistics(FuelType.NINETY_FIVE.getFuelTypes());
        List<MonthlyStats> statsList3 = fuelTabRepository.getMonthlyStatistics(FuelType.NINETY_EIGHT.getFuelTypes());

       List<MonthlyStatsDTO> statsDTOList1 = adapter.getMonthlyStatsDTOS(statsList1);
       List<MonthlyStatsDTO> statsDTOList2 = adapter.getMonthlyStatsDTOS(statsList2);
       List<MonthlyStatsDTO> statsDTOList3 = adapter.getMonthlyStatsDTOS(statsList3);

       statsDTOList1.addAll(statsDTOList2);
       statsDTOList1.addAll(statsDTOList3);

        return statsDTOList1;
    }

    @Override
    public List<MonthlyStatsDTO> getMonthlyStatisticsById(Long driverId) {
        List<MonthlyStats> monthlyStatsList1 = fuelTabRepository.getMonthlyStatisticsById(driverId, FuelType.D.getFuelTypes());
        List<MonthlyStats> monthlyStatsList2 = fuelTabRepository.getMonthlyStatisticsById(driverId, FuelType.NINETY_FIVE.getFuelTypes());
        List<MonthlyStats> monthlyStatsList3 = fuelTabRepository.getMonthlyStatisticsById(driverId, FuelType.NINETY_EIGHT.getFuelTypes());

        List<MonthlyStatsDTO> monthlyStatsDTOList1 = adapter.getMonthlyStatsDTOS(monthlyStatsList1);
        List<MonthlyStatsDTO> monthlyStatsDTOList2 = adapter.getMonthlyStatsDTOS(monthlyStatsList2);
        List<MonthlyStatsDTO> monthlyStatsDTOList3 = adapter.getMonthlyStatsDTOS(monthlyStatsList3);

        monthlyStatsDTOList1.addAll(monthlyStatsDTOList2);
        monthlyStatsDTOList1.addAll(monthlyStatsDTOList3);

        return monthlyStatsDTOList1;
    }

    @Override
    public void deleteAllRecords(){
        fuelTabRepository.deleteAll();
    }
}
