package com.example.springrev.repositories;

import com.example.springrev.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRep extends JpaRepository<Patient,Long> {
}
