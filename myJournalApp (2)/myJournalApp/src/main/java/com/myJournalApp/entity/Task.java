package com.myJournalApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myJournalApp.dtos.TaskDTO;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="task")
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false)
	private String taskName;
	
	@Column(nullable=false)
	private String taskDesc;

	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date taskDate;

	private Date createdTS;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User createdBy;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User updatedBy;

	private Date updatedTS;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public Date getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}

	public Date getCreatedTS() {
		return createdTS;
	}

	public void setCreatedTS(Date createdTS) {
		this.createdTS = createdTS;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedTS() {
		return updatedTS;
	}

	public void setUpdatedTS(Date updatedTS) {
		this.updatedTS = updatedTS;
	}

	public TaskDTO getDto(){
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setId(id);
		taskDTO.setTaskName(taskName);
		taskDTO.setTaskDesc(taskDesc);
		taskDTO.setTaskDate(taskDate);
		taskDTO.setCreatedTS(createdTS);
		taskDTO.setUpdatedTS(updatedTS);
		taskDTO.setCreatedBy(createdBy.getId());
		taskDTO.setUpdatedBy(updatedBy.getId());
		taskDTO.setUpdatedByName(updatedBy.getName());
		taskDTO.setCreatedByName(createdBy.getName());

		return taskDTO;
	}
}
