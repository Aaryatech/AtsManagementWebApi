package com.ats.taskmgt.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.EmpConReport;

public interface EmployeeConsumptionRepository extends JpaRepository<EmpConReport, Integer> {

	@Query(value = "SELECT t_projects.project_name,COALESCE(SUM(task_planned_hrs),0) as task_planned_hrs, "
			+ "COALESCE(SUM(actual_req_hrs),0) as actual_req_hrs, t_task.task_id FROM t_projects, t_task WHERE  t_task.end_date "
			+ "BETWEEN :fromDate AND :toDate AND t_task.developer_id=:empId\r\n" + "AND t_task.dev_status=3\r\n"
			+ "", nativeQuery = true)
	EmpConReport findDateWiseEmpConsumption(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate,
			@Param("empId") int empId);

}
