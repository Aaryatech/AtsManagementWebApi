package com.ats.taskmgt.repo.txapi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.taskmgt.model.txapi.Technology;

public interface TechnologyRepo extends JpaRepository<Technology, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Technology SET isUsed=0  WHERE tech_id=:techId")
	int deleteTech(@Param("techId") int techId);

	Technology findByTechId(int techId);

	List<Technology> findByIsUsed(int i);

}
