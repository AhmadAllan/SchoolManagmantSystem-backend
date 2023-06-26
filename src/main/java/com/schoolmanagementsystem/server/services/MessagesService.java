package com.schoolmanagementsystem.server.services;

import com.schoolmanagementsystem.server.models.Messages;

public interface MessagesService {
    Messages createMessage(Messages message);
    Messages getMessageById(Integer messageId);
    void deleteMessage(Integer messageId);
    Messages updateMessage(Messages message);
}
