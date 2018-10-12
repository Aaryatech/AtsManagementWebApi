package com.ats.taskmgt.repo.proj;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.taskmgt.model.proj.ProjList;

public interface ProjListRepo extends JpaRepository<ProjList, Integer> {

	@Query(value = "SELECT t_projects.project_id, t_projects.project_name,t_projects.project_allocated_to,t_projects.project_exp_end_date,t_projects.project_end_date,"
			+ "t_projects.status,m_employee.emp_name,t_projects.project_start_date AS proj_start_date,"
			
			+ "COALESCE((SELECT SUM(t_cmplx_option.allocated_hrs) FROM t_cmplx_option,t_task WHERE t_task.project_id=t_projects.project_id AND t_cmplx_option.cmplx_opt_id=t_task.task_type_id),0) as proj_plan_hrs,"
			+

			"COALESCE((SELECT SUM(t_task.actual_req_hrs) FROM t_task WHERE t_task.project_id=t_projects.project_id),0) AS proj_actual_req_hrs,"
			+

			"COALESCE((SELECT SUM(t_task.task_planned_hrs) FROM t_task WHERE t_task.project_id=t_projects.project_id),0) AS proj_assign_hrs,"
			+

			"COALESCE((SELECT SUM(t_support_task.required_hrs) FROM t_support_task WHERE t_support_task.project_id=t_projects.project_id),0) AS proj_support_hrs,"
			+

			"t_projects.project_cost AS proj_cost " +

			" FROM m_employee,t_projects WHERE t_projects.project_allocated_to=m_employee.emp_id", nativeQuery = true)

	List<ProjList> getProjList();

}
