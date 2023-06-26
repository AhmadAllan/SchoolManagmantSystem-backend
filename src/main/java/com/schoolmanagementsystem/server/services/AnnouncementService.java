package com.schoolmanagementsystem.server.services;

import java.util.List;

import com.schoolmanagementsystem.server.models.Announcement;

public interface AnnouncementService {
    Announcement createAnnouncement(Announcement announcement);
    Announcement getAnnouncementById(Integer announcementId);
    Announcement getAnnouncementWithSender(Integer announcementId);
    void deleteAnnouncement(Integer announcementId);
    List<Announcement> getAllAnnouncements();
    Announcement updateAnnouncement(Announcement announcement);
}
