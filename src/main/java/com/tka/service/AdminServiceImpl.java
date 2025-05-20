package com.tka.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tka.dao.AdminDAO;
import com.tka.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Admin> getAllAdmins() {
        return adminDAO.getAllAdmins();
    }

    @Override
    @Transactional(readOnly = true)
    public Admin getAdminById(Long id) {
        return adminDAO.getAdminById(id);
    }

    @Override
    @Transactional
    public void saveAdmin(Admin admin) {
        adminDAO.saveAdmin(admin);
    }

    @Override
    @Transactional
    public void deleteAdmin(Long id) {
        adminDAO.deleteAdmin(id);
    }
}