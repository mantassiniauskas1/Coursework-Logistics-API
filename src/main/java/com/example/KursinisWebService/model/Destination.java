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

public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int destinationID;

    @Column(name = "destinationFrom")
    private String destinationFrom;

    @Column(name = "destinationTo")
    private String destinationTo;

    @Column(name = "additionalStops")
    private String additionalStops;

    @Column(name = "distanceKm")
    private int distanceKm;
}
