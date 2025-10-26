package com.appointment.repository;

import com.appointment.model.AvailabilityDates;
import com.appointment.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AvailabilityDatesRepository extends JpaRepository<AvailabilityDates, Long> {
    List<AvailabilityDates> findByDoctor(Doctor doctor);
    List<AvailabilityDates> findByDoctorAndIsActiveTrue(Doctor doctor);
    List<AvailabilityDates> findByDoctorAndFromDateLessThanEqualAndEndDateGreaterThanEqualAndIsActiveTrue(
            Doctor doctor, LocalDate date, LocalDate date2);
}
