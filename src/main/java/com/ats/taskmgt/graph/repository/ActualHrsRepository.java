package com.ats.taskmgt.graph.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.graph.model.ActualHrs;

public interface ActualHrsRepository extends JpaRepository<ActualHrs, Integer> {

	@Query(value = "SELECT t.task_id, SUM(t.actual_req_hrs) AS actual_req_hrs  FROM t_task t WHERE t.dev_status=3  "
			+ "GROUP BY t.project_id,t.developer_id", nativeQuery = true)
	List<ActualHrs> getActualHrsList();

	@Query(value = "SELECT t.task_id ,SUM(t.actual_req_hrs) AS  actual_req_hrs FROM t_task t WHERE t.developer_id=:developerId AND t.project_id=:projectId", nativeQuery = true)
	ActualHrs getActualHrsListById(@Param("developerId") int developerId, @Param("projectId") int projectId);

}
