package com.appointment.service;

import com.appointment.model.Doctor;
import com.appointment.model.Feedback;
import com.appointment.model.Patient;

import java.util.List;
import java.util.Optional;

public interface FeedbackService {
    Feedback createFeedback(Feedback feedback);
    List<Feedback> getAllFeedback();
    Optional<Feedback> getFeedbackById(Long id);
    List<Feedback> getFeedbackByDoctor(Doctor doctor);
    List<Feedback> getFeedbackByPatient(Patient patient);
    Feedback updateFeedback(Feedback feedback);
    void deleteFeedback(Long id);
}
