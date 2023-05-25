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
@Table(name = "vehicle")
public class Vehicle {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "licensePlate")
    private String licensePlate;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "yearOfManifacture")
    private int yearOfManifacture;

    @Column(name = "mileage")
    private int mileage;

    @Column(name = "weightCapacityKg")
    private String weightCapacityKg;

    @Column(name = "fuelCapacityL")
    private String fuelCapacityL;

    @Column(name = "isTaken")
    private String isTaken;

}
