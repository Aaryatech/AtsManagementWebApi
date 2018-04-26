package com.ats.taskmgt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_projects")
public class Project {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="project_id")
	private int projectId;
	
	@Column(name="project_name")
	private String projectName;
	
	@Column(name="project_description")
	private String projectDescription;
	
	@Column(name="reference_by")
	private String referenceBy;
	
	@Column(name="project_cost")
	private String projectCost;
	
	@Column(name="project_allocated_to")
	private int projectAllocatedTo;
	
	@Column(name="project_start_date")
	private Date projectStartDate;
	
	@Column(name="dev_per")
	private String devPer;
	
	@Column(name="comp_per")
	private String compPer;
	 
	@Column(name="status")
	private int status;
	
	@Column(name="project_end_date")
	private Date projectEndDate;

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

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	
	public String getReferenceBy() {
		return referenceBy;
	}

	public void setReferenceBy(String referenceBy) {
		this.referenceBy = referenceBy;
	}

	public String getProjectCost() {
		return projectCost;
	}

	public void setProjectCost(String projectCost) {
		this.projectCost = projectCost;
	}

	public int getProjectAllocatedTo() {
		return projectAllocatedTo;
	}

	public void setProjectAllocatedTo(int projectAllocatedTo) {
		this.projectAllocatedTo = projectAllocatedTo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getProjectStartDate() {
		return projectStartDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public String getDevPer() {
		return devPer;
	}

	public void setDevPer(String devPer) {
		this.devPer = devPer;
	}

	public String getCompPer() {
		return compPer;
	}

	public void setCompPer(String compPer) {
		this.compPer = compPer;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getProjectEndDate() {
		return projectEndDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectDescription="
				+ projectDescription + ", referenceBy=" + referenceBy + ", projectCost=" + projectCost
				+ ", projectAllocatedTo=" + projectAllocatedTo + ", projectStartDate=" + projectStartDate + ", devPer="
				+ devPer + ", compPer=" + compPer + ", status=" + status + ", projectEndDate=" + projectEndDate + "]";
	}
	
	
	
	
	

}
