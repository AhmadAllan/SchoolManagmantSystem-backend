package com.schoolmanagementsystem.server.services;

import java.util.List;

import com.schoolmanagementsystem.server.models.Classroom;

public interface ClassroomService {
    Classroom createClassroom(Classroom classroom);
    Classroom getClassroomById(Integer classroomId);
    Classroom getClassroomWithSupervisor(Integer classroomId);
    void deleteClassroom(Integer classroomId);
    List<Classroom> getAllClassrooms();
    Classroom updateClassroom(Classroom classroom);
}
