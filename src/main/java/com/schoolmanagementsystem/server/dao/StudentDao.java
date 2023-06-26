package com.schoolmanagementsystem.server.dao;

import java.util.List;

import com.schoolmanagementsystem.server.models.Student;

public interface StudentDao {
    
    List<Student> getAllStudents();
    Student findByStudentId(Integer studentId);
    Student saveStudent(Student student);
    void deleteStudent(Integer studentId);
    Student updateStudent(Student student);
}
