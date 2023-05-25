package com.example.KursinisWebService.repository;

import com.example.KursinisWebService.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> { }