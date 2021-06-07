package com.orangetalents.vecontrol.repository;

import com.orangetalents.vecontrol.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findAllByUserId(Long userId);
}
