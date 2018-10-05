package com.ats.taskmgt.repo.txapi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.taskmgt.model.txapi.Complexity;

public interface ComplexityRepo extends JpaRepository<Complexity, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Complexity SET isUsed=0  WHERE cmplx_id=:cmplxId")
	int deleteComplexity(@Param("cmplxId") int cmplxId);

	Complexity findByCmplxId(int cmplxId);

	List<Complexity> findByIsUsed(int i);

}
