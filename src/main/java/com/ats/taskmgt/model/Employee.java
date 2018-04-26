package com.ats.taskmgt.model;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "m_employee")
public class Employee {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="emp_mobile")
	private String empMobile;
	
	@Column(name="emp_edu")
	private String empEdu;
	
	@Column(name="emp_birthdate")
	private String empBirthdate;
	
	@Column(name="emp_designation")
	private String empDesignation;
	
	@Column(name="emp_pwd")
	private String empPwd;
	
	@Column(name="emp_prev_exp")
	private String empPrevExp;
	
	@Column(name="emp_joining_date")
	private String empJoiningDate;
	
	@Column(name="is_used")
	private int isUsed;
	
	@Column(name="emp_per_hr_rate")
	private float empPerHrRate;

	@Column(name="emp_type")
	private int empType;
	
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

	public String getEmpMobile() {
		return empMobile;
	}

	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}

	public String getEmpEdu() {
		return empEdu;
	}

	public void setEmpEdu(String empEdu) {
		this.empEdu = empEdu;
	}
	 
	public String getEmpBirthdate() {
		return empBirthdate;
	}

	public void setEmpBirthdate(String empBirthdate) {
		this.empBirthdate = empBirthdate;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public String getEmpPrevExp() {
		return empPrevExp;
	}

	public void setEmpPrevExp(String empPrevExp) {
		this.empPrevExp = empPrevExp;
	}
	 
	public String getEmpJoiningDate() {
		return empJoiningDate;
	}

	public void setEmpJoiningDate(String empJoiningDate) {
		this.empJoiningDate = empJoiningDate;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public float getEmpPerHrRate() {
		return empPerHrRate;
	}

	public void setEmpPerHrRate(float empPerHrRate) {
		this.empPerHrRate = empPerHrRate;
	}

	public int getEmpType() {
		return empType;
	}

	public void setEmpType(int empType) {
		this.empType = empType;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empMobile=" + empMobile + ", empEdu=" + empEdu
				+ ", empBirthdate=" + empBirthdate + ", empDesignation=" + empDesignation + ", empPwd=" + empPwd
				+ ", empPrevExp=" + empPrevExp + ", empJoiningDate=" + empJoiningDate + ", isUsed=" + isUsed
				+ ", empPerHrRate=" + empPerHrRate + ", empType=" + empType + "]";
	}
	
	
	

}
