package com.ats.taskmgt.repo.txapi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.taskmgt.model.txapi.GetTech;

public interface GetTechRepo extends JpaRepository<GetTech, Integer> {

	@Query(value = "SELECT t.*,p.phase_name  FROM t_technology t,m_phase_type p  WHERE t.is_used=1 AND t.m_phase_id=p.m_phase_id order by t.tech_id desc", nativeQuery = true)
	List<GetTech> getTechPhaseName();

}
