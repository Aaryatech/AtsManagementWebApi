package com.ats.taskmgt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_phase_task")
public class PhaseTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="t_task_phase_id")
	private int tTaskPhaseId;
	
	@Column(name="task_phase_id")
	private int taskPhaseId;
	
	@Column(name="task_desc")
	private String taskDesc;
	
	@Column(name="exp_start_date")
	private String expStartDate;
	
	@Column(name="exp_end_date")
	private String expEndDate;
	
	@Column(name="actual_start_date")
	private String actualStartDate;
	
	@Column(name="atcual_end_date")
	private String atcualEndDate;
	
	@Column(name="exp_hrs")
	private String expHrs;
	
	@Column(name="actual_hrs")
	private String actualHrs;
	 
	@Column(name="assigned_to")
	private int assignedTo;
	
	@Column(name="project_id")
	private int projectId;

	public int gettTaskPhaseId() {
		return tTaskPhaseId;
	}

	public void settTaskPhaseId(int tTaskPhaseId) {
		this.tTaskPhaseId = tTaskPhaseId;
	}

	public int getTaskPhaseId() {
		return taskPhaseId;
	}

	public void setTaskPhaseId(int taskPhaseId) {
		this.taskPhaseId = taskPhaseId;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public String getExpStartDate() {
		return expStartDate;
	}

	public void setExpStartDate(String expStartDate) {
		this.expStartDate = expStartDate;
	}

	public String getExpEndDate() {
		return expEndDate;
	}

	public void setExpEndDate(String expEndDate) {
		this.expEndDate = expEndDate;
	}

	public String getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(String actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public String getAtcualEndDate() {
		return atcualEndDate;
	}

	public void setAtcualEndDate(String atcualEndDate) {
		this.atcualEndDate = atcualEndDate;
	}

	public String getExpHrs() {
		return expHrs;
	}

	public void setExpHrs(String expHrs) {
		this.expHrs = expHrs;
	}

	public String getActualHrs() {
		return actualHrs;
	}

	public void setActualHrs(String actualHrs) {
		this.actualHrs = actualHrs;
	}

	public int getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "PhaseTask [tTaskPhaseId=" + tTaskPhaseId + ", taskPhaseId=" + taskPhaseId + ", taskDesc=" + taskDesc
				+ ", expStartDate=" + expStartDate + ", expEndDate=" + expEndDate + ", actualStartDate="
				+ actualStartDate + ", atcualEndDate=" + atcualEndDate + ", expHrs=" + expHrs + ", actualHrs="
				+ actualHrs + ", assignedTo=" + assignedTo + ", projectId=" + projectId + "]";
	}

	 
	

}
