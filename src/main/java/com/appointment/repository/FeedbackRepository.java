package com.appointment.repository;

import com.appointment.model.Doctor;
import com.appointment.model.Feedback;
import com.appointment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByDoctor(Doctor doctor);
    List<Feedback> findByPatient(Patient patient);
}
