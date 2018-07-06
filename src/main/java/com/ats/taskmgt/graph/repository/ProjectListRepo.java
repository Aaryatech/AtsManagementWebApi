package com.ats.taskmgt.graph.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.taskmgt.graph.model.ProjectList;

public interface ProjectListRepo extends JpaRepository<ProjectList, Integer> {

	@Query(value = "SELECT t.project_id,p.project_name FROM t_task t,t_projects p WHERE t.dev_status=3 AND "
			+ "t.project_id=p.project_id GROUP BY t.project_id", nativeQuery = true)
	List<ProjectList> getProjectList();

}
