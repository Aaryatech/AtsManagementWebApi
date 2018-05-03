package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.taskmgt.model.Module;

public interface ModuleRepository extends JpaRepository<Module, Integer>{

	List<Module> findByProjectId(int projectId);

}
