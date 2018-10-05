package com.ats.taskmgt.repo.txapi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.taskmgt.model.txapi.CmplxOption;

public interface CmplxOptionRepo extends JpaRepository<CmplxOption, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE CmplxOption SET isUsed=0  WHERE cmplx_opt_id=:cmplxOptId")
	int deleteComplexOption(@Param("cmplxOptId") int cmplxOptId);

	CmplxOption findByCmplxOptId(int cmplxOptId);

	List<CmplxOption> findByIsUsed(int i);

}
