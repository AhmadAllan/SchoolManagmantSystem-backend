package com.schoolmanagementsystem.server.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.server.dao.TeacherDaoImpl;
import com.schoolmanagementsystem.server.dao.ClassroomDaoImpl;
import com.schoolmanagementsystem.server.models.Teacher;
import com.schoolmanagementsystem.server.models.Classroom;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    private final ClassroomDaoImpl classroomDaoImpl;
    private final TeacherDaoImpl teacherDaoImpl;

    public ClassroomServiceImpl(ClassroomDaoImpl classroomDaoImpl, TeacherDaoImpl teacherDaoImpl){
        this.classroomDaoImpl = classroomDaoImpl;
        this.teacherDaoImpl = teacherDaoImpl;
    }
    @Override
    public Classroom createClassroom(Classroom classroom) {
        Teacher teacher = teacherDaoImpl.findByTeacherId(classroom.getSupervisorId());
        if (teacher != null) {
            classroom.setTeacher(teacher);
            return classroomDaoImpl.saveClassroom(classroom);
        } else {
            System.out.println("parent not found");
            return null;
        }
    }

    @Override
    public Classroom getClassroomById(Integer classroomId) {
        return classroomDaoImpl.findByClassroomId(classroomId);
    }

    @Override
    public void deleteClassroom(Integer classroomId) {
        classroomDaoImpl.deleteClassroom(classroomId);
    }

    @Override
    public List<Classroom> getAllClassrooms() {
        return classroomDaoImpl.getAllClassrooms();
    }

    @Override
    public Classroom updateClassroom(Classroom classroom) {
        return classroomDaoImpl.updateClassroom(classroom);
    }
    @Override
    public Classroom getClassroomWithSupervisor(Integer classroomId) {
        Classroom classroom = classroomDaoImpl.findByClassroomId(classroomId);
        if (classroom != null) {
            classroom.getTeacher();
        }
        return classroom;
    }
}
