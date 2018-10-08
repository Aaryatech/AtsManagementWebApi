package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.taskmgt.model.FormType;

public interface FormTypeRepository extends JpaRepository<FormType, Integer> {

	List<FormType> findByIsUsed(int isUsed);

	List<FormType> findByIsUsedOrderByFormTypeIdDesc(int isUsed);

	FormType findByFormTypeId(int formTypeId);

	@Transactional
	@Modifying
	@Query("UPDATE FormType SET is_used=0 WHERE formTypeId=:formTypeId ")
	int deleteFormType(@Param("formTypeId") int formTypeId);

}
