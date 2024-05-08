package com.example.springrev.security.repositories;

import com.example.springrev.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUserName(String username);
}
