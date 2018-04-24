package com.ats.taskmgt.repository;
 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.taskmgt.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

	
	@Transactional
	@Modifying
	@Query("UPDATE Project SET isUsed=1  WHERE project_id=:projectId")
	int deleteProject(@Param("projectId")int projectId);

	Project findByProjectId(int projectId);
 

}
