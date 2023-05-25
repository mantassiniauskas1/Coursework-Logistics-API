package com.example.KursinisWebService.repository;

import com.example.KursinisWebService.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OrderRepository extends JpaRepository<Order, Integer> { }