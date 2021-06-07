package com.orangetalents.vecontrol.model;

import com.orangetalents.vecontrol.dto.VehicleDto;

import javax.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private int year;
    private String value;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public Vehicle(Long id, String brand, String model, int year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public Vehicle() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static Vehicle toEntity(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.brand = vehicleDto.getBrand();
        vehicle.model = vehicleDto.getModel();
        vehicle.year = vehicleDto.getYear();
        return vehicle;
    }
}
