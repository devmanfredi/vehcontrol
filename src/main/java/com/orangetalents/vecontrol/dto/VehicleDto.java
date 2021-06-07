package com.orangetalents.vecontrol.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VehicleDto {

    @NotNull(message = "Brand cannot be null")
    @NotEmpty(message = "Brand cannot be empty")
    private String brand;

    @NotNull(message = "Model cannot be null")
    @NotEmpty(message = "Model cannot be empty")
    private String model;

    @NotNull(message = "Year cannot be null")
    private int year;

    @JsonProperty("user_id")
    private Long userId;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
