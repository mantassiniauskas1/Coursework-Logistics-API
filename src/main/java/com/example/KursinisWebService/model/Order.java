package com.example.KursinisWebService.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`order`")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "driverId")
    private int driverId;

    @Column(name = "vehicleLicensePlate")
    private String vehicleLicensePlate;

    @Column(name = "cargoId")
    private int cargoId;

    @Column(name = "destinationId")
    private String destinationId;

    @Column(name = "status")
    private String status;



}