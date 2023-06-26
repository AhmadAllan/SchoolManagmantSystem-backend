package com.schoolmanagementsystem.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.schoolmanagementsystem.server.models.Mark;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MarkDaoImpl implements MarkDao {
    private EntityManager entityManager;

    public MarkDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Mark> getAllMarks() {
        TypedQuery<Mark> query = entityManager.createQuery("SELECT a FROM Mark a", Mark.class);
        return query.getResultList();
    }

    @Override
    public Mark findByMarkId(Integer markId) {
        return entityManager.find(Mark.class, markId);
    }

    @Override
    public Mark saveMark(Mark mark) {
        entityManager.persist(mark);
        return mark;
    }    

    @Override
    public void deleteMark(Integer markId) {
        Mark mark = entityManager.find(Mark.class, markId);
        if (mark != null) {
            entityManager.remove(mark);
        }
    }

    @Override
    public Mark updateMark(Mark mark) {
        return entityManager.merge(mark);
    }

}
