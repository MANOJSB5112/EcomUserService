package com.example.ecomuserservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
//@Entity
@Embeddable
public class Geolocation{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    private String lat;
    private String lng;
}
