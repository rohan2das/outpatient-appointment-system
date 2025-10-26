package com.appointment.service.impl;

import com.appointment.model.AvailabilityDates;
import com.appointment.model.Doctor;
import com.appointment.repository.AvailabilityDatesRepository;
import com.appointment.service.AvailabilityDatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AvailabilityDatesServiceImpl implements AvailabilityDatesService {

    private final AvailabilityDatesRepository availabilityDatesRepository;

    @Autowired
    public AvailabilityDatesServiceImpl(AvailabilityDatesRepository availabilityDatesRepository) {
        this.availabilityDatesRepository = availabilityDatesRepository;
    }

    @Override
    public AvailabilityDates createAvailability(AvailabilityDates availabilityDates) {
        return availabilityDatesRepository.save(availabilityDates);
    }

    @Override
    public List<AvailabilityDates> getAllAvailabilityDates() {
        return availabilityDatesRepository.findAll();
    }

    @Override
    public Optional<AvailabilityDates> getAvailabilityDatesById(Long id) {
        return availabilityDatesRepository.findById(id);
    }

    @Override
    public List<AvailabilityDates> getAvailabilityDatesByDoctor(Doctor doctor) {
        return availabilityDatesRepository.findByDoctor(doctor);
    }

    @Override
    public List<AvailabilityDates> getActiveAvailabilityDatesByDoctor(Doctor doctor) {
        return availabilityDatesRepository.findByDoctorAndIsActiveTrue(doctor);
    }

    @Override
    public List<AvailabilityDates> getAvailabilityDatesByDoctorAndDate(Doctor doctor, LocalDate date) {
        return availabilityDatesRepository.findByDoctorAndFromDateLessThanEqualAndEndDateGreaterThanEqualAndIsActiveTrue(
                doctor, date, date);
    }

    @Override
    public AvailabilityDates updateAvailabilityDates(AvailabilityDates availabilityDates) {
        return availabilityDatesRepository.save(availabilityDates);
    }

    @Override
    public void deleteAvailabilityDates(Long id) {
        availabilityDatesRepository.deleteById(id);
    }
}
