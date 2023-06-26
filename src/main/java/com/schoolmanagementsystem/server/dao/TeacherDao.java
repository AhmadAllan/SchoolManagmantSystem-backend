package com.schoolmanagementsystem.server.dao;

import java.util.List;

import com.schoolmanagementsystem.server.models.Teacher;

public interface TeacherDao {

    List<Teacher> getAllTeachers();
    Teacher findByTeacherId(Integer teacherId);
    Teacher saveTeacher(Teacher teacher);
    void deleteTeacher(Integer teacherId);
    Teacher updateTeacher(Teacher teacher);
}
