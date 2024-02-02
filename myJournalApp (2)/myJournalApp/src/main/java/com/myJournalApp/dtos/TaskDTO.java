package com.myJournalApp.dtos;

import java.util.Date;

public class TaskDTO {
    private Long id;
    private String taskName;
    private String taskDesc;
    private Date taskDate;
    private Date createdTS;
    private Long createdBy;
    private String createdByName;
    private Long updatedBy;
    private String updatedByName;
    private Date updatedTS;

    public TaskDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getTaskDesc() {
        return this.taskDesc;
    }

    public void setTaskDate(java.util.Date taskDate) {
        this.taskDate = taskDate;
    }

    public java.util.Date getTaskDate() {
        return this.taskDate;
    }

    public void setUpdatedTS(java.util.Date updatedTS) {
        this.updatedTS = updatedTS;
    }

    public java.util.Date getUpdatedTS() {
        return this.updatedTS;
    }

    public Date getCreatedTS() {
        return createdTS;
    }

    public void setCreatedTS(Date createdTS) {
        this.createdTS = createdTS;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public String getUpdatedByName() {
        return updatedByName;
    }

    public void setUpdatedByName(String updatedByName) {
        this.updatedByName = updatedByName;
    }
}