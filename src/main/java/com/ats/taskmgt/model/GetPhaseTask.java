package com.ats.taskmgt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetPhaseTask {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="t_task_phase_id")
	private int tTaskPhaseId;
	
	@Column(name="task_phase_id")
	private int taskPhaseId;
	
	@Column(name="task_desc")
	private String taskDesc;
	
	@Column(name="exp_start_date")
	private Date expStartDate;
	
	@Column(name="exp_end_date")
	private Date expEndDate;
	
	@Column(name="actual_start_date")
	private Date actualStartDate;
	
	@Column(name="atcual_end_date")
	private Date atcualEndDate;
	
	@Column(name="exp_hrs")
	private String expHrs;
	
	@Column(name="actual_hrs")
	private String actualHrs;
	 
	@Column(name="assigned_to")
	private int assignedTo;
	
	@Column(name="project_id")
	private int projectId;
	
	@Column(name="project_name")
	private String projectName;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="phase_name")
	private String phaseName;

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
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getExpStartDate() {
		return expStartDate;
	}

	public void setExpStartDate(Date expStartDate) {
		this.expStartDate = expStartDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getExpEndDate() {
		return expEndDate;
	}

	public void setExpEndDate(Date expEndDate) {
		this.expEndDate = expEndDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getAtcualEndDate() {
		return atcualEndDate;
	}

	public void setAtcualEndDate(Date atcualEndDate) {
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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPhaseName() {
		return phaseName;
	}

	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	@Override
	public String toString() {
		return "GetPhaseTask [tTaskPhaseId=" + tTaskPhaseId + ", taskPhaseId=" + taskPhaseId + ", taskDesc=" + taskDesc
				+ ", expStartDate=" + expStartDate + ", expEndDate=" + expEndDate + ", actualStartDate="
				+ actualStartDate + ", atcualEndDate=" + atcualEndDate + ", expHrs=" + expHrs + ", actualHrs="
				+ actualHrs + ", assignedTo=" + assignedTo + ", projectId=" + projectId + ", projectName=" + projectName
				+ ", empName=" + empName + ", phaseName=" + phaseName + "]";
	}
	
	
	

}
