package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.taskmgt.model.Module;

public interface ModuleRepository extends JpaRepository<Module, Integer>{

	List<Module> findByProjectId(int projectId);

	
	@Transactional
	@Modifying
	@Query("UPDATE Module SET delStatus=1 WHERE moduleId=:moduleId ") 
	int delete(@Param("moduleId") int moduleId);

}
