package com.pm.patientservice.exception;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(String msg) {
        super(msg);
    }
}
