package com.ats.taskmgt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DevloperListFromTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="developer_id")
	private int developerId;
	
	@Column(name="developer_name")
	private String developerName;

	public int getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	@Override
	public String toString() {
		return "DevloperListFromTask [developerId=" + developerId + ", developerName=" + developerName + "]";
	}
	
	

}
