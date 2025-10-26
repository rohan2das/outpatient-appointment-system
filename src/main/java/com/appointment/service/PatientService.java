package com.appointment.service;

import com.appointment.model.Patient;
import com.appointment.model.User;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    Patient createPatient(Patient patient);
    List<Patient> getAllPatients();
    Optional<Patient> getPatientById(Long id);
    Optional<Patient> getPatientByUser(User user);
    Patient updatePatient(Patient patient);
    void deletePatient(Long id);
}
