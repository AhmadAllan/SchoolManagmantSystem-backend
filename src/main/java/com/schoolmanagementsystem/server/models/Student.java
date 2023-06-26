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
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "grade", nullable = false)
    private Integer grade;

    @Column(name = "classroom", nullable = false)
    private String classroom;


    @ManyToOne
    @JoinColumn(name = "fk_parent_id", referencedColumnName = "parent_id", insertable = false, updatable = false)
    private Parent parent;

    @Column(name = "fk_parent_id", nullable = false)
    private Integer parentId;

    public Student() {
    }

    public Student(Integer studentId, String name, String userName, String password, String email, Integer grade,
            String classroom, Integer parentId) {
        this.studentId = studentId;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.grade = grade;
        this.classroom = classroom;
        this.parentId = parentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", name=" + name + ", userName=" + userName + ", password="
                + password + ", email=" + email + ", grade=" + grade + ", classroom=" + classroom + ", parent=" + parent
                + ", parentId=" + parentId + "]";
    }

    
}