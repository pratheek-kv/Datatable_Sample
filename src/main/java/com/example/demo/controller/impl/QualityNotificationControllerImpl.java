package com.example.demo.controller.impl;

import com.example.demo.controller.QualityNotificationController;

import com.example.demo.datatablev2.AnnotationTableBuilder;
import com.example.demo.datatablev2.controller.DataTableControllerImpl;
import com.example.demo.datatablev2.dto.filtercriteria.FilterCriteria;
import com.example.demo.datatablev2.impl.DataTableBuilder;
import com.example.demo.dto.QualityNotificationDTO;
import com.example.demo.mappers.QualityNotificationMapper;
import com.example.demo.model.QualityNotification;
import com.example.demo.service.QualityNotificationService;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quality_notif")
public class QualityNotificationControllerImpl extends DataTableControllerImpl<QualityNotification, QualityNotificationDTO> implements QualityNotificationController  {

    public QualityNotificationControllerImpl(DataTableBuilder dataTableBuilder, QualityNotificationService baseService, QualityNotificationMapper mapper) {
        super(dataTableBuilder, baseService, "QualityNotification",mapper);
    }

    @GetMapping("user")
    String getUser() {
      Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

}
