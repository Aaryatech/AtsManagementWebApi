package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.GetPhaseTask;

public interface GetPhaseTaskRepository extends JpaRepository<GetPhaseTask, Integer>{

	@Query(value="select \r\n" + 
			"    p.*,\r\n" + 
			"    pr.project_name,\r\n" + 
			"    e.emp_name,\r\n" + 
			"    pt.phase_name\r\n" + 
			"    from \r\n" + 
			"    t_phase_task p,\r\n" + 
			"    m_employee e,\r\n" + 
			"    m_phase_type pt,\r\n" + 
			"    t_projects pr\r\n" + 
			"    where \r\n" + 
			"     p.project_id = pr.project_id and\r\n" + 
			"     e.emp_id = p.assigned_to and\r\n" + 
			"     p.task_phase_id = pt.m_phase_id\r\n" + 
			"     and p.project_id =:projectId" ,nativeQuery=true) 
	List<GetPhaseTask> getPhaseTaskListByProjectId(@Param("projectId") int projectId);

}
