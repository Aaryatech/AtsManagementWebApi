package com.ats.taskmgt.repository;
 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.taskmgt.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

	
	@Query(value=" select\r\n" + 
			"        t.task_id,\r\n" + 
			"        t.project_id, \r\n" + 
			"        t.module_id, \r\n" + 
			"        t.form_id, \r\n" + 
			"        t.task_type_id, \r\n" + 
			"        t.task_name,\r\n" + 
			"        t.task_description,\r\n" + 
			"        t.task_sp_remarks,\r\n" + 
			"        t.task_planned_hrs,\r\n" + 
			"        t.developer_id,\r\n" + 
			"        t.tester_id,\r\n" + 
			"        t.assigned_by,\r\n" + 
			"        t.start_date,\r\n" + 
			"        t.start_datetime,\r\n" + 
			"        t.dev_compl_per,\r\n" + 
			"        t.end_date,\r\n" + 
			"        t.end_datetime,\r\n" + 
			"        t.dev_status,\r\n" + 
			"        t.actual_req_hrs,\r\n" + 
			"        t.tester_status,\r\n" + 
			"        e.emp_name as  remarks_by_dev     \r\n" + 
			"    from\r\n" + 
			"        t_task t,\r\n" + 
			"        m_employee e\r\n" + 
			"    where\r\n" + 
			"        e.emp_id = t.developer_id and\r\n" + 
			"        t.project_id = :projectId\r\n" + 
			"        and t.task_type_id=:taskTypeId" ,nativeQuery=true)
	List<Task> findByProjectIdAndTaskTypeId(@Param("projectId") int projectId,@Param("taskTypeId") int taskTypeId);

	Task findByTaskId(int taskId);

	@Transactional
	@Modifying
	@Query(value="delete from Task where task_id = :taskId ")
	void deleteTask(@Param("taskId") int taskId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE   Task SET devStatus=:devStatus,actualReqHrs=:actualReqHrs,"
			+ "endDate=:endDate,endDatetime=:endDatetime WHERE taskId = :taskId ")
	int completeTask(@Param("devStatus") int devStatus,@Param("actualReqHrs") String actualReqHrs,@Param("taskId") int taskId,
			@Param("endDate") String endDate,@Param("endDatetime") String endDatetime);

	 

}
