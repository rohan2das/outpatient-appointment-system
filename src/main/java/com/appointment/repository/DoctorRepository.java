package com.appointment.repository;

import com.appointment.model.Doctor;
import com.appointment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByUser(User user);
    List<Doctor> findByIsAvailable(boolean isAvailable);
    List<Doctor> findBySpecialization(String specialization);
}
