package com.schoolmanagementsystem.server.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "announcement")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "announcement_id")
    private Integer announcementId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "date_posted", nullable = false)
    private Date datePosted;

    @Column(name = "sender_id", nullable = false)
    private Integer senderId;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "admin_id",updatable = false, insertable = false, nullable = false)
    private Admin sender;

    public Announcement() {
    }

    public Announcement(String title, String content, Date datePosted, Integer senderId) {
        this.title = title;
        this.content = content;
        this.datePosted = datePosted;
        this.senderId = senderId;
    }

    public Integer getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Integer announcementId) {
        this.announcementId = announcementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Admin getSender() {
        return sender;
    }

    public void setSender(Admin sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Announcement [announcementId=" + announcementId + ", title=" + title + ", content=" + content
                + ", datePosted=" + datePosted + ", senderId=" + senderId + ", sender=" + sender + "]";
    }
}
