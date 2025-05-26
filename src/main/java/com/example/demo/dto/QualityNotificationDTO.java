package com.example.demo.dto;

public class QualityNotificationDTO {

    private Long id;
    private String notificationType;  // Raw enum value
    private String supplier;
    private Integer orderNumber;
    private Integer batchNo;
    private String material;
    private String serialNumber;
    private String criticality;  // Raw enum value
    private String status;  // Raw enum value

    // Translated labels for display
    private String notificationTypeLabel;
    private String criticalityLabel;
    private String statusLabel;

    // Getters and Setters for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(Integer batchNo) {
        this.batchNo = batchNo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCriticality() {
        return criticality;
    }

    public void setCriticality(String criticality) {
        this.criticality = criticality;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
