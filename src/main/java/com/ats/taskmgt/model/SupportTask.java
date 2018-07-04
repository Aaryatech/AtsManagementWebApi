package com.ats.taskmgt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_support_task")
public class SupportTask {
	
	
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
	private String workDate;
	
	@Column(name="date")
	private String date;
	
	@Column(name="description")
	private String description;
	
	@Column(name="required_hrs")
	private String requiredHrs;
	
	@Column(name="take_away")
	private String takeAway;

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

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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

	@Override
	public String toString() {
		return "SupportTask [suppId=" + suppId + ", projectId=" + projectId + ", empId=" + empId + ", moduleName="
				+ moduleName + ", workDate=" + workDate + ", date=" + date + ", description=" + description
				+ ", requiredHrs=" + requiredHrs + ", takeAway=" + takeAway + "]";
	}
	  
	

}
