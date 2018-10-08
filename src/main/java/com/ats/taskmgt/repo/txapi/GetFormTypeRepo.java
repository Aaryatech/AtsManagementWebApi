package com.ats.taskmgt.repo.txapi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.taskmgt.model.txapi.GetFormType;

public interface GetFormTypeRepo extends JpaRepository<GetFormType, Integer> {

	@Query(value = "SELECT f.*, t.tech_name,p.phase_name  FROM t_technology t,m_phase_type p ,m_form_type f WHERE f.is_used=1 AND t.m_phase_id=p.m_phase_id AND f.tech_id=t.tech_id order by f.form_type_id desc", nativeQuery = true)
	List<GetFormType> getFormTechPhaseName();

}
