package com.ats.taskmgt.repo.txapi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.txapi.GetComplexity;

public interface GetComplexityRepo extends JpaRepository<GetComplexity, Integer> {

	@Query(value = "SELECT c.*,t.tech_name,f.form_type_name,p.phase_name FROM t_complexity c ,t_technology t,m_form_type f ,m_phase_type p WHERE c.tech_id=t.tech_id AND c.form_type_id=f.form_type_id  AND c.m_phase_id=p.m_phase_id AND c.is_used=1 order by c.cmplx_id desc", nativeQuery = true)
	List<GetComplexity> getComplexityAllName();

	@Query(value = "SELECT c.*,t.tech_name,f.form_type_name,p.phase_name FROM t_complexity c ,t_technology t,m_form_type f ,m_phase_type p WHERE c.tech_id=t.tech_id AND c.form_type_id=f.form_type_id  AND c.m_phase_id=p.m_phase_id AND c.is_used=1 AND c.m_phase_id=:phaseId AND c.tech_id=:techId order by c.cmplx_id desc", nativeQuery = true)
	List<GetComplexity> getComplexityByIds(@Param("techId") int techId, @Param("phaseId") int phaseId);
	
	@Query(value = "SELECT c.*,t.tech_name,f.form_type_name,p.phase_name FROM t_complexity c ,t_technology t,m_form_type f ,m_phase_type p WHERE c.tech_id=t.tech_id AND c.form_type_id=f.form_type_id  AND c.m_phase_id=p.m_phase_id AND c.is_used=1 AND c.m_phase_id IN(:phaseId) AND c.tech_id IN(:techId) order by c.cmplx_id desc", nativeQuery = true)
	List<GetComplexity> getComplexityByIdsList(@Param("techId") List<Integer> techId, @Param("phaseId") List<Integer> phaseId);

}
//SELECT c.*,t.tech_name,f.form_type_name,p.phase_name, COALESCE((SELECT t_cmplx_option.allocated_hrs FROM t_cmplx_option WHERE c.cmplx_id=t_cmplx_option.cmplx_id) ,0 )AS allocated_hrs FROM t_complexity c ,t_technology t,m_form_type f ,m_phase_type p WHERE c.tech_id=t.tech_id AND c.form_type_id=f.form_type_id  AND c.m_phase_id=p.m_phase_id AND c.is_used=1 AND c.m_phase_id IN(1,2,3,4,5) AND c.tech_id IN(1,2,3,4,5)  order by c.cmplx_id desc