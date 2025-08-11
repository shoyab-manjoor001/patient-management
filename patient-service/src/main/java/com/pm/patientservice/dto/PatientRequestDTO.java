package com.pm.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {

    @NotBlank(message = "Name is Required")
    @Size(min = 1, max = 100,message = "Name cannot exceed 100 Characters")
    private String name;

    @NotBlank(message = "Email is Required")
    @Email(message = "Email Should Be Valid")
    private String email;

    @NotBlank(message = "Date of Birth is required")
    private String dateOfBirth;

    @NotBlank(message = "Address is Required")
    private String address;

    @NotBlank(message = "Registered Date is Required")
    private String registeredDate;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

}
