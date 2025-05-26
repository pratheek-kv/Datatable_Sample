package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class QualityNotificationTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quality_notification_id", nullable = false)
    private QualityNotification qualityNotification;

    private String language; // e.g., "en", "de"

    // Translations for enums
    private String notificationTypeLabel;
    private String criticalityLabel;
    private String statusLabel;

    // Optional: Add unique constraint per qualityNotification and language
    @PrePersist
    @PreUpdate
    public void normalizeLanguage() {
        if (language != null) {
            language = language.toLowerCase();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QualityNotification getQualityNotification() {
        return qualityNotification;
    }

    public void setQualityNotification(QualityNotification qualityNotification) {
        this.qualityNotification = qualityNotification;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNotificationTypeLabel() {
        return notificationTypeLabel;
    }

    public void setNotificationTypeLabel(String notificationTypeLabel) {
        this.notificationTypeLabel = notificationTypeLabel;
    }

    public String getCriticalityLabel() {
        return criticalityLabel;
    }

    public void setCriticalityLabel(String criticalityLabel) {
        this.criticalityLabel = criticalityLabel;
    }

    public String getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(String statusLabel) {
        this.statusLabel = statusLabel;
    }
}

