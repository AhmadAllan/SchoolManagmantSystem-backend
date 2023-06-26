package com.schoolmanagementsystem.server.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_m_c")
public class Tmc {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer tmcId;
    
    @Column(name = "fk_teacher_id", nullable = false)
    private Integer teacherId;

    @Column(name = "fk_classroom_id", nullable = false)
    private Integer classroomId;

    @Column(name = "fk_material_id", nullable = false)
    private Integer materialId;

    @ManyToOne
    @JoinColumn(name = "fk_teacher_id", referencedColumnName = "teacher_id", insertable = false, updatable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "fk_classroom_id", referencedColumnName = "classroom_id", insertable = false, updatable = false)
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "fk_material_id", referencedColumnName = "material_id", insertable = false, updatable = false)
    private Material material;

    public Tmc() {
    }

    public Tmc(Integer tmcId, Integer teacherId, Integer classroomId, Integer materialId) {
        this.tmcId = tmcId;
        this.teacherId = teacherId;
        this.classroomId = classroomId;
        this.materialId = materialId;
    }

    public Integer getTmcId() {
        return tmcId;
    }

    public void setTmcId(Integer tmcId) {
        this.tmcId = tmcId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Tmc [tmcId=" + tmcId + ", teacherId=" + teacherId + ", classroomId=" + classroomId + ", materialId="
                + materialId + ", teacher=" + teacher + ", classroom=" + classroom + ", material=" + material + "]";
    }

    
}

