package com.appointment.controller;

import com.appointment.model.Patient;
import com.appointment.model.User;
import com.appointment.service.PatientService;
import com.appointment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {

    private final PatientService patientService;
    private final UserService userService;

    @Autowired
    public PatientController(PatientService patientService, UserService userService) {
        this.patientService = patientService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createPatient(@RequestBody Patient patient) {
        // Validate that user is provided
        if (patient.getUser() == null || patient.getUser().getId() == null) {
            return new ResponseEntity<>(
                new ErrorResponse("User ID is required. Please provide a valid user ID."),
                HttpStatus.BAD_REQUEST
            );
        }
        
        // Validate that user exists
        Optional<User> user = userService.getUserById(patient.getUser().getId());
        if (user.isEmpty()) {
            return new ResponseEntity<>(
                new ErrorResponse("User with ID " + patient.getUser().getId() + " not found."),
                HttpStatus.BAD_REQUEST
            );
        }
        
        // Set the full user object
        patient.setUser(user.get());
        
        try {
            Patient createdPatient = patientService.createPatient(patient);
            return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(
                new ErrorResponse("Error creating patient: " + e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
    
    // Inner class for error responses
    private static class ErrorResponse {
        private String message;
        
        public ErrorResponse(String message) {
            this.message = message;
        }
        
        public String getMessage() {
            return message;
        }
        
        public void setMessage(String message) {
            this.message = message;
        }
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Optional<Patient> patient = patientService.getPatientById(id);
        return patient.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Patient> getPatientByUserId(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            Optional<Patient> patient = patientService.getPatientByUser(user.get());
            return patient.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        Optional<Patient> existingPatient = patientService.getPatientById(id);
        if (existingPatient.isPresent()) {
            patient.setId(id);
            Patient updatedPatient = patientService.updatePatient(patient);
            return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        Optional<Patient> patient = patientService.getPatientById(id);
        if (patient.isPresent()) {
            patientService.deletePatient(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
