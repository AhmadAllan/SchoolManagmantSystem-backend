package com.schoolmanagementsystem.server.dao;

import java.util.List;

import com.schoolmanagementsystem.server.models.Exam;

public interface ExamDao {
    List<Exam> getAllExams();

    Exam findByExamId(Integer exam);

    Exam saveExam(Exam exam);

    void deleteExam(Integer exam);

    Exam updateExam(Exam exam);
}
