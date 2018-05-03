package com.ats.taskmgt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DevloperListFromTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="task_id")
	private int taskId;
	
	@Column(name="developer_id")
	private int developerId;
	
	@Column(name="developer_name")
	private String developerName;
	
	@Column(name="actual_req_hrs")
	private float actualReqHrs;
	
	@Column(name="emp_per_hr_rate")
	private float empPerHrRate;
	
	@Column(name="devlopement_cost")
	private float devlopementCost;

	public int getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public float getActualReqHrs() {
		return actualReqHrs;
	}

	public void setActualReqHrs(float actualReqHrs) {
		this.actualReqHrs = actualReqHrs;
	}

	public float getEmpPerHrRate() {
		return empPerHrRate;
	}

	public void setEmpPerHrRate(float empPerHrRate) {
		this.empPerHrRate = empPerHrRate;
	}

	public float getDevlopementCost() {
		return devlopementCost;
	}

	public void setDevlopementCost(float devlopementCost) {
		this.devlopementCost = devlopementCost;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	@Override
	public String toString() {
		return "DevloperListFromTask [taskId=" + taskId + ", developerId=" + developerId + ", developerName="
				+ developerName + ", actualReqHrs=" + actualReqHrs + ", empPerHrRate=" + empPerHrRate
				+ ", devlopementCost=" + devlopementCost + "]";
	}
	
	

}
