package com.ats.taskmgt.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.EmpConReport;

public interface EmployeeConsumptionRepository extends JpaRepository<EmpConReport, Integer> {

	@Query(value = "SELECT\r\n" + 
			"        t_task.task_id,\r\n" + 
			"        t_projects.project_name,\r\n" + 
			"        COALESCE(SUM(task_planned_hrs),\r\n" + 
			"        0) as task_planned_hrs,\r\n" + 
			"        COALESCE(SUM(actual_req_hrs),\r\n" + 
			"        0) as actual_req_hrs \r\n" + 
			"    FROM\r\n" + 
			"        t_projects,\r\n" + 
			"        t_task \r\n" + 
			"    WHERE\r\n" + 
			"        t_task.end_date BETWEEN :fromDate AND :toDate \r\n" + 
			"        AND t_task.developer_id=:empId \r\n" + 
			"        AND t_task.dev_status=3\r\n" + 
			"        AND t_task.project_id = t_projects.project_id\r\n" + 
			"    group by\r\n" + 
			"        t_task.developer_id", nativeQuery = true)
	EmpConReport findDateWiseEmpConsumption(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("empId") int empId);

	@Query(value = "SELECT\r\n" + 
			"        t_task.task_id,\r\n" + 
			"        t_projects.project_name,\r\n" + 
			"        COALESCE(SUM(task_planned_hrs),\r\n" + 
			"        0) as task_planned_hrs,\r\n" + 
			"        COALESCE(SUM(actual_req_hrs),\r\n" + 
			"        0) as actual_req_hrs \r\n" + 
			"    FROM\r\n" + 
			"        t_projects,\r\n" + 
			"        t_task \r\n" + 
			"    WHERE\r\n" + 
			"        t_task.project_id = :empId \r\n" + 
			"        AND t_task.developer_id=:projectId \r\n" + 
			"        AND t_task.dev_status=3\r\n" + 
			"        AND t_task.project_id = t_projects.project_id\r\n" + 
			"    group by\r\n" + 
			"        t_task.developer_id", nativeQuery = true)
	EmpConReport findDateWiseEmpConsumption(@Param("projectId") int projectId, @Param("empId") int empId);

}
