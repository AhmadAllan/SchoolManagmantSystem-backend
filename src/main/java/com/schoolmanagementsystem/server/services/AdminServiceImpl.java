package com.schoolmanagementsystem.server.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.server.dao.AdminDaoImpl;
import com.schoolmanagementsystem.server.models.Admin;

@Service
public class AdminServiceImpl implements AdminService {
    private AdminDaoImpl adminDaoImpl;

    public AdminServiceImpl(AdminDaoImpl adminDaoImpl){
        this.adminDaoImpl = adminDaoImpl;
    }
    @Override
    public Admin createAdmin(Admin admin) {
        return adminDaoImpl.saveAdmin(admin);
    }

    @Override
    public Admin getAdminById(Integer adminId) {
        return adminDaoImpl.findByAdminId(adminId);
    }

    @Override
    public void deleteAdmin(Integer adminId) {
        adminDaoImpl.deleteAdmin(adminId);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminDaoImpl.getAllAdmins();
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return adminDaoImpl.updateAdmin(admin);
    }
    
}
