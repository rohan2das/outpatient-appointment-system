package com.appointment.controller;

import com.appointment.model.AvailabilityDates;
import com.appointment.model.Doctor;
import com.appointment.service.AvailabilityDatesService;
import com.appointment.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityDatesController {

    private final AvailabilityDatesService availabilityDatesService;
    private final DoctorService doctorService;

    @Autowired
    public AvailabilityDatesController(AvailabilityDatesService availabilityDatesService, DoctorService doctorService) {
        this.availabilityDatesService = availabilityDatesService;
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<AvailabilityDates> createAvailability(@RequestBody AvailabilityDates availabilityDates) {
        AvailabilityDates createdAvailability = availabilityDatesService.createAvailability(availabilityDates);
        return new ResponseEntity<>(createdAvailability, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AvailabilityDates>> getAllAvailabilityDates() {
        List<AvailabilityDates> availabilityDates = availabilityDatesService.getAllAvailabilityDates();
        return new ResponseEntity<>(availabilityDates, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvailabilityDates> getAvailabilityDatesById(@PathVariable Long id) {
        Optional<AvailabilityDates> availabilityDates = availabilityDatesService.getAvailabilityDatesById(id);
        return availabilityDates.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AvailabilityDates>> getAvailabilityDatesByDoctor(@PathVariable Long doctorId) {
        Optional<Doctor> doctor = doctorService.getDoctorById(doctorId);
        if (doctor.isPresent()) {
            List<AvailabilityDates> availabilityDates = availabilityDatesService.getAvailabilityDatesByDoctor(doctor.get());
            return new ResponseEntity<>(availabilityDates, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/doctor/{doctorId}/active")
    public ResponseEntity<List<AvailabilityDates>> getActiveAvailabilityDatesByDoctor(@PathVariable Long doctorId) {
        Optional<Doctor> doctor = doctorService.getDoctorById(doctorId);
        if (doctor.isPresent()) {
            List<AvailabilityDates> availabilityDates = availabilityDatesService.getActiveAvailabilityDatesByDoctor(doctor.get());
            return new ResponseEntity<>(availabilityDates, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/doctor/{doctorId}/date")
    public ResponseEntity<List<AvailabilityDates>> getAvailabilityDatesByDoctorAndDate(
            @PathVariable Long doctorId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        Optional<Doctor> doctor = doctorService.getDoctorById(doctorId);
        if (doctor.isPresent()) {
            List<AvailabilityDates> availabilityDates = availabilityDatesService.getAvailabilityDatesByDoctorAndDate(doctor.get(), date);
            return new ResponseEntity<>(availabilityDates, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvailabilityDates> updateAvailabilityDates(@PathVariable Long id, @RequestBody AvailabilityDates availabilityDates) {
        Optional<AvailabilityDates> existingAvailability = availabilityDatesService.getAvailabilityDatesById(id);
        if (existingAvailability.isPresent()) {
            availabilityDates.setId(id);
            AvailabilityDates updatedAvailability = availabilityDatesService.updateAvailabilityDates(availabilityDates);
            return new ResponseEntity<>(updatedAvailability, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvailabilityDates(@PathVariable Long id) {
        Optional<AvailabilityDates> availabilityDates = availabilityDatesService.getAvailabilityDatesById(id);
        if (availabilityDates.isPresent()) {
            availabilityDatesService.deleteAvailabilityDates(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
