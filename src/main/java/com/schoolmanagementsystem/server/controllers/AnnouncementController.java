package com.schoolmanagementsystem.server.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagementsystem.server.services.AdminServiceImpl;
import com.schoolmanagementsystem.server.models.Admin;
import com.schoolmanagementsystem.server.models.Announcement;
import com.schoolmanagementsystem.server.services.AnnouncementServiceImpl;

@RestController
@RequestMapping("/api/v1/announcement")
public class AnnouncementController {

    private final AnnouncementServiceImpl announcementServiceImpl;
    private final AdminServiceImpl adminServiceImpl;

    public AnnouncementController(AnnouncementServiceImpl announcementServiceImpl, AdminServiceImpl adminServiceImpl){
        this.announcementServiceImpl = announcementServiceImpl;
        this.adminServiceImpl = adminServiceImpl;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Announcement>> getAllAnnouncements() {
        List<Announcement> announcements = announcementServiceImpl.getAllAnnouncements();
        return new ResponseEntity<>(announcements, HttpStatus.OK);
    }

    @GetMapping("get/{announcementId}")
    public ResponseEntity<Announcement> getAnnouncementById(@PathVariable Integer announcementId) {
        Announcement announcement = announcementServiceImpl.getAnnouncementById(announcementId);
        if (announcement != null) {
            return new ResponseEntity<>(announcement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Announcement> createAnnouncement(@RequestBody Announcement announcement) {
        Admin admin = adminServiceImpl.getAdminById(announcement.getSenderId());
        if (admin != null) {
            Announcement createdAnnouncement = announcementServiceImpl.createAnnouncement(announcement);
            return new ResponseEntity<Announcement>(createdAnnouncement, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("put/{announcementId}")
    public ResponseEntity<Announcement> updateAnnouncement(@PathVariable Integer announcementId, @RequestBody Announcement announcement) {
        Announcement existingAnnouncement = announcementServiceImpl.getAnnouncementById(announcementId);
        if (existingAnnouncement != null) {
            announcement.setAnnouncementId(announcementId);
            Announcement updatedAnnouncement = announcementServiceImpl.updateAnnouncement(announcement);
            return new ResponseEntity<>(updatedAnnouncement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("delete/{announcementId}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Integer announcementId) {
        Announcement announcement = announcementServiceImpl.getAnnouncementById(announcementId);
        if (announcement != null) {
            announcementServiceImpl.deleteAnnouncement(announcementId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
}
