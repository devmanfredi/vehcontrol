package com.orangetalents.vecontrol.model;

import com.orangetalents.vecontrol.dto.UserDto;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private LocalDate birthdayDate;
    private String document;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Vehicle> vehicles = new ArrayList<>();

    public User(String name, String email, LocalDate birthdayDate, String document) {
        this.name = name;
        this.email = email;
        this.birthdayDate = birthdayDate;
        this.document = document;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(LocalDate birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.name = userDto.getName();
        user.document = userDto.getDocument();
        user.email = userDto.getEmail();
        user.birthdayDate = userDto.getBirthdayDate();
        user.id = null;
        return user;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
