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
@Table(name = "messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Integer messageId;

    @ManyToOne
    @JoinColumn(name = "sender_admin_id", nullable = false)
    private Admin senderAdmin;

    @ManyToOne
    @JoinColumn(name = "sender_teacher_id", nullable = false)
    private Teacher senderTeacher;

    @ManyToOne
    @JoinColumn(name = "sender_student_id", nullable = false)
    private Student senderStudent;

    @ManyToOne
    @JoinColumn(name = "sender_parent_id", nullable = false)
    private Parent senderParent;

    @ManyToOne
    @JoinColumn(name = "receiver_admin_id", nullable = false)
    private Admin receiverAdmin;

    @ManyToOne
    @JoinColumn(name = "receiver_teacher_id", nullable = false)
    private Teacher receiverTeacher;

    @ManyToOne
    @JoinColumn(name = "receiver_student_id", nullable = false)
    private Student receiverStudent;

    @ManyToOne
    @JoinColumn(name = "receiver_parent_id", nullable = false)
    private Parent receiverParent;

    @Column(name = "message_content", nullable = false)
    private String messageContent;

    @Column(name = "date_sent", nullable = false)
    private Date dateSent;

    public Integer getMessageId() {
        return messageId;
    }

    public Messages() {
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Admin getSenderAdmin() {
        return senderAdmin;
    }

    public void setSenderAdmin(Admin senderAdmin) {
        this.senderAdmin = senderAdmin;
    }

    public Teacher getSenderTeacher() {
        return senderTeacher;
    }

    public void setSenderTeacher(Teacher senderTeacher) {
        this.senderTeacher = senderTeacher;
    }

    public Student getSenderStudent() {
        return senderStudent;
    }

    public void setSenderStudent(Student senderStudent) {
        this.senderStudent = senderStudent;
    }

    public Parent getSenderParent() {
        return senderParent;
    }

    public void setSenderParent(Parent senderParent) {
        this.senderParent = senderParent;
    }

    public Admin getReceiverAdmin() {
        return receiverAdmin;
    }

    public void setReceiverAdmin(Admin receiverAdmin) {
        this.receiverAdmin = receiverAdmin;
    }

    public Teacher getReceiverTeacher() {
        return receiverTeacher;
    }

    public void setReceiverTeacher(Teacher receiverTeacher) {
        this.receiverTeacher = receiverTeacher;
    }

    public Student getReceiverStudent() {
        return receiverStudent;
    }

    public void setReceiverStudent(Student receiverStudent) {
        this.receiverStudent = receiverStudent;
    }

    public Parent getReceiverParent() {
        return receiverParent;
    }

    public void setReceiverParent(Parent receiverParent) {
        this.receiverParent = receiverParent;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    public Messages(Admin senderAdmin, Teacher senderTeacher, Student senderStudent, Parent senderParent,
            Admin receiverAdmin, Teacher receiverTeacher, Student receiverStudent, Parent receiverParent,
            String messageContent, Date dateSent) {
        this.senderAdmin = senderAdmin;
        this.senderTeacher = senderTeacher;
        this.senderStudent = senderStudent;
        this.senderParent = senderParent;
        this.receiverAdmin = receiverAdmin;
        this.receiverTeacher = receiverTeacher;
        this.receiverStudent = receiverStudent;
        this.receiverParent = receiverParent;
        this.messageContent = messageContent;
        this.dateSent = dateSent;
    }

    @Override
    public String toString() {
        return "Messages [messageId=" + messageId + ", senderAdmin=" + senderAdmin + ", senderTeacher=" + senderTeacher
                + ", senderStudent=" + senderStudent + ", senderParent=" + senderParent + ", receiverAdmin="
                + receiverAdmin + ", receiverTeacher=" + receiverTeacher + ", receiverStudent=" + receiverStudent
                + ", receiverParent=" + receiverParent + ", messageContent=" + messageContent + ", dateSent=" + dateSent
                + "]";
    }

    
}