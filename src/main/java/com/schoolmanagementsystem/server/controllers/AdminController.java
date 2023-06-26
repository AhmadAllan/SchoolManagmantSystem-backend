package com.schoolmanagementsystem.server.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagementsystem.server.models.Admin;
import com.schoolmanagementsystem.server.services.AdminServiceImpl;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private AdminServiceImpl adminServiceImpl;

    public AdminController(AdminServiceImpl adminServiceImpl) {
        this.adminServiceImpl = adminServiceImpl;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminServiceImpl.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("get/{adminId}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Integer adminId) {
        Admin admin = adminServiceImpl.getAdminById(adminId);
        if (admin != null) {
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminServiceImpl.createAdmin(admin);
        return new ResponseEntity<Admin>(createdAdmin, HttpStatus.CREATED);
    }

    @PutMapping("put/{adminId}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Integer adminId, @RequestBody Admin admin) {
        Admin existingAdmin = adminServiceImpl.getAdminById(adminId);
        if (existingAdmin != null) {
            admin.setAdminId(adminId);
            Admin updatedAdmin = adminServiceImpl.updateAdmin(admin);
            return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{adminId}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Integer adminId) {
        Admin admin = adminServiceImpl.getAdminById(adminId);
        if (admin != null) {
            adminServiceImpl.deleteAdmin(adminId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

}
