package com.ats.taskmgt.repo.proj;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.proj.ProjTaskDetail;

public interface ProjTaskDetailRepo extends JpaRepository<ProjTaskDetail, Integer> {

	@Query(value = " SELECT t_task.task_id,t_task.start_date,t_task.dev_status, t_task.task_name,"
			+ " t_forms.form_name,t_task.task_planned_hrs AS assign_hr,t_cmplx_option.allocated_hrs "
			+ " AS plan_hr, m_employee.emp_name, t_task.actual_req_hrs AS actual_hr,t_modules.module_name,"
			+ " t_technology.tech_name," + " COALESCE((SELECT t_task.actual_req_hrs*m_employee.emp_per_hr_rate "
			+ " FROM m_employee WHERE t_task.developer_id=m_employee.emp_id),0) AS emp_task_cost "
			+ " FROM t_task,t_cmplx_option,m_employee,t_forms,t_modules,t_technology "
			+ " WHERE t_task.project_id=:projId AND t_cmplx_option.cmplx_opt_id=t_task.task_type_id "
			+ " AND m_employee.emp_id=t_task.developer_id AND t_forms.form_id=t_task.form_id"
			+ " AND t_modules.module_id=t_task.module_id AND t_technology.tech_id=t_modules.tech_id", 
			nativeQuery = true)

	List<ProjTaskDetail> getProjTaskDetail(@Param("projId") int projId);//call for onload //if both tech id and empid are -1 then also call this in Ajax
	
	
	@Query(value = " SELECT t_task.task_id,t_task.start_date,t_task.dev_status, t_task.task_name,"
			+ " t_forms.form_name,t_task.task_planned_hrs AS assign_hr,t_cmplx_option.allocated_hrs "
			+ " AS plan_hr, m_employee.emp_name, t_task.actual_req_hrs AS actual_hr,t_modules.module_name,"
			+ " t_technology.tech_name," + " COALESCE((SELECT t_task.actual_req_hrs*m_employee.emp_per_hr_rate "
			+ " FROM m_employee WHERE t_task.developer_id=m_employee.emp_id AND m_employee.emp_id IN(:empIdList) ),0) "
			+ "AS emp_task_cost "
			+ " FROM t_task,t_cmplx_option,m_employee,t_forms,t_modules,t_technology "
			+ " WHERE t_task.project_id=:projId AND t_cmplx_option.cmplx_opt_id=t_task.task_type_id "
			+ " AND m_employee.emp_id=t_task.developer_id AND m_employee.emp_id IN(:empIdList) AND "
			+ "t_forms.form_id=t_task.form_id"
			+ " AND t_modules.module_id=t_task.module_id AND t_technology.tech_id=t_modules.tech_id "
			+ " AND  t_technology.tech_id IN (:techIdList) ", 
			nativeQuery = true)
//AND t_modules.phase_id IN (:phaseIdList)
	List<ProjTaskDetail> getProjTaskDetailSpec(@Param("projId") int projId,
			@Param("empIdList") int empIdList,@Param("techIdList") int techIdList/*
			,@Param("phaseIdList") List<Integer> phaseIdList*/);
	
	
	@Query(value = " SELECT t_task.task_id,t_task.start_date,t_task.dev_status, t_task.task_name,"
			+ " t_forms.form_name,t_task.task_planned_hrs AS assign_hr,t_cmplx_option.allocated_hrs "
			+ " AS plan_hr, m_employee.emp_name, t_task.actual_req_hrs AS actual_hr,t_modules.module_name,"
			+ " t_technology.tech_name," + " COALESCE((SELECT t_task.actual_req_hrs*m_employee.emp_per_hr_rate "
			+ " FROM m_employee WHERE t_task.developer_id=m_employee.emp_id ),0) "
			+ "AS emp_task_cost "
			+ " FROM t_task,t_cmplx_option,m_employee,t_forms,t_modules,t_technology "
			+ " WHERE t_task.project_id=:projId AND t_cmplx_option.cmplx_opt_id=t_task.task_type_id "
			+ " AND m_employee.emp_id=t_task.developer_id AND "
			+ "t_forms.form_id=t_task.form_id"
			+ " AND t_modules.module_id=t_task.module_id AND t_technology.tech_id=t_modules.tech_id "
			+ " AND  t_technology.tech_id IN (:techIdList) ", 
			nativeQuery = true)
//AND t_modules.phase_id IN (:phaseIdList)
	List<ProjTaskDetail> getProjTaskDetailAllEmpSpecTechId(@Param("projId") int projId,
			@Param("techIdList") int techIdList/*
			,@Param("phaseIdList") List<Integer> phaseIdList*/);
	
	
	@Query(value = " SELECT t_task.task_id,t_task.start_date,t_task.dev_status, t_task.task_name,"
			+ " t_forms.form_name,t_task.task_planned_hrs AS assign_hr,t_cmplx_option.allocated_hrs "
			+ " AS plan_hr, m_employee.emp_name, t_task.actual_req_hrs AS actual_hr,t_modules.module_name,"
			+ " t_technology.tech_name," + " COALESCE((SELECT t_task.actual_req_hrs*m_employee.emp_per_hr_rate "
			+ " FROM m_employee WHERE t_task.developer_id=m_employee.emp_id AND m_employee.emp_id IN(:empIdList) ),0) "
			+ "AS emp_task_cost "
			+ " FROM t_task,t_cmplx_option,m_employee,t_forms,t_modules,t_technology "
			+ " WHERE t_task.project_id=:projId AND t_cmplx_option.cmplx_opt_id=t_task.task_type_id "
			+ " AND m_employee.emp_id=t_task.developer_id AND m_employee.emp_id IN(:empIdList) AND "
			+ "t_forms.form_id=t_task.form_id"
			+ " AND t_modules.module_id=t_task.module_id AND t_technology.tech_id=t_modules.tech_id "
			+ " ", 
			nativeQuery = true)
//AND t_modules.phase_id IN (:phaseIdList)
	List<ProjTaskDetail> getProjTaskDetailAllTechSpecEmp(@Param("projId") int projId,
			@Param("empIdList") int empIdList/*
			,@Param("phaseIdList") List<Integer> phaseIdList*/);
	

}
