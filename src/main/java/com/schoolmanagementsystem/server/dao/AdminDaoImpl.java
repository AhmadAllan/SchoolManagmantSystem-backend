package com.schoolmanagementsystem.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.schoolmanagementsystem.server.models.Admin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {
    private EntityManager entityManager;

    public AdminDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Admin> getAllAdmins() {
        TypedQuery<Admin> query = entityManager.createQuery("SELECT a FROM Admin a", Admin.class);
        return query.getResultList();
    }

    @Override
    public Admin findByAdminId(Integer adminId) {
        return entityManager.find(Admin.class, adminId);
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        entityManager.persist(admin);
        return admin;
    }    

    @Override
    public void deleteAdmin(Integer adminId) {
        Admin admin = entityManager.find(Admin.class, adminId);
        if (admin != null) {
            entityManager.remove(admin);
        }
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return entityManager.merge(admin);
    }

}
