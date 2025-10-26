package com.appointment.service;

import com.appointment.model.Appointment;
import com.appointment.model.Doctor;
import com.appointment.model.Patient;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Appointment createAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    Optional<Appointment> getAppointmentById(Long id);
    List<Appointment> getAppointmentsByPatient(Patient patient);
    List<Appointment> getAppointmentsByDoctor(Doctor doctor);
    List<Appointment> getAppointmentsByStatus(Appointment.Status status);
    Appointment updateAppointment(Appointment appointment);
    Appointment approveAppointment(Long id);
    Appointment rejectAppointment(Long id);
    Appointment cancelAppointment(Long id);
    void deleteAppointment(Long id);
    List<Appointment> getDoctorAppointmentsForDay(Doctor doctor, LocalDateTime date);
}
