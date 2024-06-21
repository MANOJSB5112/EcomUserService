package com.example.ecomuserservice.dto;

import com.example.ecomuserservice.model.Address;
import com.example.ecomuserservice.model.Name;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.ecomuserservice.model.User}
 */
@Value
public class UserDto implements Serializable {
    Long id;
    String email;
    String username;
    String password;
    Name name;
    Address address;
    String phone;
}