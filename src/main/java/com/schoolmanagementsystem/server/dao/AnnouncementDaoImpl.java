package com.schoolmanagementsystem.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.schoolmanagementsystem.server.models.Announcement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AnnouncementDaoImpl implements AnnouncementDao {
    private EntityManager entityManager;

    public AnnouncementDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Announcement> getAllAnnouncements() {
        TypedQuery<Announcement> query = entityManager.createQuery("SELECT a FROM Announcement a", Announcement.class);
        return query.getResultList();
    }

    @Override
    public Announcement findByAnnouncementId(Integer announcementId) {
        return entityManager.find(Announcement.class, announcementId);
    }

    @Override
    public Announcement saveAnnouncement(Announcement announcement) {
        entityManager.persist(announcement);
        return announcement;
    }    

    @Override
    public void deleteAnnouncement(Integer announcementId) {
        Announcement announcement = entityManager.find(Announcement.class, announcementId);
        if (announcement != null) {
            entityManager.remove(announcement);
        }
    }

    @Override
    public Announcement updateAnnouncement(Announcement announcement) {
        return entityManager.merge(announcement);
    }

}
