package com.ats.taskmgt.graph.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ActualHrs {

	@Id
	private int taskId;

	private String actualReqHrs;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getActualReqHrs() {
		return actualReqHrs;
	}

	public void setActualReqHrs(String actualReqHrs) {
		this.actualReqHrs = actualReqHrs;
	}

	@Override
	public String toString() {
		return "ActualHrs [taskId=" + taskId + ", actualReqHrs=" + actualReqHrs + "]";
	}

}
