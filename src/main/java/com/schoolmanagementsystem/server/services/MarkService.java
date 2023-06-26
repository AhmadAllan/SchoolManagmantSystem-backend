package com.schoolmanagementsystem.server.services;

import java.util.List;

import com.schoolmanagementsystem.server.models.Mark;

public interface MarkService {
    
    Mark createMark(Mark mark);
    Mark getMarkById(Integer markId);
    void deleteMark(Integer markId);
    List<Mark> getAllMarks();
    Mark updateMark(Mark mark);
}
