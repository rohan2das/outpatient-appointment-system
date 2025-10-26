package com.appointment.service;

import com.appointment.model.AvailabilityDates;
import com.appointment.model.Doctor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AvailabilityDatesService {
    AvailabilityDates createAvailability(AvailabilityDates availabilityDates);
    List<AvailabilityDates> getAllAvailabilityDates();
    Optional<AvailabilityDates> getAvailabilityDatesById(Long id);
    List<AvailabilityDates> getAvailabilityDatesByDoctor(Doctor doctor);
    List<AvailabilityDates> getActiveAvailabilityDatesByDoctor(Doctor doctor);
    List<AvailabilityDates> getAvailabilityDatesByDoctorAndDate(Doctor doctor, LocalDate date);
    AvailabilityDates updateAvailabilityDates(AvailabilityDates availabilityDates);
    void deleteAvailabilityDates(Long id);
}
