package com.schoolmanagementsystem.server.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.server.dao.MaterialDaoImpl;
import com.schoolmanagementsystem.server.dao.ExamDaoImpl;
import com.schoolmanagementsystem.server.models.Material;
import com.schoolmanagementsystem.server.models.Exam;

@Service
public class ExamServiceImpl implements ExamService {
    private final ExamDaoImpl examDaoImpl;
    private final MaterialDaoImpl materialDaoImpl;

    public ExamServiceImpl(ExamDaoImpl examDaoImpl, MaterialDaoImpl materialDaoImpl){
        this.examDaoImpl = examDaoImpl;
        this.materialDaoImpl = materialDaoImpl;
    }
    @Override
    public Exam createExam(Exam exam) {
        Material material = materialDaoImpl.findByMaterialId(exam.getMaterialId());
        if (material != null) {
            exam.setMaterial(material);
            return examDaoImpl.saveExam(exam);
        } else {
            System.out.println("parent not found");
            return null;
        }
    }

    @Override
    public Exam getExamById(Integer examId) {
        return examDaoImpl.findByExamId(examId);
    }

    @Override
    public void deleteExam(Integer examId) {
        examDaoImpl.deleteExam(examId);
    }

    @Override
    public List<Exam> getAllExams() {
        return examDaoImpl.getAllExams();
    }

    @Override
    public Exam updateExam(Exam exam) {
        return examDaoImpl.updateExam(exam);
    }
    @Override
    public Exam getExamWithMaterial(Integer examId) {
        Exam exam = examDaoImpl.findByExamId(examId);
        if (exam != null) {
            exam.getMaterial();
        }
        return exam;
    }
}
