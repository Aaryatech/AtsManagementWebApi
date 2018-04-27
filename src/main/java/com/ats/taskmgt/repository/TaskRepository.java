package com.ats.taskmgt.repository;
 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.taskmgt.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

	List<Task> findByProjectIdAndTaskTypeId(int projectId, int taskTypeId);

	 

}
