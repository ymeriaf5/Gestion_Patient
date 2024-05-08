package com.example.springrev.security.Services;

import com.example.springrev.security.entities.AppRole;
import com.example.springrev.security.entities.AppUser;
import com.example.springrev.security.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface AccountService {

    AppUser addNewUser(String username,String password,String email,String confirmPassword);
    AppRole addNewRole(String role);
    void addRoleToUser(String username,String role);
    void removeRoleFromUser(String username,String role);
    AppUser loadUserByUsername(String username);
}
