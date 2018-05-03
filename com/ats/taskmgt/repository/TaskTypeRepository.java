package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.taskmgt.model.TaskType;

public interface TaskTypeRepository extends JpaRepository<TaskType, Integer>{

	List<TaskType> findByIsUsed(int isUsed);

}
