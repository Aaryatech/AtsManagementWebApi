package com.ats.taskmgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.ProjectPhaseTracking;

public interface ProjectPhaseTrackingRepository extends JpaRepository<ProjectPhaseTracking, Integer> {

	@Query(value = "\r\n" + "SELECT t_phase_task.t_task_phase_id, t_phase_task.task_desc, t_phase_task.exp_start_date, "
			+ "t_phase_task.actual_start_date, t_phase_task.exp_end_date, t_phase_task.atcual_end_date,t_phase_task.exp_hrs, "
			+ "t_phase_task.actual_hrs, m_employee.emp_name FROM t_phase_task , m_employee WHERE t_phase_task.project_id =:projectId AND"
			+ " t_phase_task.task_phase_id=:phaseId AND m_employee.emp_id=t_phase_task.assigned_to"
			+ "", nativeQuery = true)
	ProjectPhaseTracking findProPhase(@Param("projectId") int projectId, @Param("phaseId") int phaseId);

}
