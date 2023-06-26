package com.schoolmanagementsystem.server.dao;

import java.util.List;

import com.schoolmanagementsystem.server.models.Admin;

public interface AdminDao{
    List<Admin> getAllAdmins();
    Admin findByAdminId(Integer adminId);
    Admin saveAdmin(Admin admin);
    void deleteAdmin(Integer adminId);
    Admin updateAdmin(Admin admin);
}
