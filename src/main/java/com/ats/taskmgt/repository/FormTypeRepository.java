package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.taskmgt.model.FormType;

public interface FormTypeRepository extends JpaRepository<FormType, Integer>{

	List<FormType> findByIsUsed(int isUsed);
	List<FormType> findByIsUsedOrderByFormTypeIdDesc(int isUsed);

}
