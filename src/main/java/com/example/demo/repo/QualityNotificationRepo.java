package com.example.demo.repo;

import com.example.demo.model.QualityNotification;
import org.springframework.stereotype.Repository;

@Repository
public interface QualityNotificationRepo extends BaseRepository<QualityNotification, Long> {

}
