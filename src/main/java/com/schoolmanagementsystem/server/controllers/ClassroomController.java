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

import com.schoolmanagementsystem.server.dao.TeacherDaoImpl;
import com.schoolmanagementsystem.server.models.Teacher;
import com.schoolmanagementsystem.server.models.Classroom;
import com.schoolmanagementsystem.server.services.ClassroomServiceImpl;

@RestController
@RequestMapping("/api/v1/classroom")
public class ClassroomController {
    private final ClassroomServiceImpl classroomServiceImpl;
    private final TeacherDaoImpl teacherDaoImpl;

    public ClassroomController(ClassroomServiceImpl classroomServiceImpl, TeacherDaoImpl teacherDaoImpl){
        this.classroomServiceImpl = classroomServiceImpl;
        this.teacherDaoImpl = teacherDaoImpl;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Classroom>> getAllClassrooms() {
        List<Classroom> classrooms = classroomServiceImpl.getAllClassrooms();
        return new ResponseEntity<>(classrooms, HttpStatus.OK);
    }

    @GetMapping("get/{classroomId}")
    public ResponseEntity<Classroom> getClassroomById(@PathVariable Integer classroomId) {
        Classroom classroom = classroomServiceImpl.getClassroomById(classroomId);
        if (classroom != null) {
            return new ResponseEntity<>(classroom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Classroom> createClassroom(@RequestBody Classroom classroom) {
        Teacher teacher = teacherDaoImpl.findByTeacherId(classroom.getSupervisorId());
        if (teacher != null) {
            Classroom createdClassroom = classroomServiceImpl.createClassroom(classroom);
            return new ResponseEntity<Classroom>(createdClassroom, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("put/{classroomId}")
    public ResponseEntity<Classroom> updateClassroom(@PathVariable Integer classroomId, @RequestBody Classroom classroom) {
        Classroom existingClassroom = classroomServiceImpl.getClassroomById(classroomId);
        if (existingClassroom != null) {
            classroom.setClassroomId(classroomId);
            Classroom updatedClassroom = classroomServiceImpl.updateClassroom(classroom);
            return new ResponseEntity<>(updatedClassroom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("delete/{classroomId}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Integer classroomId) {
        Classroom classroom = classroomServiceImpl.getClassroomById(classroomId);
        if (classroom != null) {
            classroomServiceImpl.deleteClassroom(classroomId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
}
