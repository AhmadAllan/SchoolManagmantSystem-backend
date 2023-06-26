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
@Table(name = "classroom")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classroom_id")
    private Integer classroomId;

    @Column(name = "class_name", nullable = false)
    private String className;

    @Column(name = "grade", nullable = false)
    private Integer gradeLevel;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "fk_supervisor_id", nullable = false)
    private Integer supervisorId;

    @ManyToOne
    @JoinColumn(name = "fk_supervisor_id", referencedColumnName = "teacher_id", updatable = false, insertable = false)
    private Teacher teacher;

    public Classroom() {
    }

    public Classroom(String className, Integer gradeLevel, Integer capacity, String location, Integer supervisorId) {
        this.className = className;
        this.gradeLevel = gradeLevel;
        this.capacity = capacity;
        this.location = location;
        this.supervisorId = supervisorId;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(Integer gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Classroom [classroomId=" + classroomId + ", className=" + className + ", gradeLevel=" + gradeLevel
                + ", capacity=" + capacity + ", location=" + location + ", supervisorId=" + supervisorId + ", teacher="
                + teacher + "]";
    }
}
