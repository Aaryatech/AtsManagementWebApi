package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.DevelopmentHrsProwise;

public interface DevelopmentHrsProwiseRepo extends JpaRepository<DevelopmentHrsProwise, Integer> {

	@Query(value = "\r\n" + "SELECT t_task.task_id, SUM(COALESCE(t_task.task_planned_hrs,0)) as task_planned_hrs,"
			+ " SUM(COALESCE(t_task.actual_req_hrs,0)) as actual_req_hrs , m.module_name , "
			+ "COUNT(f.form_id) AS total_forms FROM t_task , t_modules m , t_forms f WHERE t_task.project_id=:projectId "
			+ "AND m.module_id=t_task.module_id AND f.form_id=t_task.form_id GROUP BY t_task.module_id", nativeQuery = true)
	List<DevelopmentHrsProwise> findDevHrs(@Param("projectId") int projectId);

}
