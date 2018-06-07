package com.ats.taskmgt.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.EmpConReport;

public interface EmployeeConsumptionRepository extends JpaRepository<EmpConReport, Integer> {

	@Query(value = "SELECT" + 
			"        t_task.task_id, t_projects.project_name, COALESCE(SUM(task_planned_hrs)," + 
			"        0) as task_planned_hrs," + 
			"        COALESCE(SUM(actual_req_hrs)," + 
			"        0) as actual_req_hrs" + 
			"    FROM" + 
			"        t_projects," + 
			"        t_task" + 
			"    WHERE\r\n" + 
			"        t_task.end_date BETWEEN :fromDate AND :toDate" + 
			"        AND t_task.developer_id=:empId " + 
			"        AND t_task.dev_status=3" + 
			"        AND t_task.project_id = t_projects.project_id" + 
			"    group by" + 
			"        t_task.developer_id", nativeQuery = true)
	EmpConReport findDateWiseEmpConsumption(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("empId") int empId);

	@Query(value = " SELECT " + 
			"        t_task.task_id," + 
			"        t_projects.project_name," + 
			"        COALESCE(SUM(task_planned_hrs)," + 
			"        0) as task_planned_hrs," + 
			"        COALESCE(SUM(actual_req_hrs)," + 
			"        0) as actual_req_hrs " + 
			"    FROM " + 
			"        t_projects," + 
			"        t_task " + 
			"    WHERE " + 
			"        t_task.project_id =:projectId " + 
			"        AND t_task.developer_id=:empId" + 
			"        AND t_task.dev_status=3 " + 
			"        AND t_task.project_id = t_projects.project_id " + 
			"    group by " + 
			"        t_task.developer_id ", nativeQuery = true)
	EmpConReport findDateWiseEmpConsumption(@Param("projectId") int projectId, @Param("empId") int empId);

}
