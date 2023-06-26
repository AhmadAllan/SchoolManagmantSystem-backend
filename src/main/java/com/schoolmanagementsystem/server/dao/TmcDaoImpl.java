package com.schoolmanagementsystem.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.schoolmanagementsystem.server.models.Tmc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TmcDaoImpl implements TmcDao {
    private EntityManager entityManager;

    public TmcDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Tmc> getAllTmcs() {
        TypedQuery<Tmc> query = entityManager.createQuery("SELECT t FROM Tmc t", Tmc.class);
        return query.getResultList();
    }

    @Override
    public Tmc findByTmcId(Integer tmcId) {
        return entityManager.find(Tmc.class, tmcId);
    }

    @Override
    public Tmc saveTmc(Tmc tmc) {
        entityManager.persist(tmc);
        return tmc;
    }

    @Override
    public void deleteTmc(Integer tmcId) {
        Tmc tmc = entityManager.find(Tmc.class, tmcId);
        if (tmc != null) {
            entityManager.remove(tmc);
        }
    }

    @Override
    public Tmc updateTmc(Tmc tmc) {
        return entityManager.merge(tmc);
    }
}
