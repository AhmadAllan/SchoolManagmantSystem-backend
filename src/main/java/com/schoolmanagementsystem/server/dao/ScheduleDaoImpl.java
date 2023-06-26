package com.schoolmanagementsystem.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.schoolmanagementsystem.server.models.Schedule;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ScheduleDaoImpl implements ScheduleDao {
    private EntityManager entityManager;

    public ScheduleDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Schedule> getAllSchedules() {
        TypedQuery<Schedule> query = entityManager.createQuery("SELECT a FROM Schedule a", Schedule.class);
        return query.getResultList();
    }

    @Override
    public Schedule findByScheduleId(Integer scheduleId) {
        return entityManager.find(Schedule.class, scheduleId);
    }

    @Override
    public Schedule saveSchedule(Schedule schedule) {
        entityManager.persist(schedule);
        return schedule;
    }    

    @Override
    public void deleteSchedule(Integer scheduleId) {
        Schedule schedule = entityManager.find(Schedule.class, scheduleId);
        if (schedule != null) {
            entityManager.remove(schedule);
        }
    }

    @Override
    public Schedule updateSchedule(Schedule schedule) {
        return entityManager.merge(schedule);
    }
}
