package com.ats.taskmgt.model.txapi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetTech {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int techId;
	private String techName;
	private String techDesc;
	private int mPhaseId;
	private int isUsed;
	private String techDate;

	private String phaseName;

	private int inta;
	private int intb;
	private int intc;

	@Column(name = "varchar1")
	private String varcharA;
	@Column(name = "varchar2")
	private String varcharB;
	@Column(name = "varchar3")
	private String varcharC;

	public int getTechId() {
		return techId;
	}

	public void setTechId(int techId) {
		this.techId = techId;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public String getTechDesc() {
		return techDesc;
	}

	public void setTechDesc(String techDesc) {
		this.techDesc = techDesc;
	}

	public int getmPhaseId() {
		return mPhaseId;
	}

	public void setmPhaseId(int mPhaseId) {
		this.mPhaseId = mPhaseId;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public String getTechDate() {
		return techDate;
	}

	public void setTechDate(String techDate) {
		this.techDate = techDate;
	}

	public String getPhaseName() {
		return phaseName;
	}

	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	public int getInta() {
		return inta;
	}

	public void setInta(int inta) {
		this.inta = inta;
	}

	public int getIntb() {
		return intb;
	}

	public void setIntb(int intb) {
		this.intb = intb;
	}

	public int getIntc() {
		return intc;
	}

	public void setIntc(int intc) {
		this.intc = intc;
	}

	public String getVarcharA() {
		return varcharA;
	}

	public void setVarcharA(String varcharA) {
		this.varcharA = varcharA;
	}

	public String getVarcharB() {
		return varcharB;
	}

	public void setVarcharB(String varcharB) {
		this.varcharB = varcharB;
	}

	public String getVarcharC() {
		return varcharC;
	}

	public void setVarcharC(String varcharC) {
		this.varcharC = varcharC;
	}

	@Override
	public String toString() {
		return "GetTech [techId=" + techId + ", techName=" + techName + ", techDesc=" + techDesc + ", mPhaseId="
				+ mPhaseId + ", isUsed=" + isUsed + ", techDate=" + techDate + ", phaseName=" + phaseName + ", inta="
				+ inta + ", intb=" + intb + ", intc=" + intc + ", varcharA=" + varcharA + ", varcharB=" + varcharB
				+ ", varcharC=" + varcharC + "]";
	}

}
