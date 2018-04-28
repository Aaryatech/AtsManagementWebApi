package com.ats.taskmgt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_phase_type")
public class PhaseType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="m_phase_id")
	private int mPhaseId;
	
	@Column(name="phase_name")
	private String phaseName;
	 
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="is_used")
	private int isUsed;

	public int getmPhaseId() {
		return mPhaseId;
	}

	public void setmPhaseId(int mPhaseId) {
		this.mPhaseId = mPhaseId;
	}

	public String getPhaseName() {
		return phaseName;
	}

	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "PhaseType [mPhaseId=" + mPhaseId + ", phaseName=" + phaseName + ", orderId=" + orderId + ", isUsed="
				+ isUsed + "]";
	}
	
	

}
