package com.ats.taskmgt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetModuleProject {
	
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
	
	String projectName;
	
	

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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "GetModuleProject [moduleId=" + moduleId + ", projectId=" + projectId + ", moduleName=" + moduleName
				+ ", moduleDesc=" + moduleDesc + ", projectName=" + projectName + "]";
	}

	

}
