package com.fuel.consumption.util;

import com.fuel.consumption.domain.Currencies;
import com.fuel.consumption.domain.FuelTab;
import com.fuel.consumption.domain.Measurements;
import com.fuel.consumption.dtos.ConsumptionRecordDTO;
import com.fuel.consumption.dtos.MonthlyStatsDTO;
import com.fuel.consumption.dtos.pojos.ConsumptionRecord;
import com.fuel.consumption.dtos.pojos.MonthlyStats;
import com.fuel.consumption.dtos.pojos.SumData;
import com.fuel.consumption.dtos.FuelTabDTO;
import com.fuel.consumption.dtos.SumDataDTO;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Adapters {

    private Calculator calculator = new Calculator();

    public FuelTab convertTabDtoToTab(FuelTabDTO fuelTabDTO) {
        FuelTab fuelTab = new FuelTab();
        fuelTab.setDriverID(fuelTabDTO.getDriverID());
        fuelTab.setFuelType(fuelTabDTO.getFuelType());
        fuelTab.setUnitPrice(fuelTabDTO.getUnitPrice());
        fuelTab.setPurchaseDate(LocalDate.from(convertStringToLocalDate(fuelTabDTO.getPurchaseDate())));
        fuelTab.setPurchasedVolume(fuelTabDTO.getPurchasedVolume());
        fuelTab.setAmountPaid(calculator.multiply(fuelTabDTO.getUnitPrice(), fuelTabDTO.getPurchasedVolume()));
        fuelTab.setCurrency(Currencies.EUR);
        fuelTab.setMeasurement(Measurements.LITRE);
        fuelTab.setMonthAndYear(getMonthAndYear(LocalDate.from(convertStringToLocalDate(fuelTabDTO.getPurchaseDate()))));
        return fuelTab;
    }

    public FuelTabDTO convertTabToTabDto(FuelTab tab) {
        FuelTabDTO tabDTO = new FuelTabDTO();
        tabDTO.setDriverID(tab.getDriverID());
        tabDTO.setPurchaseDate(String.valueOf(tab.getPurchaseDate()));
        tabDTO.setPurchasedVolume(tab.getPurchasedVolume());
        tabDTO.setUnitPrice(tab.getUnitPrice());
        tabDTO.setFuelType(tab.getFuelType());
        return tabDTO;
    }

    private LocalDateTime convertStringToLocalDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd.yyyy", Locale.ENGLISH);
        LocalDate localDate = LocalDate.parse(date.trim(), formatter);
        LocalTime localTime = LocalTime.of(12, 0);
        return LocalDateTime.of(localDate, localTime);
    }

    public SumDataDTO convertSumDataToDto(SumData sumData) {
        SumDataDTO sumDataDTO = new SumDataDTO();
        sumDataDTO.setMonthAndYear(sumData.getPurchaseDate());
        sumDataDTO.setSum(sumData.getSum());
        return sumDataDTO;
    }

    private String getMonthAndYear(LocalDate date){
        String month =date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int year = date.getYear();
        String monthAndYear = ""+month+" "+year;
        return monthAndYear.trim();
    }

    public ConsumptionRecordDTO convertConsumptionRecordToDto(ConsumptionRecord record) {
        ConsumptionRecordDTO dto = new ConsumptionRecordDTO();
        dto.setFuelType(record.getFuelType());
        dto.setPurchasedVolume(addEnumToValue(record.getPurchasedVolume(), Measurements.LITRE));
        dto.setPurchaseDate(record.getPurchaseDate());
        dto.setUnitPrice(addEnumToValue(record.getUnitPrice(), Currencies.EUR));
        dto.setAmountPaid(addEnumToValue(record.getAmountPaid(), Currencies.EUR));
        dto.setDriverID(record.getDriverID());
        return dto;
    }

    public MonthlyStatsDTO convertMonthlyStatsToDto(MonthlyStats stats) {
        MonthlyStatsDTO statsDTO = new MonthlyStatsDTO();
        statsDTO.setFuelType(stats.getFuelType());
        statsDTO.setPurchasedVolume(addEnumToValue(stats.getPurchasedVolume(), Measurements.LITRE));
        statsDTO.setAveragePrice(addEnumToValue(stats.getAveragePrice(), Currencies.EUR));
        statsDTO.setSum(addEnumToValue(stats.getSum(), Currencies.EUR));
        statsDTO.setMonthAndYear(stats.getPurchaseDate());
        return statsDTO;
    }

    public String addEnumToValue(Object value, Object enumTail){
        String output = String.valueOf(value)+" "+ String.valueOf(enumTail);
        return output.trim();
    }

    public List<MonthlyStatsDTO> getMonthlyStatsDTOS(List<MonthlyStats> statsList1) {
        List<MonthlyStatsDTO> statsDTOList1 = new ArrayList<>();
        statsList1.forEach(stats -> {
            MonthlyStatsDTO statsDTO = convertMonthlyStatsToDto(stats);
            statsDTOList1.add(statsDTO);
        });
        return statsDTOList1;
    }
}
