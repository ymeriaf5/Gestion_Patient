package com.example.springrev.Services;


import com.example.springrev.entities.Patient;
import com.example.springrev.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImp implements PatientService{
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Page<Patient> getAllPatients(PageRequest pageRequest) {
        return patientRepository.findAll(pageRequest);
    }

    @Override
    public Page<Patient> getAllPatientsbyNom(PageRequest pageRequest, String keyword) {
        return patientRepository.findByNomContains(keyword,pageRequest);
    }

    @Override
    public void delete(Long id) {
         patientRepository.deleteById(id);
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient getPatientbyId(Long id) {
        return patientRepository.findPatientById(id);
    }
}
