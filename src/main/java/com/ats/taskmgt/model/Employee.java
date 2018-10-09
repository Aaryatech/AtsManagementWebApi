package com.ats.taskmgt.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private int empId;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "emp_mobile")
	private String empMobile;

	@Column(name = "emp_edu")
	private String empEdu;

	@Column(name = "emp_birthdate")
	private String empBirthdate;

	@Column(name = "emp_designation")
	private String empDesignation;

	@Column(name = "emp_pwd")
	private String empPwd;

	@Column(name = "emp_prev_exp")
	private String empPrevExp;

	@Column(name = "emp_joining_date")
	private String empJoiningDate;

	@Column(name = "is_used")
	private int isUsed;

	@Column(name = "emp_per_hr_rate")
	private float empPerHrRate;

	@Column(name = "emp_type")
	private int empType;

	@Column(name = "total_leaves")
	private int totalLeaves;

	@Column(name = "from_date")
	private String fromDate;

	@Column(name = "to_date")
	private String toDate;

	@Column(name = "sick_leave")
	private float sickLeave;

	@Column(name = "causal_leave")
	private float causalLeave;

	@Column(name = "tech_id")
	private int techId;

	@Column(name = "m_phase_id")
	private int mPhaseId;

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

	public int getTotalLeaves() {
		return totalLeaves;
	}

	public void setTotalLeaves(int totalLeaves) {
		this.totalLeaves = totalLeaves;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public float getSickLeave() {
		return sickLeave;
	}

	public void setSickLeave(float sickLeave) {
		this.sickLeave = sickLeave;
	}

	public float getCausalLeave() {
		return causalLeave;
	}

	public void setCausalLeave(float causalLeave) {
		this.causalLeave = causalLeave;
	}

	public int getTechId() {
		return techId;
	}

	public void setTechId(int techId) {
		this.techId = techId;
	}

	public int getmPhaseId() {
		return mPhaseId;
	}

	public void setmPhaseId(int mPhaseId) {
		this.mPhaseId = mPhaseId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empMobile=" + empMobile + ", empEdu=" + empEdu
				+ ", empBirthdate=" + empBirthdate + ", empDesignation=" + empDesignation + ", empPwd=" + empPwd
				+ ", empPrevExp=" + empPrevExp + ", empJoiningDate=" + empJoiningDate + ", isUsed=" + isUsed
				+ ", empPerHrRate=" + empPerHrRate + ", empType=" + empType + ", totalLeaves=" + totalLeaves
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", sickLeave=" + sickLeave + ", causalLeave="
				+ causalLeave + ", techId=" + techId + ", mPhaseId=" + mPhaseId + "]";
	}

}
