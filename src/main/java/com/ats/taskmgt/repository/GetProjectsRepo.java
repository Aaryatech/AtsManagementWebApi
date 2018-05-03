package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.taskmgt.model.GetProjects;

public interface GetProjectsRepo extends JpaRepository<GetProjects, Integer>{
	
	@Query(value="SELECT t_projects.*,m_employee.emp_name FROM t_projects,m_employee WHERE "
			+ " t_projects. project_allocated_to = m_employee.emp_id " ,nativeQuery=true) 
	
	List<GetProjects> getAllProjects();

	@Query(value="SELECT\n" + 
			"        t_projects.*,\n" + 
			"        m_employee.emp_name \n" + 
			"    FROM\n" + 
			"        t_projects,\n" + 
			"        m_employee \n" + 
			"    WHERE\n" + 
			"        t_projects. project_allocated_to = m_employee.emp_id \n" + 
			"        and t_projects.status=0" ,nativeQuery=true) 
	List<GetProjects> ongoingProjectList();

}
