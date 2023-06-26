package com.schoolmanagementsystem.server.controllers;

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

import com.schoolmanagementsystem.server.dao.AdminDaoImpl;
import com.schoolmanagementsystem.server.dao.StudentDaoImpl;
import com.schoolmanagementsystem.server.dao.TeacherDaoImpl;
import com.schoolmanagementsystem.server.models.Admin;
import com.schoolmanagementsystem.server.models.Messages;
import com.schoolmanagementsystem.server.models.Student;
import com.schoolmanagementsystem.server.models.Teacher;
import com.schoolmanagementsystem.server.services.MessagesServiceImpl;

@RestController
@RequestMapping("/api/v1/messages")
public class MessagesController {

    private final MessagesServiceImpl messagesServiceImpl;
    private final AdminDaoImpl adminDaoImpl;
    private final TeacherDaoImpl teacherDaoImpl;
    private final StudentDaoImpl studentDaoImpl;

    public MessagesController(MessagesServiceImpl messagesServiceImpl, AdminDaoImpl adminDaoImpl,
                              TeacherDaoImpl teacherDaoImpl, StudentDaoImpl studentDaoImpl) {
        this.messagesServiceImpl = messagesServiceImpl;
        this.adminDaoImpl = adminDaoImpl;
        this.teacherDaoImpl = teacherDaoImpl;
        this.studentDaoImpl = studentDaoImpl;
    }

    @GetMapping("/get/{messageId}")
    public ResponseEntity<Messages> getMessageById(@PathVariable Integer messageId) {
        Messages message = messagesServiceImpl.getMessageById(messageId);
        if (message != null) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Messages> createMessage(@RequestBody Messages message) {
        // Check if the senderAdmin exists
        if (message.getSenderAdmin() != null && message.getSenderAdmin().getAdminId() != null) {
            Admin senderAdmin = adminDaoImpl.findByAdminId(message.getSenderAdmin().getAdminId());
            if (senderAdmin != null) {
                message.setSenderAdmin(senderAdmin);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        // Check if the senderTeacher exists
        if (message.getSenderTeacher() != null && message.getSenderTeacher().getTeacherId() != null) {
            Teacher senderTeacher = teacherDaoImpl.findByTeacherId(message.getSenderTeacher().getTeacherId());
            if (senderTeacher != null) {
                message.setSenderTeacher(senderTeacher);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        // Check if the senderStudent exists
        if (message.getSenderStudent() != null && message.getSenderStudent().getStudentId() != null) {
            Student senderStudent = studentDaoImpl.findByStudentId(message.getSenderStudent().getStudentId());
            if (senderStudent != null) {
                message.setSenderStudent(senderStudent);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        Messages createdMessage = messagesServiceImpl.createMessage(message);
        return new ResponseEntity<>(createdMessage, HttpStatus.CREATED);
    }

    @PutMapping("/update/{messageId}")
    public ResponseEntity<Messages> updateMessage(@PathVariable Integer messageId, @RequestBody Messages message) {
        Messages existingMessage = messagesServiceImpl.getMessageById(messageId);
        if (existingMessage != null) {
            // Check if the senderAdmin exists
            if (message.getSenderAdmin() != null && message.getSenderAdmin().getAdminId() != null) {
                Admin senderAdmin = adminDaoImpl.findByAdminId(message.getSenderAdmin().getAdminId());
                if (senderAdmin != null) {
                    existingMessage.setSenderAdmin(senderAdmin);
                } else {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            } else {
                existingMessage.setSenderAdmin(null);
            }

            // Check if the senderTeacher exists
            if (message.getSenderTeacher() != null && message.getSenderTeacher().getTeacherId() != null) {
                Teacher senderTeacher = teacherDaoImpl.findByTeacherId(message.getSenderTeacher().getTeacherId());
                if (senderTeacher != null) {
                    existingMessage.setSenderTeacher(senderTeacher);
                } else {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            } else {
                existingMessage.setSenderTeacher(null);
            }

            // Check if the senderStudent exists
            if (message.getSenderStudent() != null && message.getSenderStudent().getStudentId() != null) {
                Student senderStudent = studentDaoImpl.findByStudentId(message.getSenderStudent().getStudentId());
                if (senderStudent != null) {
                    existingMessage.setSenderStudent(senderStudent);
                } else {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            } else {
                existingMessage.setSenderStudent(null);
            }

            existingMessage.setMessageContent(message.getMessageContent());
            existingMessage.setDateSent(message.getDateSent());

            Messages updatedMessage = messagesServiceImpl.updateMessage(existingMessage);
            return new ResponseEntity<>(updatedMessage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{messageId}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Integer messageId) {
        messagesServiceImpl.deleteMessage(messageId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
