package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.taskmgt.model.ProjectHours;

public interface ProjectHoursRepo extends JpaRepository<ProjectHours, Integer> {

	@Query(value = "SELECT t_task.project_id,t_projects.project_name,  COALESCE(SUM(task_planned_hrs),0) as task_planned_hrs,"
			+ " COALESCE(SUM(actual_req_hrs),0) as actual_req_hrs FROM t_projects, t_task,m_employee WHERE"
			+ " t_task.project_id = t_projects.project_id and t_task.developer_id=m_employee.emp_id AND t_task.dev_status=3"
			+ " group by  t_task.project_id", nativeQuery = true)
	List<ProjectHours> getProjectHours();

}
