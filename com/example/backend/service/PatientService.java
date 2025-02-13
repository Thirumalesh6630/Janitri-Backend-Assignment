package com.example.backend.service;

import com.example.backend.entity.Patient;
import com.example.backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
        org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }
}