package com.schoolmanagementsystem.server.services;

import java.util.List;

import com.schoolmanagementsystem.server.models.Teacher;

public interface TeacherService {
    Teacher createTeacher(Teacher admin);
    Teacher getTeacherById(Integer teacherId);
    void deleteTeacher(Integer teacherId);
    List<Teacher> getAllTeachers();
    Teacher updateTeacher(Teacher teacher);
}
