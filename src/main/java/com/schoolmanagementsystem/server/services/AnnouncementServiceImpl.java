package com.schoolmanagementsystem.server.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.server.dao.AdminDaoImpl;
import com.schoolmanagementsystem.server.dao.AnnouncementDaoImpl;
import com.schoolmanagementsystem.server.models.Admin;
import com.schoolmanagementsystem.server.models.Announcement;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementDaoImpl announcementDaoImpl;
    private final AdminDaoImpl adminDaoImpl;

    public AnnouncementServiceImpl(AnnouncementDaoImpl announcementDaoImpl, AdminDaoImpl adminDaoImpl){
        this.announcementDaoImpl = announcementDaoImpl;
        this.adminDaoImpl = adminDaoImpl;
    }
    @Override
    public Announcement createAnnouncement(Announcement announcement) {
        Admin sender = adminDaoImpl.findByAdminId(announcement.getSenderId());
        if (sender != null) {
            announcement.setSender(sender);
            return announcementDaoImpl.saveAnnouncement(announcement);
        } else {
            System.out.println("parent not found");
            return null;
        }
    }

    @Override
    public Announcement getAnnouncementById(Integer announcementId) {
        return announcementDaoImpl.findByAnnouncementId(announcementId);
    }

    @Override
    public void deleteAnnouncement(Integer announcementId) {
        announcementDaoImpl.deleteAnnouncement(announcementId);
    }

    @Override
    public List<Announcement> getAllAnnouncements() {
        return announcementDaoImpl.getAllAnnouncements();
    }

    @Override
    public Announcement updateAnnouncement(Announcement announcement) {
        return announcementDaoImpl.updateAnnouncement(announcement);
    }
    @Override
    public Announcement getAnnouncementWithSender(Integer announcementId) {
        Announcement announcement = announcementDaoImpl.findByAnnouncementId(announcementId);
        if (announcement != null) {
            announcement.getSender();
        }
        return announcement;
    }
}