package com.ats.taskmgt.repository;
 

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.taskmgt.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

	 

}
