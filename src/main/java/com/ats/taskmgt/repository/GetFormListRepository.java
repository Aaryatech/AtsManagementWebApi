package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.GetFormList;

public interface GetFormListRepository extends JpaRepository<GetFormList, Integer>{

	
	@Query(value=" select \r\n" + 
			"    f.form_id,\r\n" + 
			"    f.form_name,\r\n" + 
			"    f.project_id,\r\n" + 
			"    p.project_name,\r\n" + 
			"    f.module_id,\r\n" + 
			"    m.module_name,\r\n" + 
			"    f.form_type_id,\r\n" + 
			"    ft.form_type_name\r\n" + 
			"    from\r\n" + 
			"    t_forms f,\r\n" + 
			"    t_modules m,\r\n" + 
			"    m_form_type ft,\r\n" + 
			"    t_projects p\r\n" + 
			"    where\r\n" + 
			"    f.module_id = m.module_id\r\n" + 
			"    and f.form_type_id = ft.form_type_id\r\n" + 
			"    and f.project_id = p.project_id\r\n" + 
			"    and f.project_id=:projectId" ,nativeQuery=true)
	List<GetFormList> getFormListByProjectId(@Param("projectId") int projectId);
	
	 

}
