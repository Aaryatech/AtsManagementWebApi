package com.ats.taskmgt.model;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 

@Entity
@Table(name = "t_task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="task_id")
	private int taskId;
	
	@Column(name="project_id")
	private int projectId;
	
	@Column(name="module_id")
	private int moduleId;
	
	@Column(name="form_id")
	private int formId;
	
	@Column(name="task_type_id")
	private int taskTypeId;
	
	@Column(name="task_name")
	private String taskName;
	
	@Column(name="task_description")
	private String taskDescription;
	
	@Column(name="task_sp_remarks")
	private String taskSpRemarks;
	
	@Column(name="task_planned_hrs")
	private String taskPlannedHrs;
	 
	@Column(name="developer_id")
	private int developerId;
	
	@Column(name="tester_id")
	private int testerId;
	
	@Column(name="assigned_by")
	private int assignedBy;
	
	@Column(name="start_date")
	private String startDate;
	
	@Column(name="start_datetime")
	private String startDatetime;
	
	@Column(name="dev_compl_per")
	private String devComplPer;
	
	@Column(name="end_date")
	private String endDate;
	
	@Column(name="end_datetime")
	private String endDatetime;
	
	@Column(name="dev_status")
	private int devStatus;
	
	@Column(name="actual_req_hrs")
	private String actualReqHrs;
	
	@Column(name="tester_status")
	private int testerStatus;
	
	@Column(name="remarks_by_dev")
	private String remarksByDev;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public int getTaskTypeId() {
		return taskTypeId;
	}

	public void setTaskTypeId(int taskTypeId) {
		this.taskTypeId = taskTypeId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskSpRemarks() {
		return taskSpRemarks;
	}

	public void setTaskSpRemarks(String taskSpRemarks) {
		this.taskSpRemarks = taskSpRemarks;
	}

	public String getTaskPlannedHrs() {
		return taskPlannedHrs;
	}

	public void setTaskPlannedHrs(String taskPlannedHrs) {
		this.taskPlannedHrs = taskPlannedHrs;
	}

	public int getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}

	public int getTesterId() {
		return testerId;
	}

	public void setTesterId(int testerId) {
		this.testerId = testerId;
	}

	public int getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(int assignedBy) {
		this.assignedBy = assignedBy;
	}
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartDatetime() {
		return startDatetime;
	}

	public void setStartDatetime(String startDatetime) {
		this.startDatetime = startDatetime;
	}

	public String getDevComplPer() {
		return devComplPer;
	}

	public void setDevComplPer(String devComplPer) {
		this.devComplPer = devComplPer;
	}
	 
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEndDatetime() {
		return endDatetime;
	}

	public void setEndDatetime(String endDatetime) {
		this.endDatetime = endDatetime;
	}

	public int getDevStatus() {
		return devStatus;
	}

	public void setDevStatus(int devStatus) {
		this.devStatus = devStatus;
	}

	public String getActualReqHrs() {
		return actualReqHrs;
	}

	public void setActualReqHrs(String actualReqHrs) {
		this.actualReqHrs = actualReqHrs;
	}

	public int getTesterStatus() {
		return testerStatus;
	}

	public void setTesterStatus(int testerStatus) {
		this.testerStatus = testerStatus;
	}

	public String getRemarksByDev() {
		return remarksByDev;
	}

	public void setRemarksByDev(String remarksByDev) {
		this.remarksByDev = remarksByDev;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", projectId=" + projectId + ", moduleId=" + moduleId + ", formId=" + formId
				+ ", taskTypeId=" + taskTypeId + ", taskName=" + taskName + ", taskDescription=" + taskDescription
				+ ", taskSpRemarks=" + taskSpRemarks + ", taskPlannedHrs=" + taskPlannedHrs + ", developerId="
				+ developerId + ", testerId=" + testerId + ", assignedBy=" + assignedBy + ", startDate=" + startDate
				+ ", startDatetime=" + startDatetime + ", devComplPer=" + devComplPer + ", endDate=" + endDate
				+ ", endDatetime=" + endDatetime + ", devStatus=" + devStatus + ", actualReqHrs=" + actualReqHrs
				+ ", testerStatus=" + testerStatus + ", remarksByDev=" + remarksByDev + "]";
	}
	
	
	
	

}
