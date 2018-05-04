package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.taskmgt.model.EmpPerformance;

@Repository
public interface EmpPerformanceRepository extends JpaRepository<EmpPerformance, Integer> {

	@Query(value = "select t.task_name,  t.task_id,t.module_id,  m.module_name, t.task_planned_hrs,  "
			+ " coalesce(t.actual_req_hrs,0) as actual_req_hrs , t.remarks_by_dev  from t_task t,  t_modules m"
			+ "  where  t.developer_id =:empId and t.project_id =:projectId AND m.module_id=t.module_id   "
			, nativeQuery = true)
	List<EmpPerformance> findEmpPerformance(@Param("projectId") int projectId,@Param("empId") int empId );
}
