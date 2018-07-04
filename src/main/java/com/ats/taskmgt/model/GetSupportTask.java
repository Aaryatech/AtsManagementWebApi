package com.ats.taskmgt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetSupportTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="supp_id")
	private int suppId;
	
	@Column(name="project_id")
	private int projectId;
	
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="module_name")
	private String moduleName;
	
	@Column(name="work_date")
	private Date workDate;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="description")
	private String description;
	
	@Column(name="required_hrs")
	private String requiredHrs;
	
	@Column(name="take_away")
	private String takeAway;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="project_name")
	private String projectName;

	public int getSuppId() {
		return suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequiredHrs() {
		return requiredHrs;
	}

	public void setRequiredHrs(String requiredHrs) {
		this.requiredHrs = requiredHrs;
	}

	public String getTakeAway() {
		return takeAway;
	}

	public void setTakeAway(String takeAway) {
		this.takeAway = takeAway;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "GetSupportTask [suppId=" + suppId + ", projectId=" + projectId + ", empId=" + empId + ", moduleName="
				+ moduleName + ", workDate=" + workDate + ", date=" + date + ", description=" + description
				+ ", requiredHrs=" + requiredHrs + ", takeAway=" + takeAway + ", empName=" + empName + ", projectName="
				+ projectName + "]";
	}
	
	

}
