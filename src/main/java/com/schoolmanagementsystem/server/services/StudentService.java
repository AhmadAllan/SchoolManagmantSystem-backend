package com.schoolmanagementsystem.server.services;

import java.util.List;

import com.schoolmanagementsystem.server.models.Student;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(Integer studentId);
    Student getStudentWithParent(Integer studentId);
    void deleteStudent(Integer studentId);
    List<Student> getAllStudents();
    Student updateStudent(Student student);
}
