package com.schoolmanagementsystem.server.dao;

import java.util.List;

import com.schoolmanagementsystem.server.models.Announcement;

public interface AnnouncementDao {
    List<Announcement> getAllAnnouncements();
    Announcement findByAnnouncementId(Integer announcementId);
    Announcement saveAnnouncement(Announcement announcement);
    void deleteAnnouncement(Integer announcementId);
    Announcement updateAnnouncement(Announcement announcement);
}
