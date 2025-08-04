package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repo.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();
//        return patients.stream().map(patient -> PatientMapper.toDTO(patient)).toList();
        return patients.stream().map(PatientMapper::toDTO).toList();
    }

    public Optional<PatientResponseDTO> getPatientByEmail(String email) {
        return Optional.of(PatientMapper.toDTO(patientRepository.findByEmail(email)));
    }
}
