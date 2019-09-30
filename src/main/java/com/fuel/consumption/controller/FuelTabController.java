
package com.fuel.consumption.controller;

import com.fuel.consumption.domain.FuelTab;
import com.fuel.consumption.dtos.ConsumptionRecordDTO;
import com.fuel.consumption.dtos.FuelTabDTO;
import com.fuel.consumption.dtos.MonthlyStatsDTO;
import com.fuel.consumption.dtos.SumDataDTO;
import com.fuel.consumption.exceptions.InvalidMonthNumberException;
import com.fuel.consumption.service.FuelTabServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tab")
public class FuelTabController {
    private final FuelTabServiceImpl fuelTabServiceImpl;

    @Autowired
    public FuelTabController(FuelTabServiceImpl fuelTabServiceImpl) {
        this.fuelTabServiceImpl = fuelTabServiceImpl;
    }

    @PostMapping("/add/tabs")
    public ResponseEntity<List<FuelTab>> addFuelDataInBulk(@RequestBody List<FuelTabDTO> fuelTabDTOList){
        return new ResponseEntity<List<FuelTab>>(fuelTabServiceImpl.addFuelDataInBatch(fuelTabDTOList), HttpStatus.CREATED);
    }

/*    @PostMapping("/add" )
    public ResponseEntity<FuelTab> addFuelData(@RequestBody FuelTabDTO fuelTabDTO){
         return new ResponseEntity<>(fuelTabServiceImpl.addFuelData(fuelTabDTO), HttpStatus.CREATED);
    }


    @GetMapping("/tabs")
    public ResponseEntity<List<FuelTab>> getAllFuelTabs(){
        return new ResponseEntity<>(fuelTabServiceImpl.getAllForAllDrivers(), HttpStatus.OK);
    }

    @GetMapping("/{driverID}/tabs")
    public ResponseEntity<List<FuelTabDTO>> getAllFuelTabsByID(@PathVariable Long driverID){
        return new ResponseEntity<>(fuelTabServiceImpl.getAllByDriverID(driverID), HttpStatus.OK);
    }

    @GetMapping("/sums/monthly")
    public ResponseEntity<List<SumDataDTO>> getTotalSpentAmount(){
        return new ResponseEntity<>(fuelTabServiceImpl.getMonthlySumForAllDrivers(), HttpStatus.OK);
    }

    @GetMapping("/sums/{driverID}/monthly")
    public ResponseEntity<List<SumDataDTO>> getTotalSpentAmountById(@PathVariable Long driverID){
        return new ResponseEntity<>(fuelTabServiceImpl.getMonthlySumByDriverId(driverID), HttpStatus.OK);
    }

    @GetMapping("/records/{month}")
    public ResponseEntity<List<ConsumptionRecordDTO>> getConsumptionByMonth(@PathVariable int month) throws InvalidMonthNumberException {
        return new ResponseEntity<>(fuelTabServiceImpl.getConsumptionRecordsByMonth(month), HttpStatus.OK);
    }

    @GetMapping("/{driverId}/records/{month}")
    public ResponseEntity<List<ConsumptionRecordDTO>> getConsumptionByMonthAndId(@PathVariable Long driverId, @PathVariable Integer month) throws InvalidMonthNumberException*//*, InvalidDriverIdException*//* {
        return new ResponseEntity<>(fuelTabServiceImpl.getConsumptionRecordsByMonthAndId(driverId, month), HttpStatus.OK);
    }*/

    @GetMapping("/monthly/statistics")
    public ResponseEntity<MonthlyStatsDTO> getMonthlyStats(){
        return new ResponseEntity(fuelTabServiceImpl.getMonthlyStatistics(), HttpStatus.OK);
    }

    @GetMapping("/monthly/statistics/{driverId}")
    public ResponseEntity<MonthlyStatsDTO> getMonthlyStatsById(@PathVariable Long driverId){
            return new ResponseEntity(fuelTabServiceImpl.getMonthlyStatisticsById(driverId), HttpStatus.OK);
    }

   @DeleteMapping("/delete/tabs")
    public ResponseEntity deleteRecords(){
        fuelTabServiceImpl.deleteAllRecords();
        return new ResponseEntity(HttpStatus.OK);
    }
}
