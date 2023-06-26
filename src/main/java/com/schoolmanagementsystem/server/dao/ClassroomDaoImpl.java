package com.schoolmanagementsystem.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.schoolmanagementsystem.server.models.Classroom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ClassroomDaoImpl implements ClassroomDao {
    private EntityManager entityManager;

    public ClassroomDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Classroom> getAllClassrooms() {
        TypedQuery<Classroom> query = entityManager.createQuery("SELECT a FROM Classroom a", Classroom.class);
        return query.getResultList();
    }

    @Override
    public Classroom findByClassroomId(Integer classroomId) {
        return entityManager.find(Classroom.class, classroomId);
    }

    @Override
    public Classroom saveClassroom(Classroom classroom) {
        entityManager.persist(classroom);
        return classroom;
    }    

    @Override
    public void deleteClassroom(Integer classroomId) {
        Classroom classroom = entityManager.find(Classroom.class, classroomId);
        if (classroom != null) {
            entityManager.remove(classroom);
        }
    }

    @Override
    public Classroom updateClassroom(Classroom classroom) {
        return entityManager.merge(classroom);
    }

}
