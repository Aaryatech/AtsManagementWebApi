package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.PhaseType;

public interface PhaseTypeRepository extends JpaRepository<PhaseType, Integer>{
	
	@Query(value="select * from m_phase_type where is_used=:isUsed order by order_id " ,nativeQuery=true)
	List<PhaseType> getAllPhaseTypeList(@Param("isUsed") int isUsed);

}
