package com.ats.taskmgt.graph.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class EmployeeListWithActualHrs {

	@Id
	private int empId;
	private String empName;

	@Transient
	List<ActualHrs> actualHrsList;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public List<ActualHrs> getActualHrsList() {
		return actualHrsList;
	}

	public void setActualHrsList(List<ActualHrs> actualHrsList) {
		this.actualHrsList = actualHrsList;
	}

	@Override
	public String toString() {
		return "EmployeeListWithActualHrs [empId=" + empId + ", empName=" + empName + ", actualHrsList=" + actualHrsList
				+ "]";
	}

}
