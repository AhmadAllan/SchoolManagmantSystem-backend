package com.schoolmanagementsystem.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.schoolmanagementsystem.server.models.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
     private EntityManager entityManager;

    public StudentDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> query = entityManager.createQuery("SELECT a FROM Student a", Student.class);
        return query.getResultList();
    }

    @Override
    public Student findByStudentId(Integer studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public Student saveStudent(Student student) {
        entityManager.persist(student);
        return student;
    }    

    @Override
    public void deleteStudent(Integer studentId) {
        Student student = entityManager.find(Student.class, studentId);
        if (student != null) {
            entityManager.remove(student);
        }
    }

    @Override
    public Student updateStudent(Student student) {
        return entityManager.merge(student);
    }
}
