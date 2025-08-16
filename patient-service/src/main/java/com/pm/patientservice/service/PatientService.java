package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.exception.EmailAlreadyExistsException;
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

    // Service to get List of All Patients
    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();
//        return patients.stream().map(patient -> PatientMapper.toDTO(patient)).toList();
        return patients.stream().map(PatientMapper::toDTO).toList();
    }

    public Optional<PatientResponseDTO> getPatientByEmail(String email) {
        return Optional.of(PatientMapper.toDTO(patientRepository.findByEmail(email)));
    }

    // Service to Crate A New Patient
    public PatientResponseDTO createNewPatient(PatientRequestDTO patientRequestDTO) {

        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("A Patient With This Email Already Exists " + patientRequestDTO.getEmail());
        }

        Patient newPatient = PatientMapper.toModel(patientRequestDTO);
        return PatientMapper.toDTO(patientRepository.save(newPatient));
    }
}
