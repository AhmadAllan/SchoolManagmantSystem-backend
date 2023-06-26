package com.schoolmanagementsystem.server.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "exam")
public class Exam {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private Integer examId;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "duration", nullable = false)
    private String duration;

    @Column(name = "max_mark", nullable = false)
    private Integer maxMark;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "material_id", nullable = false)
    private Integer materialId;

    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "material_id", updatable = false, insertable = false)
    private Material material;
    

    public Exam() {
    }

    public Exam(String type, String duration, Integer maxMark, Date date, Integer materialId) {
        this.type = type;
        this.duration = duration;
        this.maxMark = maxMark;
        this.date = date;
        this.materialId = materialId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getMaxMark() {
        return maxMark;
    }

    public void setMaxMark(Integer maxMark) {
        this.maxMark = maxMark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Exam [examId=" + examId + ", type=" + type + ", duration=" + duration + ", maxMark=" + maxMark
                + ", date=" + date + ", materialId=" + materialId + ", material=" + material + "]";
    }

    
}
