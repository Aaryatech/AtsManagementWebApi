package com.ats.taskmgt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_forms")
public class Forms {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="form_id")
	private int formId;
	
	@Column(name="project_id")
	private int projectId;
	
	@Column(name="module_id")
	private int moduleId;
	
	@Column(name="form_type_id")
	private int formTypeId;
	
	@Column(name="form_name")
	private String formName;
	
	@Column(name="form_description")
	private String formDescription;

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public int getFormTypeId() {
		return formTypeId;
	}

	public void setFormTypeId(int formTypeId) {
		this.formTypeId = formTypeId;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getFormDescription() {
		return formDescription;
	}

	public void setFormDescription(String formDescription) {
		this.formDescription = formDescription;
	}

	@Override
	public String toString() {
		return "Forms [formId=" + formId + ", projectId=" + projectId + ", moduleId=" + moduleId + ", formTypeId="
				+ formTypeId + ", formName=" + formName + ", formDescription=" + formDescription + "]";
	}
	
	

}
