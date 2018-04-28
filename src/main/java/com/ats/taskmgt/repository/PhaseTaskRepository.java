package com.ats.taskmgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.taskmgt.model.PhaseTask;

public interface PhaseTaskRepository extends JpaRepository<PhaseTask, Integer>{

	PhaseTask findBytTaskPhaseId(int tTaskPhaseId);

}
