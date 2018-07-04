package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.GetSupportTask;

public interface GetSupportTaskRepository extends JpaRepository<GetSupportTask, Integer>{

	@Query(value=("select st.*,e.emp_name,p.project_name from t_support_task st,m_employee e,t_projects p "
			+ "where st.supp_id=:suppId and e.emp_id=st.emp_id and p.project_id=st.project_id"), nativeQuery=true)
	GetSupportTask getSupportTaskBySuppId(@Param("suppId") int suppId);

	@Query(value=("select st.*,e.emp_name,p.project_name from t_support_task st,m_employee e,t_projects p "
			+ "where st.emp_id=:empId and e.emp_id=st.emp_id and p.project_id=st.project_id"), nativeQuery=true)
	List<GetSupportTask> getSupportTaskByEmpiId(@Param("empId") int empId);

}
