package com.ats.taskmgt.model.proj;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ProjList {

	@Id
	private int projectId;

	private String projectName;

	private int projectAllocatedTo;
	private Date projStartDate;
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getProjStartDate() {
		return projStartDate;
	}

	public void setProjStartDate(Date projStartDate) {
		this.projStartDate = projStartDate;
	}

	private Date projectExpEndDate;

	private Date projectEndDate;

	private int status;

	private String empName;

	private float projPlanHrs;

	private float projActualReqHrs;

	private float projAssignHrs;

	private float projSupportHrs;

	private float projCost;

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

	public int getProjectAllocatedTo() {
		return projectAllocatedTo;
	}

	public void setProjectAllocatedTo(int projectAllocatedTo) {
		this.projectAllocatedTo = projectAllocatedTo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getProjectExpEndDate() {
		return projectExpEndDate;
	}

	public void setProjectExpEndDate(Date projectExpEndDate) {
		this.projectExpEndDate = projectExpEndDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public float getProjPlanHrs() {
		return projPlanHrs;
	}

	public void setProjPlanHrs(float projPlanHrs) {
		this.projPlanHrs = projPlanHrs;
	}

	public float getProjActualReqHrs() {
		return projActualReqHrs;
	}

	public void setProjActualReqHrs(float projActualReqHrs) {
		this.projActualReqHrs = projActualReqHrs;
	}

	public float getProjAssignHrs() {
		return projAssignHrs;
	}

	public void setProjAssignHrs(float projAssignHrs) {
		this.projAssignHrs = projAssignHrs;
	}

	public float getProjSupportHrs() {
		return projSupportHrs;
	}

	public void setProjSupportHrs(float projSupportHrs) {
		this.projSupportHrs = projSupportHrs;
	}

	public float getProjCost() {
		return projCost;
	}

	public void setProjCost(float projCost) {
		this.projCost = projCost;
	}

	@Override
	public String toString() {
		return "ProjList [projectId=" + projectId + ", projectName=" + projectName + ", projectAllocatedTo="
				+ projectAllocatedTo + ", projectExpEndDate=" + projectExpEndDate + ", projectEndDate=" + projectEndDate
				+ ", status=" + status + ", empName=" + empName + ", projPlanHrs=" + projPlanHrs + ", projActualReqHrs="
				+ projActualReqHrs + ", projAssignHrs=" + projAssignHrs + ", projSupportHrs=" + projSupportHrs
				+ ", projCost=" + projCost + "]";
	}
	
	
	

}
