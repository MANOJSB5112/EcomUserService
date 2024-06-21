package com.example.ecomuserservice.repo;

import com.example.ecomuserservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
