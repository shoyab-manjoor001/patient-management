package com.pm.patientservice.controller;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
@Tag(name = "Patient-Service",description = "API Documentation of Patient Micro-Service")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @Operation(description = "API to Get All Patient at a time",summary = "Get All Patients")
    @GetMapping("/getall")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {

        List<PatientResponseDTO> patients = patientService.getPatients();

        return ResponseEntity.ok().body(patients);
    }

    @Operation(summary = "Get A Patient",description = "API to Get A Patient at a time using Email Id")
    @GetMapping("/getPatient/{email}")
    public Optional<PatientResponseDTO> getPatient(@PathVariable String email) {
        return patientService.getPatientByEmail(email);
    }

    @Operation(summary = "Create A Patient",description = "API to Create A New Patient")
    @PostMapping
    public ResponseEntity<PatientResponseDTO> newPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO patientResponseDTO = patientService.createNewPatient(patientRequestDTO);
        return ResponseEntity.ok().body(patientResponseDTO);
    }

    @Operation(summary = "Update A Patient",description = "API to Update A Patient at a time using Id")
    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id, @Valid @RequestBody PatientRequestDTO patientRequestDTO) {

        PatientResponseDTO patientResponseDTO = patientService.updatePatient(id, patientRequestDTO);
        return ResponseEntity.ok().body(patientResponseDTO);
    }

    @Operation(summary = "Delete A Patient",description = "API to Delete A Patient at a time using Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
