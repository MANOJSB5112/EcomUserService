package com.example.ecomuserservice.service;

import com.example.ecomuserservice.dto.UserDto;
import com.example.ecomuserservice.model.Address;
import com.example.ecomuserservice.model.Geolocation;
import com.example.ecomuserservice.model.Name;
import com.example.ecomuserservice.model.User;
import com.example.ecomuserservice.repo.UserRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
@Qualifier("selfUserService")
public class SelfUserService implements UserService {
    UserRepo userRepo;

    @Autowired
    SelfUserService(UserRepo userRepo)
    {
        this.userRepo=userRepo;
    }

    User updateExistingUser(User existing,User toBeUpdated)
    {

        existing.setEmail(toBeUpdated.getEmail());
        existing.setUsername(toBeUpdated.getUsername());
        existing.setPassword(toBeUpdated.getPassword());
        existing.setName(new Name());
        // user.getName().setId(user.getId());
        existing.getName().setFirstname(toBeUpdated.getName().getFirstname());
        existing.getName().setLastname(toBeUpdated.getName().getLastname());
        existing.setAddress(new Address());
        // user.getAddress().setId(userDto.getId());
        existing.getAddress().setCity(toBeUpdated.getAddress().getCity());
        existing.getAddress().setStreet(toBeUpdated.getAddress().getStreet());
        existing.getAddress().setNumber(toBeUpdated.getAddress().getStreet());
        existing.getAddress().setZipcode(toBeUpdated.getAddress().getZipcode());
        existing.getAddress().setGeolocation(new Geolocation());
        // user.getAddress().getGeolocation().setId(userDto.getId());
        existing.getAddress().getGeolocation().setLat(toBeUpdated.getAddress().getGeolocation().getLat());
        existing.getAddress().getGeolocation().setLng(toBeUpdated.getAddress().getGeolocation().getLng());
        existing.setPhone(toBeUpdated.getPhone());
        return existing;
    }


    @Override
    public List<User> getAllUsers() {
        List<User> ans=userRepo.findAll();
        return ans;
    }

    @Override
    public User getSingleUser(Long id) throws Exception {

       Optional<User> ans=userRepo.findById(id);
        if(ans.isPresent())
        {
            User user=ans.get();
            return user;
        }else {
            throw new Exception("Could not find User with that ID");
        }
    }

    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void updateUser(Long id,User user) throws Exception {
       Optional<User> result=userRepo.findById(id);
       if(result.isPresent())
       {
           User ans= result.get();
           User updatedUser=updateExistingUser(ans,user);
           userRepo.save(updatedUser);
       }else
       {
           throw new Exception("Could not update the product as ID does not exist ");
       }
    }

    @Override
    public void deleteUser(Long id) throws Exception {
      Optional<User> result=userRepo.findById(id);
      if(result.isPresent())
      {
          //User toBeDeleted=result.get();
          userRepo.deleteById(id);
      }else {
          throw new Exception("Product doesnt exist to delete");
      }
    }
}
