package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.GetFormList;
import com.ats.taskmgt.model.GetTask;

public interface GetTaskRepository extends JpaRepository<GetTask, Integer>{
	
	@Query(value="  select\r\n" + 
			"    t.task_id,\r\n" + 
			"    t.project_id,\r\n" + 
			"    p.project_name,\r\n" + 
			"    t.module_id,\r\n" + 
			"    m.module_name,\r\n" + 
			"    t.form_id,\r\n" + 
			"    f.form_name,\r\n" + 
			"    t.task_type_id,\r\n" + 
			"    tt.task_type_name,\r\n" + 
			"    t.task_name,\r\n" + 
			"    t.task_description,\r\n" + 
			"    t.task_sp_remarks,\r\n" + 
			"    t.task_planned_hrs,\r\n" + 
			"    t.developer_id,\r\n" + 
			"    t.tester_id,\r\n" + 
			"    t.assigned_by,\r\n" + 
			"    t.start_date,\r\n" + 
			"    t.start_datetime,\r\n" + 
			"    t.dev_compl_per,\r\n" + 
			"    t.end_date,\r\n" + 
			"    t.end_datetime,\r\n" + 
			"    t.dev_status,\r\n" + 
			"    t.actual_req_hrs,\r\n" + 
			"    t.tester_status,\r\n" + 
			"    t.remarks_by_dev\r\n" + 
			"    from\r\n" + 
			"    t_task t,\r\n" + 
			"    t_projects p,\r\n" + 
			"    t_forms f,\r\n" + 
			"    t_modules m,\r\n" + 
			"    m_task_type tt\r\n" + 
			"    where \r\n" + 
			"    t.task_type_id = tt.task_type_id\r\n" + 
			"    and p.project_id = t.project_id\r\n" + 
			"    and f.form_id = t.form_id\r\n" + 
			"    and m.module_id = t.module_id\r\n" + 
			"    and t.form_id = :formId" ,nativeQuery=true)
	List<GetTask> findByFormId(@Param("formId") int formId);

}
