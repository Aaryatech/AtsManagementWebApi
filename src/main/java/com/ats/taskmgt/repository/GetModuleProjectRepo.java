package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.GetModuleProject;

public interface GetModuleProjectRepo extends JpaRepository<GetModuleProject, Integer>{
	
	@Query(value="SELECT t_modules.*,t_projects.project_name,t_technology.tech_name,m_phase_type.phase_name FROM t_projects,t_modules,t_technology,m_phase_type WHERE t_projects. project_id = t_modules.project_id and t_technology.tech_id=t_modules.tech_id"
			+ " and m_phase_type.m_phase_id= t_modules.phase_id and del_status=0" ,nativeQuery=true)  
	List<GetModuleProject> getModuleAndProject();

	
	@Query(value="SELECT t_modules.*,t_projects.project_name,t_technology.tech_name,m_phase_type.phase_name FROM t_projects,t_modules,t_technology,m_phase_type WHERE t_projects. project_id = t_modules.project_id and t_technology.tech_id=t_modules.tech_id and "
			+ "m_phase_type.m_phase_id= t_modules.phase_id and t_modules.module_id=:moduleId and del_status=0" ,nativeQuery=true) 
	GetModuleProject getModuleByModuleId(@Param("moduleId") int moduleId);
	

}
