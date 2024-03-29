
package com.fuel.consumption.controller;

import com.fuel.consumption.domain.FuelTab;
import com.fuel.consumption.dao.dtos.ConsumptionRecordDTO;
import com.fuel.consumption.dao.dtos.FuelTabDTO;
import com.fuel.consumption.dao.dtos.MonthlyStatsDTO;
import com.fuel.consumption.dao.dtos.SumDataDTO;
import com.fuel.consumption.util.exceptions.InvalidMonthNumberException;
import com.fuel.consumption.service.FuelTabServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @ResponseStatus(HttpStatus.CREATED)
    public List<FuelTab> addFuelDataInBulk(@Valid @RequestBody List<FuelTabDTO> fuelTabDTOList){
        return fuelTabServiceImpl.addFuelDataInBatch(fuelTabDTOList);
    }

    @PostMapping("/add" )
    @ResponseStatus(HttpStatus.CREATED)
    public FuelTab addFuelData(@Valid @RequestBody FuelTabDTO fuelTabDTO){
         return fuelTabServiceImpl.addFuelData(fuelTabDTO);
    }


    @GetMapping("/tabs")
    public ResponseEntity<?> getAllFuelTabs(){
        return new ResponseEntity<>(fuelTabServiceImpl.getAllForAllDrivers(), HttpStatus.OK);
    }

    @GetMapping("/{driverID}/tabs")
    public ResponseEntity<?> getAllFuelTabsByID(@PathVariable Long driverID){
        return new ResponseEntity<>(fuelTabServiceImpl.getAllByDriverID(driverID), HttpStatus.OK);
    }

    @GetMapping("/sums/monthly")
    public ResponseEntity<?> getTotalSpentAmount(){
        return new ResponseEntity<>(fuelTabServiceImpl.getMonthlySumForAllDrivers(), HttpStatus.OK);
    }

    @GetMapping("/sums/{driverID}/monthly")
    public ResponseEntity<?> getTotalSpentAmountById(@PathVariable Long driverID){
        return new ResponseEntity<>(fuelTabServiceImpl.getMonthlySumByDriverId(driverID), HttpStatus.OK);
    }

    @GetMapping("/records/{month}")
    public ResponseEntity<?> getConsumptionByMonth(@PathVariable int month) throws InvalidMonthNumberException {
        return new ResponseEntity<>(fuelTabServiceImpl.getConsumptionRecordsByMonth(month), HttpStatus.OK);
    }

    @GetMapping("/{driverId}/records/{month}")
    public ResponseEntity<List<ConsumptionRecordDTO>> getConsumptionByMonthAndId(@PathVariable Long driverId, @PathVariable Integer month) throws InvalidMonthNumberException {
        return new ResponseEntity<>(fuelTabServiceImpl.getConsumptionRecordsByMonthAndId(driverId, month), HttpStatus.OK);
    }

    @GetMapping("/monthly/statistics")
    public ResponseEntity<?> getMonthlyStats(){
        return new ResponseEntity<>(fuelTabServiceImpl.getMonthlyStatistics(), HttpStatus.OK);
    }

    @GetMapping("/monthly/statistics/{driverId}")
    public ResponseEntity<?> getMonthlyStatsById(@PathVariable Long driverId){
            return new ResponseEntity<>(fuelTabServiceImpl.getMonthlyStatisticsById(driverId), HttpStatus.OK);
    }

   @DeleteMapping("/delete/tabs")
    public ResponseEntity deleteRecords(){
        fuelTabServiceImpl.deleteAllRecords();
        return new ResponseEntity(HttpStatus.OK);
    }
}
