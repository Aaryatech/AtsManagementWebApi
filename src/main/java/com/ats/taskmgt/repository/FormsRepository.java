package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.taskmgt.model.Forms;

public interface FormsRepository extends JpaRepository<Forms, Integer>{

	List<Forms> findByModuleId(int moduleId);

}
