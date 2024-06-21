package com.example.ecomuserservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ModelAttribute;


@Getter
@Setter
@Entity

public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String username;
    private String password;

  //  @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "name_id", referencedColumnName = "id")
    @Embedded
    private Name name;

   // @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "address_id", referencedColumnName = "id")
    @Embedded
    private Address address;

    private String phone;
}
