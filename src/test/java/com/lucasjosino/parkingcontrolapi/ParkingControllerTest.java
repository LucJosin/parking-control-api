package com.lucasjosino.parkingcontrolapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucasjosino.parkingcontrolapi.models.dto.ParkingDTOModel;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SuppressWarnings({"SpellCheckingInspection", "unused"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ParkingControlAPIApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ParkingControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void shouldGetAllParkings() throws Exception {
        mockMvc.perform(get("/v1/parkings"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void shouldGetParkingById() throws Exception {
        ParkingDTOModel dtoModel = new ParkingDTOModel();
        dtoModel.setLicense("lorem ipsum");
        dtoModel.setState("CO");
        dtoModel.setModel("lorem ipsum");
        dtoModel.setColor(16777215);
        dtoModel.setBill(278d);

        String id = "b5532d8b-4f46-4c18-89be-ad0bfd4fdc9e";
        mockMvc.perform(get("/v1/parkings/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.license").value(dtoModel.getLicense()))
                .andExpect(jsonPath("$.state").value(dtoModel.getState()))
                .andExpect(jsonPath("$.model").value(dtoModel.getModel()))
                .andExpect(jsonPath("$.color").value(dtoModel.getColor()))
                .andExpect(jsonPath("$.bill").value(dtoModel.getBill()));
    }

    @Test
    public void shouldPostAParking() throws Exception {
        String str = "2022-11-19 11:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime exitDate = LocalDateTime.parse(str, formatter);

        ParkingDTOModel dtoModel = new ParkingDTOModel();
        dtoModel.setLicense("lorem ipsum");
        dtoModel.setState("AZ");
        dtoModel.setModel("lorem ipsum");
        dtoModel.setColor(3197951);
        dtoModel.setBill(133d);
        dtoModel.setExitDate(exitDate);
        dtoModel.setEntryDate(LocalDateTime.now());

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String data = mapper.writeValueAsString(dtoModel);

        System.out.println(data);

        mockMvc.perform(post("/v1/parkings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(data)
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void shouldDeleteAParking() throws Exception {
        String id = "2654886d-cc3a-4fe5-a265-f80896d9dfab";
        mockMvc.perform(delete("/v1/parkings/{id}", id))
                .andExpect(status().isNoContent());
    }
}
