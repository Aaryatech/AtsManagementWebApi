package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.taskmgt.model.GetModuleProject;

public interface GetModuleProjectRepo extends JpaRepository<GetModuleProject, Integer>{
	
	@Query(value="SELECT t_modules.*,t_projects.project_name FROM t_projects,t_modules WHERE "
			+ " t_projects. project_id = t_modules.project_id " ,nativeQuery=true) 
	
	List<GetModuleProject> getModuleAndProject();
	

}
