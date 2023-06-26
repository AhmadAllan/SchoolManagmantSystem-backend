package com.schoolmanagementsystem.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.schoolmanagementsystem.server.models.Parent;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ParentDaoImpl implements ParentDao {
     private EntityManager entityManager;

    public ParentDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Parent> getAllParents() {
        TypedQuery<Parent> query = entityManager.createQuery("SELECT a FROM Parent a", Parent.class);
        return query.getResultList();
    }

    @Override
    public Parent findByParentId(Integer parentId) {
        return entityManager.find(Parent.class, parentId);
    }

    @Override
    public Parent saveParent(Parent parent) {
        entityManager.persist(parent);
        return parent;
    }    

    @Override
    public void deleteParent(Integer parentId) {
        Parent parent = entityManager.find(Parent.class, parentId);
        if (parent != null) {
            entityManager.remove(parent);
        }
    }

    @Override
    public Parent updateParent(Parent parent) {
        return entityManager.merge(parent);
    }

}
