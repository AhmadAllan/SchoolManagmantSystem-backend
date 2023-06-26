package com.schoolmanagementsystem.server.dao;

import org.springframework.stereotype.Repository;
import com.schoolmanagementsystem.server.models.Messages;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MessagesDaoImpl implements MessagesDao {
    private EntityManager entityManager;

    public MessagesDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Messages saveMessage(Messages message) {
        entityManager.persist(message);
        return message;
    }

    @Override
    public Messages findMessageById(Integer messageId) {
        return entityManager.find(Messages.class, messageId);
    }

    @Override
    public void deleteMessage(Integer messageId) {
        Messages message = entityManager.find(Messages.class, messageId);
        if (message != null) {
            entityManager.remove(message);
        }
    }

    @Override
    public Messages updateMessage(Messages message) {
        return entityManager.merge(message);
    }
}
