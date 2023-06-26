package com.schoolmanagementsystem.server.services;

import java.util.List;


import com.schoolmanagementsystem.server.models.Admin;

public interface AdminService {
    Admin createAdmin(Admin admin);
    Admin getAdminById(Integer adminId);
    void deleteAdmin(Integer adminId);
    List<Admin> getAllAdmins();
    Admin updateAdmin(Admin admin);
}
