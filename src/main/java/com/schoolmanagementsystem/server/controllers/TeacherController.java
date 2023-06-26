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

import com.schoolmanagementsystem.server.models.Teacher;
import com.schoolmanagementsystem.server.services.TeacherServiceImpl;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
     private TeacherServiceImpl teacherServiceImpl;

    public TeacherController(TeacherServiceImpl teacherServiceImpl){
        this.teacherServiceImpl = teacherServiceImpl;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherServiceImpl.getAllTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("get/{teacherId}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Integer teacherId) {
        Teacher teacher = teacherServiceImpl.getTeacherById(teacherId);
        if (teacher != null) {
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher createdTeacher = teacherServiceImpl.createTeacher(teacher);
        return new ResponseEntity<Teacher>(createdTeacher, HttpStatus.CREATED);
    }

    @PutMapping("put/{teacherId}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Integer teacherId, @RequestBody Teacher teacher) {
        Teacher existingTeacher = teacherServiceImpl.getTeacherById(teacherId);
        if (existingTeacher != null) {
            teacher.setTeacherId(teacherId);
            Teacher updatedTeacher = teacherServiceImpl.updateTeacher(teacher);
            return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("delete/{teacherId}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Integer teacherId) {
        Teacher teacher = teacherServiceImpl.getTeacherById(teacherId);
        if (teacher != null) {
            teacherServiceImpl.deleteTeacher(teacherId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }    

}
