package com.schoolmanagementsystem.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.schoolmanagementsystem.server.models.Exam;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ExamDaoImpl implements ExamDao {
    private EntityManager entityManager;

    public ExamDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Exam> getAllExams() {
        TypedQuery<Exam> query = entityManager.createQuery("SELECT a FROM Exam a", Exam.class);
        return query.getResultList();
    }

    @Override
    public Exam findByExamId(Integer examId) {
        return entityManager.find(Exam.class, examId);
    }

    @Override
    public Exam saveExam(Exam exam) {
        entityManager.persist(exam);
        return exam;
    }    

    @Override
    public void deleteExam(Integer examId) {
        Exam exam = entityManager.find(Exam.class, examId);
        if (exam != null) {
            entityManager.remove(exam);
        }
    }

    @Override
    public Exam updateExam(Exam exam) {
        return entityManager.merge(exam);
    }
}
