package com.pm.patientservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyExistsException(EmailAlreadyExistsException emailAlreadyExistsException) {

        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Email Already Exists");
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PatientNotFoundException.class)
   public ResponseEntity<Map<String,String>> handlePatientNotFoundException(PatientNotFoundException patientNotFoundException) {

        Map<String,String> errors = new HashMap<>();
        errors.put("message", "Patient Not Found");
        return new  ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
}


