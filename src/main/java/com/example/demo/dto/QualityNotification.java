package com.example.demo.dto;

import com.example.demo.datatablev2.annotation.DataTableColumn;
import com.example.demo.datatablev2.annotation.DataTableEntity;

@DataTableEntity(name = "QualityNotification")
public class QualityNotification {

    @DataTableColumn(label = "{notification.id}", align = "center", sortable = true)
    private Long id;

    @DataTableColumn(label = "{notification.type}", align = "left")
    private String type;

    @DataTableColumn(label = "{notification.status}", align = "right", sortable = true)
    private String status;

}