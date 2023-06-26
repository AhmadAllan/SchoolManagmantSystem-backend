package com.schoolmanagementsystem.server.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Integer scheduleId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "event_date", nullable = false)
    private LocalDate date;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Column(name = "publicity", nullable = false)
    private Integer publicity;

    @Column(name = "fk_classroom_id", nullable = true)
    private Integer classroomId;

    @ManyToOne
    @JoinColumn(name = "fk_classroom_id", referencedColumnName = "classroom_id", updatable = false, insertable = false, nullable = true)
    private Classroom classroom;

    public Schedule() {
    }

    public Schedule(String name, LocalDate date, LocalTime startTime, LocalTime endTime, Integer publicity,
            Integer classroomId) {
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.publicity = publicity;
        this.classroomId = classroomId;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Integer getPublicity() {
        return publicity;
    }

    public void setPublicity(Integer publicity) {
        this.publicity = publicity;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Schedule [scheduleId=" + scheduleId + ", name=" + name + ", date=" + date + ", startTime=" + startTime
                + ", endTime=" + endTime + ", publicity=" + publicity + ", classroomId=" + classroomId + ", classroom="
                + classroom + "]";
    }  
}
