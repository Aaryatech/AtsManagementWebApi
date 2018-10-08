package com.ats.taskmgt.model.txapi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetFormType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "form_type_id")
	private int formTypeId;

	@Column(name = "form_type_name")
	private String formTypeName;

	@Column(name = "is_used")
	private int isUsed;

	private int mPhaseId;
	private int techId;

	private String phaseName;
	private String techName;

	public int getFormTypeId() {
		return formTypeId;
	}

	public void setFormTypeId(int formTypeId) {
		this.formTypeId = formTypeId;
	}

	public String getFormTypeName() {
		return formTypeName;
	}

	public void setFormTypeName(String formTypeName) {
		this.formTypeName = formTypeName;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public int getmPhaseId() {
		return mPhaseId;
	}

	public void setmPhaseId(int mPhaseId) {
		this.mPhaseId = mPhaseId;
	}

	public int getTechId() {
		return techId;
	}

	public void setTechId(int techId) {
		this.techId = techId;
	}

	public String getPhaseName() {
		return phaseName;
	}

	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	@Override
	public String toString() {
		return "GetFormType [formTypeId=" + formTypeId + ", formTypeName=" + formTypeName + ", isUsed=" + isUsed
				+ ", mPhaseId=" + mPhaseId + ", techId=" + techId + ", phaseName=" + phaseName + ", techName="
				+ techName + "]";
	}

}
