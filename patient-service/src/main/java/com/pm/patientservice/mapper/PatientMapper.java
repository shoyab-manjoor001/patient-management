package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;

public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient)
    {
            PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
            patientResponseDTO.setId(patient.getId().toString());
            patientResponseDTO.setName(patient.getName());
            patientResponseDTO.setAddress(patient.getAddress());
            patientResponseDTO.setDateOfBirth(patient.getDateOfBirth().toString());
            patientResponseDTO.setEmail(patient.getEmail());
            return patientResponseDTO;
    }
}
