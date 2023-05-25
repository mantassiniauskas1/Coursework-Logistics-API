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

public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cargoID;

    @Column(name = "cargoMassKg")
    private int cargoMassKg;

    @Column(name = "description")
    private String description;

    @Column(name = "inOrder")
    private String inOrder;

}