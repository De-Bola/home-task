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

    @Query("select new com.fuel.consumption.dtos.pojos.SumData(monthAndYear, sum(amountPaid)) from FuelTab where driverID=:driverID group by month(purchaseDate)")
    List<SumData> getMonthlySumById(Long driverID);


    @Query("select new com.fuel.consumption.dtos.pojos.SumData(monthAndYear, sum(amountPaid)) from FuelTab GROUP BY month(purchaseDate)")
    List<SumData> getMonthlySum();

    @Query("from FuelTab where driverID =:driverId")
    List<FuelTab> getAllById(Long driverId);

    @Query("select new com.fuel.consumption.dtos.pojos.ConsumptionRecord(fuelType, purchasedVolume, purchaseDate, unitPrice, amountPaid, driverID) from FuelTab where month(purchaseDate)=:month and driverID =:driverID")
    List<ConsumptionRecord> getConsumptionRecordsById(int month, Long driverID);

    @Query("select new com.fuel.consumption.dtos.pojos.ConsumptionRecord(fuelType, purchasedVolume, purchaseDate, unitPrice, amountPaid, driverID) from FuelTab where month(purchaseDate)=:month")
    List<ConsumptionRecord> getConsumptionRecords(int month);

    /*@Query("select fuelType, purchasedVolume, avg(amountPaid), sum(amountPaid) from FuelTab group by month(purchaseDate) having fuelType=:typeOfFuel")
    List<Object> getMonthlyStatistics(String typeOfFuel);

    @Query
    List<MonthlyStats> getMonthlyStatisticsById(Long driverId);*/
}
//select date_format(purchase_date, '%M %Y') month, avg(amount_paid) from fuel_consumption_db.fuel_tab group by month(purchase_date);
//select date_format(purchase_date, '%M %Y') month, sum(amount_paid) from fuel_consumption_db.fuel_tab where driverid = 12345 group by month(purchase_date);