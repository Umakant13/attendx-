package com.tka.service;


import java.util.List;
import com.tka.entity.Admin;

public interface AdminService {
    List<Admin> getAllAdmins();
    Admin getAdminById(Long id);
    void saveAdmin(Admin admin);
    void deleteAdmin(Long id);
}