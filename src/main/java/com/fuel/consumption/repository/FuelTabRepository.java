package com.fuel.consumption.repository;

import com.fuel.consumption.domain.FuelTab;
import com.fuel.consumption.dtos.pojos.ConsumptionRecord;
import com.fuel.consumption.dtos.pojos.MonthlyStats;
import com.fuel.consumption.dtos.pojos.SumData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelTabRepository extends JpaRepository<FuelTab, Long> {

    @Query("select new com.fuel.consumption.dtos.pojos.SumData(monthAndYear, sum(amountPaid)) from FuelTab " +
            "where driverID=:driverID group by month(purchaseDate)")
    List<SumData> getMonthlySumById(Long driverID);


    @Query("select new com.fuel.consumption.dtos.pojos.SumData(monthAndYear, sum(amountPaid)) from FuelTab " +
            "GROUP BY month(purchaseDate)")
    List<SumData> getMonthlySum();

    @Query("from FuelTab where driverID =:driverId")
    List<FuelTab> getAllById(Long driverId);

    @Query("select new com.fuel.consumption.dtos.pojos.ConsumptionRecord" +
            "(fuelType, purchasedVolume, purchaseDate, unitPrice, amountPaid, driverID) from FuelTab " +
            "where month(purchaseDate)=:month and driverID =:driverID")
    List<ConsumptionRecord> getConsumptionRecordsById(int month, Long driverID);

    @Query("select new com.fuel.consumption.dtos.pojos.ConsumptionRecord" +
            "(fuelType, purchasedVolume, purchaseDate, unitPrice, amountPaid, driverID) from FuelTab " +
            "where month(purchaseDate)=:month")
    List<ConsumptionRecord> getConsumptionRecords(int month);

    @Query("select new com.fuel.consumption.dtos.pojos.MonthlyStats" +
            "(fuelType, sum(purchasedVolume), avg(amountPaid), sum(amountPaid), monthAndYear) from FuelTab " +
            "where fuelType=:fuelType group by monthAndYear")
    List<MonthlyStats> getMonthlyStatistics(String fuelType);

    @Query("select new com.fuel.consumption.dtos.pojos.MonthlyStats" +
            "(fuelType, sum(purchasedVolume), avg(amountPaid), sum(amountPaid), monthAndYear) from FuelTab " +
            "where driverID=:driverId and fuelType=:fuelType group by monthAndYear")
    List<MonthlyStats> getMonthlyStatisticsById(Long driverId, String fuelType);
}