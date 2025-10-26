package com.appointment.service;

import com.appointment.model.Admin;

import java.util.List;
import java.util.Optional;

import com.appointment.model.User;

public interface AdminService {
    Admin createAdmin(Admin admin);
    List<Admin> getAllAdmins();
    Optional<Admin> getAdminById(Long id);
    Optional<Admin> getAdminByUser(User user);
    Admin updateAdmin(Admin admin);
    void deleteAdmin(Long id);
}
