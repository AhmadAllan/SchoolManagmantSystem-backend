package com.schoolmanagementsystem.server.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.server.dao.TeacherDaoImpl;
import com.schoolmanagementsystem.server.models.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherDaoImpl teacherDaoImpl;

    public TeacherServiceImpl(TeacherDaoImpl teacherDaoImpl){
        this.teacherDaoImpl = teacherDaoImpl;
    }
    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherDaoImpl.saveTeacher(teacher);
    }

    @Override
    public Teacher getTeacherById(Integer teacherId) {
        return teacherDaoImpl.findByTeacherId(teacherId);
    }

    @Override
    public void deleteTeacher(Integer teacherId) {
        teacherDaoImpl.deleteTeacher(teacherId);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDaoImpl.getAllTeachers();
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherDaoImpl.updateTeacher(teacher);
    }
    
}
