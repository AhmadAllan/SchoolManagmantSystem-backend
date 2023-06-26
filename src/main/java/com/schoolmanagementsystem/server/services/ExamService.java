package com.schoolmanagementsystem.server.services;

import java.util.List;

import com.schoolmanagementsystem.server.models.Exam;

public interface ExamService {
    Exam createExam(Exam exam);
    Exam getExamById(Integer examId);
    Exam getExamWithMaterial(Integer examId);
    void deleteExam(Integer examId);
    List<Exam> getAllExams();
    Exam updateExam(Exam exam);
}
