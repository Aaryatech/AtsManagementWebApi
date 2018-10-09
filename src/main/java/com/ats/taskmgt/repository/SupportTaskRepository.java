package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.taskmgt.model.SupportTask;

public interface SupportTaskRepository extends JpaRepository<SupportTask, Integer>{

	List<SupportTask> findByProjectId(int projectId);

}
