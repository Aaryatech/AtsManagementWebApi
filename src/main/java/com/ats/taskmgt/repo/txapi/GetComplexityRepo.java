package com.ats.taskmgt.repo.txapi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.taskmgt.model.txapi.GetComplexity;

public interface GetComplexityRepo extends JpaRepository<GetComplexity, Integer> {

	@Query(value = "SELECT c.*,t.tech_name,f.form_type_name,p.phase_name FROM t_complexity c ,t_technology t,m_form_type f ,m_phase_type p WHERE c.tech_id=t.tech_id AND c.form_type_id=f.form_type_id  AND c.m_phase_id=p.m_phase_id AND c.is_used=1 order by c.cmplx_id desc", nativeQuery = true)
	List<GetComplexity> getComplexityAllName();

}
