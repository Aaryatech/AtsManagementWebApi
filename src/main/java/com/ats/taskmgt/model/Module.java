package com.ats.taskmgt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_modules")
public class Module {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="module_id")
	private int moduleId;
	
	@Column(name="project_id")
	private int projectId;
	 
	@Column(name="module_name")
	private String moduleName;
	
	@Column(name="module_desc")
	private String moduleDesc;
	
	@Column(name="tech_id")
	private int techId;
	
	@Column(name="phase_id")
	private int phaseId;
	
	@Column(name="del_status")
	private int delStatus;

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleDesc() {
		return moduleDesc;
	}

	public void setModuleDesc(String moduleDesc) {
		this.moduleDesc = moduleDesc;
	}

	public int getTechId() {
		return techId;
	}

	public void setTechId(int techId) {
		this.techId = techId;
	}

	public int getPhaseId() {
		return phaseId;
	}

	public void setPhaseId(int phaseId) {
		this.phaseId = phaseId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "Module [moduleId=" + moduleId + ", projectId=" + projectId + ", moduleName=" + moduleName
				+ ", moduleDesc=" + moduleDesc + ", techId=" + techId + ", phaseId=" + phaseId + ", delStatus="
				+ delStatus + "]";
	}
	
	

}
