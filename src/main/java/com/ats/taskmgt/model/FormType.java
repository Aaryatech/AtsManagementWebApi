package com.ats.taskmgt.model;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_form_type")
public class FormType {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="form_type_id")
	private int formTypeId;
	
	@Column(name="form_type_name")
	private String formTypeName;
	
	@Column(name="is_used")
	private int isUsed;
	
	private int mPhaseId;
	private int techId;

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

	@Override
	public String toString() {
		return "FormType [formTypeId=" + formTypeId + ", formTypeName=" + formTypeName + ", isUsed=" + isUsed
				+ ", mPhaseId=" + mPhaseId + ", techId=" + techId + "]";
	}
	
	
	
	 
}
