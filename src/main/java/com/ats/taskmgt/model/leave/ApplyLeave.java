package com.ats.taskmgt.model.leave;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "apply_leave")
public class ApplyLeave {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "leave_id")
	private int leaveId;

	private String date;
	private String fromDate;
	private String toDate;
	private String approveDate;
	private int type;
	private int status;
	private int noOfDays;
	private int empId;

	private String empRemark;
	private String approveRemark;
	private int sendTo;

	private int isUsed;

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(String approveDate) {
		this.approveDate = approveDate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpRemark() {
		return empRemark;
	}

	public void setEmpRemark(String empRemark) {
		this.empRemark = empRemark;
	}

	public String getApproveRemark() {
		return approveRemark;
	}

	public void setApproveRemark(String approveRemark) {
		this.approveRemark = approveRemark;
	}

	public int getSendTo() {
		return sendTo;
	}

	public void setSendTo(int sendTo) {
		this.sendTo = sendTo;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "ApplyLeave [leaveId=" + leaveId + ", date=" + date + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", approveDate=" + approveDate + ", type=" + type + ", status=" + status + ", noOfDays=" + noOfDays
				+ ", empId=" + empId + ", empRemark=" + empRemark + ", approveRemark=" + approveRemark + ", sendTo="
				+ sendTo + ", isUsed=" + isUsed + "]";
	}

}
