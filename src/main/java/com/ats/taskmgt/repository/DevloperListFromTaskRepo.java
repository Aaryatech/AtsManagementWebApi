package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.DevloperListFromTask;

public interface DevloperListFromTaskRepo extends JpaRepository<DevloperListFromTask, Integer>{

	@Query(value = " SELECT \r\n" + 
			"        t.developer_id,\r\n" + 
			"        e.emp_name as developer_name\r\n" + 
			"        \r\n" + 
			"    FROM\r\n" + 
			"        t_task t,\r\n" + 
			"        m_employee e\r\n" + 
			"    WHERE\r\n" + 
			"         t.project_id = :projectId\r\n" + 
			"         and t.developer_id = e.emp_id\r\n" + 
			"    group by\r\n" + 
			"        t.developer_id", nativeQuery = true)
	List<DevloperListFromTask> devloperListFromTask(@Param("projectId")int projectId);

}
