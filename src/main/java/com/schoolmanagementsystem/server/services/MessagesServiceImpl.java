package com.schoolmanagementsystem.server.services;

import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.server.dao.AdminDaoImpl;
import com.schoolmanagementsystem.server.dao.MessagesDaoImpl;
import com.schoolmanagementsystem.server.dao.ParentDaoImpl;
import com.schoolmanagementsystem.server.dao.StudentDaoImpl;
import com.schoolmanagementsystem.server.dao.TeacherDaoImpl;
import com.schoolmanagementsystem.server.models.Admin;
import com.schoolmanagementsystem.server.models.Messages;
import com.schoolmanagementsystem.server.models.Parent;
import com.schoolmanagementsystem.server.models.Student;
import com.schoolmanagementsystem.server.models.Teacher;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MessagesServiceImpl implements MessagesService {
    private final MessagesDaoImpl messagesDaoImpl;
    private final AdminDaoImpl adminDaoImpl;
    private final TeacherDaoImpl teacherDaoImpl;
    private final StudentDaoImpl studentDaoImpl;
    private final ParentDaoImpl parentDaoImpl;

    public MessagesServiceImpl(MessagesDaoImpl messagesDaoImpl, AdminDaoImpl adminDaoImpl,
            TeacherDaoImpl teacherDaoImpl, StudentDaoImpl studentDaoImpl, ParentDaoImpl parentDaoImpl) {
        this.messagesDaoImpl = messagesDaoImpl;
        this.adminDaoImpl = adminDaoImpl;
        this.teacherDaoImpl = teacherDaoImpl;
        this.studentDaoImpl = studentDaoImpl;
        this.parentDaoImpl = parentDaoImpl;
    }

    @Override
    public Messages createMessage(Messages message) {
        // Check if the senderAdmin exists
        if (message.getSenderAdmin() != null && message.getSenderAdmin().getAdminId() != null) {
            Admin senderAdmin = adminDaoImpl.findByAdminId(message.getSenderAdmin().getAdminId());
            if (senderAdmin != null) {
                message.setSenderAdmin(senderAdmin);
            } else {
                System.out.println("Sender Admin not found");
                return null;
            }
        }

        // Check if the senderTeacher exists
        if (message.getSenderTeacher() != null && message.getSenderTeacher().getTeacherId() != null) {
            Teacher senderTeacher = teacherDaoImpl.findByTeacherId(message.getSenderTeacher().getTeacherId());
            if (senderTeacher != null) {
                message.setSenderTeacher(senderTeacher);
            } else {
                System.out.println("Sender Teacher not found");
                return null;
            }
        }

        // Check if the senderStudent exists
        if (message.getSenderStudent() != null && message.getSenderStudent().getStudentId() != null) {
            Student senderStudent = studentDaoImpl.findByStudentId(message.getSenderStudent().getStudentId());
            if (senderStudent != null) {
                message.setSenderStudent(senderStudent);
            } else {
                System.out.println("Sender Student not found");
                return null;
            }
        }

        // Check if the senderParent exists
        if (message.getSenderParent() != null && message.getSenderParent().getParentId() != null) {
            Parent senderParent = parentDaoImpl.findByParentId(message.getSenderParent().getParentId());
            if (senderParent != null) {
                message.setSenderParent(senderParent);
            } else {
                System.out.println("Sender Parent not found");
                return null;
            }
        }

        // Check if the receiverAdmin exists
        if (message.getReceiverAdmin() != null && message.getReceiverAdmin().getAdminId() != null) {
            Admin receiverAdmin = adminDaoImpl.findByAdminId(message.getReceiverAdmin().getAdminId());
            if (receiverAdmin != null) {
                message.setReceiverAdmin(receiverAdmin);
            } else {
                System.out.println("Receiver Admin not found");
                return null;
            }
        }

        // Check if the receiverTeacher exists
        if (message.getReceiverTeacher() != null && message.getReceiverTeacher().getTeacherId() != null) {
            Teacher receiverTeacher = teacherDaoImpl.findByTeacherId(message.getReceiverTeacher().getTeacherId());
            if (receiverTeacher != null) {
                message.setReceiverTeacher(receiverTeacher);
            } else {
                System.out.println("Receiver Teacher not found");
                return null;
            }
        }

        // Check if the receiverStudent exists
        if (message.getReceiverStudent() != null && message.getReceiverStudent().getStudentId() != null) {
            Student receiverStudent = studentDaoImpl.findByStudentId(message.getReceiverStudent().getStudentId());
            if (receiverStudent != null) {
                message.setReceiverStudent(receiverStudent);
            } else {
                System.out.println("Receiver Student not found");
                return null;
            }
        }

        // Check if the receiverParent exists
        if (message.getReceiverParent() != null && message.getReceiverParent().getParentId() != null) {
            Parent receiverParent = parentDaoImpl.findByParentId(message.getReceiverParent().getParentId());
            if (receiverParent != null) {
                message.setReceiverParent(receiverParent);
            } else {
                System.out.println("Receiver Parent not found");
                return null;
            }
        }

        return messagesDaoImpl.saveMessage(message);
    }

    @Override
    public Messages getMessageById(Integer messageId) {
        return messagesDaoImpl.findMessageById(messageId);
    }

    @Override
    public void deleteMessage(Integer messageId) {
        messagesDaoImpl.deleteMessage(messageId);
    }

    @Override
    public Messages updateMessage(Messages message) {
        return messagesDaoImpl.updateMessage(message);
    }
}
