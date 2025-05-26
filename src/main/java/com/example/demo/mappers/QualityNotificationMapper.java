package com.example.demo.mappers;

import com.example.demo.datatablev2.mapper.DataMapper;
import com.example.demo.dto.QualityNotificationDTO;
import com.example.demo.model.QualityNotification;
import com.example.demo.service.TranslationService;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class QualityNotificationMapper implements DataMapper<QualityNotification, QualityNotificationDTO> {

    private final TranslationService translationService;

    public QualityNotificationMapper() {
        this.translationService = new TranslationService();
    }

    public QualityNotificationDTO mapToDTO(QualityNotification notification, Locale locale) {
        QualityNotificationDTO dto = new QualityNotificationDTO();

        // Set basic fields
        dto.setId(notification.getId());
        dto.setNotificationType(notification.getNotificationType().toString());
        dto.setSupplier(notification.getSupplier());
        dto.setOrderNumber(notification.getOrderNumber());
        dto.setBatchNo(notification.getBatchNo());
        dto.setMaterial(notification.getMaterial());
        dto.setSerialNumber(notification.getSerialNumber());
        dto.setCriticality(notification.getCriticality().toString());
        dto.setStatus(notification.getStatus().toString());

        // Translate enum labels using the TranslationService
        dto.setNotificationTypeLabel(translationService.getNotificationTypeLabel(notification.getNotificationType().toString(), locale));
        dto.setCriticalityLabel(translationService.getCriticalityLabel(notification.getCriticality().toString(), locale));
        dto.setStatusLabel(translationService.getStatusLabel(notification.getStatus().toString(), locale));

        return dto;
    }
}


