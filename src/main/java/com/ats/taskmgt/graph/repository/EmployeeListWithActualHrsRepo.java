package com.ats.taskmgt.graph.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.taskmgt.graph.model.EmployeeListWithActualHrs;

public interface EmployeeListWithActualHrsRepo extends JpaRepository<EmployeeListWithActualHrs, Integer> {

	@Query(value = "SELECT t.developer_id AS emp_id,e.emp_name   FROM t_task t,m_employee e WHERE t.dev_status=3  "
			+ "AND t.developer_id=e.emp_id GROUP BY t.developer_id", nativeQuery = true)
	List<EmployeeListWithActualHrs> getEmployeeListWithActualHrsList();

}
