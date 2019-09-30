package com.fuel.consumption.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuel.consumption.dao.dtos.ConsumptionRecordDTO;
import com.fuel.consumption.dao.dtos.FuelTabDTO;
import com.fuel.consumption.util.exceptions.InvalidMonthNumberException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FuelTabController.class)
public class FuelTabControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private FuelTabController fuelTabController;

    @Test
    public void addFuelData() throws Exception {
        FuelTabDTO fuelTabDTO = new FuelTabDTO();
        fuelTabDTO.setFuelType("D");
        fuelTabDTO.setUnitPrice(3.5);
        fuelTabDTO.setPurchasedVolume(8.35);
        fuelTabDTO.setPurchaseDate("04.23.2019");
        fuelTabDTO.setDriverID(43521L);
        mockMvc.perform(post("/tab/add").contentType(MediaType.APPLICATION_JSON_UTF8).
                content(objectMapper.writeValueAsString(fuelTabDTO))).andExpect(status().isCreated());
    }

    @Test
    public void getConsumptionByMonthAndId() throws InvalidMonthNumberException, Exception {
        List<ConsumptionRecordDTO> dtos = new ArrayList<>();
        given(fuelTabController.getConsumptionByMonthAndId(12345L, 3)).willReturn(new ResponseEntity<>(dtos, HttpStatus.OK));
        mockMvc.perform(get("/tab/12345/records/1")).andExpect(status().isOk());
    }
}
