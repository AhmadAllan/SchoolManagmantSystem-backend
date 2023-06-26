package com.schoolmanagementsystem.server.dao;

import com.schoolmanagementsystem.server.models.Messages;

public interface MessagesDao {
    Messages saveMessage(Messages message);
    Messages findMessageById(Integer messageId);
    void deleteMessage(Integer messageId);
    Messages updateMessage(Messages message);
}
