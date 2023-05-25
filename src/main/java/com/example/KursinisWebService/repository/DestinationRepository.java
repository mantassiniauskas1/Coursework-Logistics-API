package com.example.KursinisWebService.repository;

import com.example.KursinisWebService.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DestinationRepository extends JpaRepository<Destination, Integer> { }