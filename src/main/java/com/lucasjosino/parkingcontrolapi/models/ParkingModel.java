package com.lucasjosino.parkingcontrolapi.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingModel {
    private UUID id;
    private String license;
    private String state;
    private String model;
    private String color;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private Double bill;

    public ParkingModel(
        UUID id,
        String license,
        String state,
        String model,
        String color,
        LocalDateTime entryDate,
        LocalDateTime exitDate,
        Double bill
    ) {
        this.id = id;
        this.license = license;
        this.state = state;
        this.model = model;
        this.color = color;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.bill = bill;
    }

    public ParkingModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDateTime getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDateTime exitDate) {
        this.exitDate = exitDate;
    }

    public Double getBill() {
        return bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
    }
}
