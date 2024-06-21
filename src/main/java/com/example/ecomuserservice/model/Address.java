package com.example.ecomuserservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ModelAttribute;

@Getter
@Setter
//@Entity
@Embeddable
public class Address {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    private String city;
    private String street;
    private String number;
    private String zipcode;
//    @OneToOne(cascade =CascadeType.ALL)
//    @JoinColumn(name="geolocation_id", referencedColumnName = "id")
    @Embedded
    private Geolocation geolocation;
}
