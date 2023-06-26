package com.schoolmanagementsystem.server.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.server.dao.ParentDaoImpl;
import com.schoolmanagementsystem.server.dao.StudentDaoImpl;
import com.schoolmanagementsystem.server.models.Student;
import com.schoolmanagementsystem.server.models.Parent;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDaoImpl studentDaoImpl;
    private final ParentDaoImpl parentDaoImpl;

    public StudentServiceImpl(StudentDaoImpl studentDaoImpl, ParentDaoImpl parentDaoImpl){
        this.studentDaoImpl = studentDaoImpl;
        this.parentDaoImpl = parentDaoImpl;
    }
    @Override
    public Student createStudent(Student student) {
        Parent parent = parentDaoImpl.findByParentId(student.getParentId());
        if (parent != null) {
            student.setParent(parent);
            return studentDaoImpl.saveStudent(student);
        } else {
            System.out.println("parent not found");
            return null;
        }
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentDaoImpl.findByStudentId(studentId);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentDaoImpl.deleteStudent(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDaoImpl.getAllStudents();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentDaoImpl.updateStudent(student);
    }
    @Override
    public Student getStudentWithParent(Integer studentId) {
        Student student = studentDaoImpl.findByStudentId(studentId);
        if (student != null) {
            student.getParent();
        }
        return student;
    }
}
