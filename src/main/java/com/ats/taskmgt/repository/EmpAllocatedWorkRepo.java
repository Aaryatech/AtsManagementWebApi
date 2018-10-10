package com.ats.taskmgt.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.EmpAllocatedWorkReport;

public interface EmpAllocatedWorkRepo extends JpaRepository<EmpAllocatedWorkReport, Integer> {

	@Query(value = "\r\n"
			+ "SELECT t_projects.project_name, t_task.task_id, COALESCE(SUM(task_planned_hrs),0) as task_planned_hrs,"
			+ " COALESCE(SUM(task_planned_hrs)/8,0) as no_of_days FROM t_projects, t_task WHERE  t_task.end_date"
			+ " BETWEEN :fromDate AND :toDate AND t_task.developer_id=:empId AND t_task.dev_status=1 "
			+ "GROUP BY t_task.project_id\r\n" + "", nativeQuery = true)
	EmpAllocatedWorkReport findAllocatedEmpWork(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate,
			@Param("empId") int empId);

	@Query(value = 
			"SELECT" + 
			"        coalesce(t_task.task_id,0) as task_id,t_projects.project_name,COALESCE(SUM(task_planned_hrs), 0) as task_planned_hrs, "
			+ "  COALESCE(SUM(task_planned_hrs)/8,  0) as no_of_days  FROM     t_projects,   t_task  WHERE   t_task.project_id=:projectId "
			+ "   AND t_task.developer_id=:empId     and t_task.project_id = t_projects.project_id    AND t_task.dev_status=1  "
			+ "", nativeQuery = true)
	EmpAllocatedWorkReport findAllocatedEmpWorkById(@Param("projectId") int projectId, @Param("empId") int empId);

	@Query(value= "SELECT coalesce(t_task.task_id,0) as task_id,t_projects.project_name,COALESCE(SUM(task_planned_hrs), 0) as task_planned_hrs,"
			+ "COALESCE(SUM(task_planned_hrs)/8,  0) as no_of_days  FROM     t_projects,   t_task  WHERE  t_task.developer_id=:empId     and t_task.project_id = t_projects.project_id    AND t_task.dev_status=1  "
			+ "", nativeQuery = true)
	EmpAllocatedWorkReport findAllocatedEmpWorkById(@Param("empId") int empId);

	
	@Query(value= "SELECT\r\n" + 
			"        coalesce(t_task.task_id,0) as task_id,\r\n" + 
			"        t_projects.project_name,\r\n" + 
			"        COALESCE(SUM(task_planned_hrs),\r\n" + 
			"        0) as task_planned_hrs,\r\n" + 
			"        COALESCE(SUM(task_planned_hrs)/8,\r\n" + 
			"        0) as no_of_days  \r\n" + 
			"    FROM\r\n" + 
			"        t_projects,\r\n" + 
			"        t_task  \r\n" + 
			"    WHERE\r\n" + 
			"        t_task.developer_id=:empId     \r\n" + 
			"        and t_task.project_id = t_projects.project_id    \r\n" + 
			"        AND t_task.dev_status=1\r\n" + 
			"        and start_date=:date", nativeQuery = true)
	EmpAllocatedWorkReport getEmpAllocatedWorkHoursByDate(@Param("date")String date,@Param("empId") int empId);

}
