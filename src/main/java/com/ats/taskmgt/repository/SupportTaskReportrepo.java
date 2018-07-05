package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.SupportTaskReport;

public interface SupportTaskReportrepo extends JpaRepository<SupportTaskReport, Integer> {

	@Query(value = "SELECT  st.supp_id,st.project_id,st.emp_id,sum(st.required_hrs) AS required_hrs,e.emp_name,p.project_name"
			+ " FROM t_support_task st,m_employee e,t_projects p WHERE  e.emp_id=st.emp_id AND p.project_id=st.project_id "
			+ "AND st.work_date BETWEEN :fromDate AND :toDate GROUP BY st.emp_id,st.project_id ", nativeQuery = true)
	List<SupportTaskReport> getSupportTask(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT  st.supp_id,st.project_id,st.emp_id,sum(st.required_hrs) AS required_hrs,e.emp_name,p.project_name FROM"
			+ " t_support_task st,m_employee e,t_projects p WHERE  st.emp_id=:empId AND e.emp_id=st.emp_id AND p.project_id=st.project_id AND st.work_date BETWEEN :fromDate AND :toDate"
			+ " GROUP BY st.project_id", nativeQuery = true)
	List<SupportTaskReport> getSupportTaskByEmpId(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("empId") int empId);

	@Query(value = "SELECT  st.supp_id,st.project_id,st.emp_id,sum(st.required_hrs) AS required_hrs,e.emp_name,p.project_name FROM"
			+ " t_support_task st,m_employee e,t_projects p WHERE  st.project_id=:projectId AND e.emp_id=st.emp_id AND p.project_id=st.project_id AND st.work_date BETWEEN :fromDate AND :toDate"
			+ " GROUP BY st.emp_id", nativeQuery = true)
	List<SupportTaskReport> getSupportTaskByProjectId(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("projectId") int projectId);

	@Query(value = "SELECT  st.supp_id,st.project_id,st.emp_id,sum(st.required_hrs) AS required_hrs,e.emp_name,p.project_name "
			+ "FROM t_support_task st,m_employee e,t_projects p WHERE st.emp_id=:empId AND st.project_id=:projectId AND e.emp_id=st.emp_id "
			+ " AND p.project_id=st.project_id AND st.work_date BETWEEN :fromDate AND :toDate GROUP BY st.emp_id,st.project_id", nativeQuery = true)
	List<SupportTaskReport> getSupportTaskByEmpIdAndProId(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("empId") int empId, @Param("projectId") int projectId);
}
