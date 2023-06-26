package com.schoolmanagementsystem.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.schoolmanagementsystem.server.models.Teacher;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TeacherDaoImpl implements TeacherDao {

    private EntityManager entityManager;

    public TeacherDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        TypedQuery<Teacher> query = entityManager.createQuery("SELECT a FROM Teacher a", Teacher.class);
        return query.getResultList();
    }

    @Override
    public Teacher findByTeacherId(Integer teacherId) {
        return entityManager.find(Teacher.class, teacherId);
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }    

    @Override
    public void deleteTeacher(Integer teacherId) {
        Teacher teacher = entityManager.find(Teacher.class, teacherId);
        if (teacher != null) {
            entityManager.remove(teacher);
        }
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return entityManager.merge(teacher);
    }
    
}
