package com.example.ecomuserservice.service;

import com.example.ecomuserservice.dto.UserDto;
import com.example.ecomuserservice.model.Address;
import com.example.ecomuserservice.model.Geolocation;
import com.example.ecomuserservice.model.Name;
import com.example.ecomuserservice.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
@Getter
@Setter
public class FakeUserService implements UserService {
    RestTemplate restTemplate;
    @Autowired
    FakeUserService(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
    }

   User convertUserDto(UserDto userDto)
   {
       User user=new User();
       //user.setId(userDto.getId());
       user.setEmail(userDto.getEmail());
       user.setUsername(userDto.getUsername());
       user.setPassword(userDto.getPassword());
       user.setName(new Name());
      // user.getName().setId(user.getId());
       user.getName().setFirstname(userDto.getName().getFirstname());
       user.getName().setLastname(userDto.getName().getLastname());
       user.setAddress(new Address());
      // user.getAddress().setId(userDto.getId());
       user.getAddress().setCity(userDto.getAddress().getCity());
       user.getAddress().setStreet(userDto.getAddress().getStreet());
       user.getAddress().setNumber(userDto.getAddress().getStreet());
       user.getAddress().setZipcode(userDto.getAddress().getZipcode());
       user.getAddress().setGeolocation(new Geolocation());
      // user.getAddress().getGeolocation().setId(userDto.getId());
       user.getAddress().getGeolocation().setLat(userDto.getAddress().getGeolocation().getLat());
       user.getAddress().getGeolocation().setLng(userDto.getAddress().getGeolocation().getLng());
       user.setPhone(userDto.getPhone());
       return user;
   }





    @Override
    public List<User> getAllUsers() {
        UserDto[] result=restTemplate.getForObject("https://fakestoreapi.com/users",UserDto[].class);
        List<User> ans=new ArrayList<>();

        assert result != null;
        for(UserDto uto: result)
        {
            ans.add(convertUserDto(uto));
        }
        return ans;
    }

    @Override
    public User getSingleUser(Long id) {
        UserDto result=restTemplate.getForObject("https://fakestoreapi.com/users/1",UserDto.class);
        assert result != null;
        return convertUserDto(result);
    }

    @Override
    public void addUser(User user) {

    }


    @Override
    public void updateUser(Long id, User user) {

    }

    @Override
    public void deleteUser(Long id) {

    }
}
