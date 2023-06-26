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

import com.schoolmanagementsystem.server.dao.ParentDaoImpl;
import com.schoolmanagementsystem.server.models.Parent;
import com.schoolmanagementsystem.server.models.Student;
import com.schoolmanagementsystem.server.services.StudentServiceImpl;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentServiceImpl studentServiceImpl;
    private final ParentDaoImpl parentDaoImpl;

    public StudentController(StudentServiceImpl studentServiceImpl, ParentDaoImpl parentDaoImpl){
        this.studentServiceImpl = studentServiceImpl;
        this.parentDaoImpl = parentDaoImpl;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentServiceImpl.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("get/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId) {
        Student student = studentServiceImpl.getStudentById(studentId);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Parent parent = parentDaoImpl.findByParentId(student.getParentId());
        if (parent != null) {
            Student createdStudent = studentServiceImpl.createStudent(student);
            return new ResponseEntity<Student>(createdStudent, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("put/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer studentId, @RequestBody Student student) {
        Student existingStudent = studentServiceImpl.getStudentById(studentId);
        if (existingStudent != null) {
            student.setStudentId(studentId);
            Student updatedStudent = studentServiceImpl.updateStudent(student);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("delete/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer studentId) {
        Student student = studentServiceImpl.getStudentById(studentId);
        if (student != null) {
            studentServiceImpl.deleteStudent(studentId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
}
