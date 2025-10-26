package com.appointment.service;

import com.appointment.model.Doctor;
import com.appointment.model.User;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    Doctor createDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
    Optional<Doctor> getDoctorById(Long id);
    Optional<Doctor> getDoctorByUser(User user);
    List<Doctor> getAvailableDoctors();
    List<Doctor> getDoctorsBySpecialization(String specialization);
    Doctor updateDoctor(Doctor doctor);
    void deleteDoctor(Long id);
}
