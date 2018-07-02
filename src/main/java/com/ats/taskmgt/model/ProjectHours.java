package com.ats.taskmgt.model;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class ProjectHours {

	@Id
	private int projectId;

	private String projectName;
	private float taskPlannedHrs;
	private float actualReqHrs;

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

	public float getTaskPlannedHrs() {
		return taskPlannedHrs;
	}

	public void setTaskPlannedHrs(float taskPlannedHrs) {
		this.taskPlannedHrs = taskPlannedHrs;
	}

	public float getActualReqHrs() {
		return actualReqHrs;
	}

	public void setActualReqHrs(float actualReqHrs) {
		this.actualReqHrs = actualReqHrs;
	}

	@Override
	public String toString() {
		return "ProjectHours [projectId=" + projectId + ", projectName=" + projectName + ", taskPlannedHrs="
				+ taskPlannedHrs + ", actualReqHrs=" + actualReqHrs + "]";
	}

}
