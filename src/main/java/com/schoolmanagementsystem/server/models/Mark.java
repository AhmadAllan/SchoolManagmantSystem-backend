package com.schoolmanagementsystem.server.models;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mark_id")
    private Integer markId;

    @Column(name = "report", nullable = false)
    private Integer report;

    @Column(name = "midterm", nullable = false)
    private Integer midterm;

    @Column(name = "final", nullable = false)
    private Integer finalMark;

    @Column(name = "fk_material_id", nullable = false)
    private Integer materialId;

    @Column(name = "fk_student_id", nullable = false)
    private Integer studentId;


    @ManyToOne
    @JoinColumn(name = "fk_material_id", referencedColumnName = "admin_id",updatable = false, insertable = false, nullable = false)
    private Material material;

    @ManyToOne
    @JoinColumn(name = "fk_student_id", referencedColumnName = "admin_id",updatable = false, insertable = false, nullable = false)
    private Student student;

    public Mark() {
    }

    public Mark(Integer report, Integer midterm, Integer finalMark, Integer materialId, Integer studentId) {
        this.report = report;
        this.midterm = midterm;
        this.finalMark = finalMark;
        this.materialId = materialId;
        this.studentId = studentId;
    }

    public Integer getMarkId() {
        return markId;
    }

    public void setMarkId(Integer markId) {
        this.markId = markId;
    }

    public Integer getReport() {
        return report;
    }

    public void setReport(Integer report) {
        this.report = report;
    }

    public Integer getMidterm() {
        return midterm;
    }

    public void setMidterm(Integer midterm) {
        this.midterm = midterm;
    }

    public Integer getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(Integer finalMark) {
        this.finalMark = finalMark;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Mark [markId=" + markId + ", report=" + report + ", midterm=" + midterm + ", finalMark=" + finalMark
                + ", materialId=" + materialId + ", studentId=" + studentId + ", material=" + material + ", student="
                + student + "]";
    }

    
}
