package com.schoolmanagementsystem.server.dao;

import java.util.List;

import com.schoolmanagementsystem.server.models.Mark;

public interface MarkDao {
    List<Mark> getAllMarks();

    Mark findByMarkId(Integer markId);

    Mark saveMark(Mark mark);

    void deleteMark(Integer markId);

    Mark updateMark(Mark mark);
}
