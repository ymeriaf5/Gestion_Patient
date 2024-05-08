package com.example.springrev.Services;

import com.example.springrev.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface PatientService {
    Page<Patient> getAllPatients(PageRequest pageRequest);
    Page<Patient> getAllPatientsbyNom(PageRequest pageRequest,String keyword);
    void delete(Long id);
    void save(Patient patient);
    Patient getPatientbyId(Long id);

}
