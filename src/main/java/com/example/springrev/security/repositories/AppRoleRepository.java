package com.example.springrev.security.repositories;

import com.example.springrev.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;

public interface AppRoleRepository extends JpaRepository<AppRole,String> {
}
