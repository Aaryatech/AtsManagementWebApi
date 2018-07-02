package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.taskmgt.model.RemainingTaskGraph;

public interface RemainingTaskGraphRepo extends JpaRepository<RemainingTaskGraph, Integer> {

	@Query(value = "SELECT t_task.developer_id,  m_employee.emp_name, COALESCE(SUM(task_planned_hrs), 0) as task_planned_hrs,"
			+ " COALESCE(SUM(task_planned_hrs)/8,\r\n" + "        0) as no_of_days FROM t_projects,"
			+ "  t_task, m_employee  WHERE t_task.project_id = t_projects.project_id  and t_task.developer_id=m_employee.emp_id  AND t_task.dev_status=1 "
			+ " group by t_task.developer_id", nativeQuery = true)
	List<RemainingTaskGraph> getEmpRemainingHours();

}
