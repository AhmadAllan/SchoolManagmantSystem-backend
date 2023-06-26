package com.schoolmanagementsystem.server.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagementsystem.server.dao.MaterialDaoImpl;
import com.schoolmanagementsystem.server.models.Material;
import com.schoolmanagementsystem.server.models.Exam;
import com.schoolmanagementsystem.server.services.ExamServiceImpl;

@RestController
@RequestMapping("/api/v1/exam")
public class ExamController {
    private final ExamServiceImpl examServiceImpl;
    private final MaterialDaoImpl materialDaoImpl;

    public ExamController(ExamServiceImpl examServiceImpl, MaterialDaoImpl materialDaoImpl){
        this.examServiceImpl = examServiceImpl;
        this.materialDaoImpl = materialDaoImpl;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Exam>> getAllExams() {
        List<Exam> exams = examServiceImpl.getAllExams();
        return new ResponseEntity<>(exams, HttpStatus.OK);
    }

    @GetMapping("get/{examId}")
    public ResponseEntity<Exam> getExamById(@PathVariable Integer examId) {
        Exam exam = examServiceImpl.getExamById(examId);
        if (exam != null) {
            return new ResponseEntity<>(exam, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam) {
        Material material = materialDaoImpl.findByMaterialId(exam.getMaterialId());
        if (material != null) {
            Exam createdExam = examServiceImpl.createExam(exam);
            return new ResponseEntity<Exam>(createdExam, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("put/{examId}")
    public ResponseEntity<Exam> updateExam(@PathVariable Integer examId, @RequestBody Exam exam) {
        Exam existingExam = examServiceImpl.getExamById(examId);
        if (existingExam != null) {
            exam.setExamId(examId);
            Exam updatedExam = examServiceImpl.updateExam(exam);
            return new ResponseEntity<>(updatedExam, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("delete/{examId}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Integer examId) {
        Exam exam = examServiceImpl.getExamById(examId);
        if (exam != null) {
            examServiceImpl.deleteExam(examId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
}
