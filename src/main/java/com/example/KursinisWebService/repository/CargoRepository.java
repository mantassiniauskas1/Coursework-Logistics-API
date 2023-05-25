package com.example.KursinisWebService.repository;

import com.example.KursinisWebService.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CargoRepository extends JpaRepository<Cargo, Integer> { }