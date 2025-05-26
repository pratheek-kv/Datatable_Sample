package com.example.demo.service;

import com.example.demo.model.QualityNotification;
import com.example.demo.repo.QualityNotificationRepo;
import com.example.demo.repo.specification.QualityNotificationSpecification;
import org.springframework.stereotype.Service;

@Service
public class QualityNotificationService extends AbstractService<QualityNotification> {

    public QualityNotificationService(QualityNotificationRepo qualityNotificationRepository) {
        super(qualityNotificationRepository, new QualityNotificationSpecification());
    }

}
