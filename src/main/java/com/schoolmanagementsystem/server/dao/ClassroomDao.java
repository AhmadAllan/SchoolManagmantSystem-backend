package com.schoolmanagementsystem.server.dao;

import java.util.List;

import com.schoolmanagementsystem.server.models.Classroom;

public interface ClassroomDao {
    List<Classroom> getAllClassrooms();
    Classroom findByClassroomId(Integer classroomId);
    Classroom saveClassroom(Classroom classroom);
    void deleteClassroom(Integer classroomId);
    Classroom updateClassroom(Classroom classroom);
}
