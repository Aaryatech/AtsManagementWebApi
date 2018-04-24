package com.ats.taskmgt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_task_type")
public class TaskType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="task_type_id")
	private int taskTypeId;
	
	@Column(name="task_type_name")
	private String taskTypeName;
	
	@Column(name="task_type")
	private int taskType;
	
	@Column(name="task_planned_hrs")
	private String taskPlannedHrs;
	
	@Column(name="is_used")
	private int isUsed;

	public int getTaskTypeId() {
		return taskTypeId;
	}

	public void setTaskTypeId(int taskTypeId) {
		this.taskTypeId = taskTypeId;
	}

	public String getTaskTypeName() {
		return taskTypeName;
	}

	public void setTaskTypeName(String taskTypeName) {
		this.taskTypeName = taskTypeName;
	}

	public int getTaskType() {
		return taskType;
	}

	public void setTaskType(int taskType) {
		this.taskType = taskType;
	}

	public String getTaskPlannedHrs() {
		return taskPlannedHrs;
	}

	public void setTaskPlannedHrs(String taskPlannedHrs) {
		this.taskPlannedHrs = taskPlannedHrs;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "TastType [taskTypeId=" + taskTypeId + ", taskTypeName=" + taskTypeName + ", taskType=" + taskType
				+ ", taskPlannedHrs=" + taskPlannedHrs + ", isUsed=" + isUsed + "]";
	}
	
	
	

}
