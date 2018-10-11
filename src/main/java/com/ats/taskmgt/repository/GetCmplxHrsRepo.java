package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.txapi.GetCmplxHrs;

public interface GetCmplxHrsRepo extends JpaRepository<GetCmplxHrs, Integer> {

	@Query(value = "SELECT c.*,t.tech_name,f.form_type_name,p.phase_name, COALESCE((SELECT t_cmplx_option.allocated_hrs FROM t_cmplx_option WHERE c.cmplx_id=t_cmplx_option.cmplx_id) ,0 )AS allocated_hrs,COALESCE((SELECT t_cmplx_option.cmplx_opt_id FROM t_cmplx_option WHERE c.cmplx_id=t_cmplx_option.cmplx_id) ,0 )AS cmplx_opt_id ,COALESCE((SELECT\n"
			+ "t_cmplx_option.cmplx_opt_name FROM t_cmplx_option WHERE c.cmplx_id=t_cmplx_option.cmplx_id) ,0 )AS cmplx_opt_name FROM t_complexity c ,t_technology t,m_form_type f ,m_phase_type p ,t_cmplx_option o WHERE c.tech_id=t.tech_id AND c.form_type_id=f.form_type_id  AND c.m_phase_id=p.m_phase_id AND c.is_used=1  AND c.m_phase_id IN(:phaseId) AND c.tech_id IN(:techId) AND o.cmplx_opt_id IN(:cmplxOptId) AND o.cmplx_id=c.cmplx_id order by c.cmplx_id desc", nativeQuery = true)
	List<GetCmplxHrs> getComplexAllocatedHrsByList(@Param("techId") List<Integer> techId,
			@Param("phaseId") List<Integer> phaseId, @Param("cmplxOptId") List<Integer> cmplxOptId);

	@Query(value = "SELECT c.*,t.tech_name,f.form_type_name,p.phase_name, COALESCE((SELECT t_cmplx_option.allocated_hrs FROM t_cmplx_option WHERE c.cmplx_id=t_cmplx_option.cmplx_id) ,0 )AS allocated_hrs,COALESCE((SELECT t_cmplx_option.cmplx_opt_id FROM t_cmplx_option WHERE c.cmplx_id=t_cmplx_option.cmplx_id) ,0 )AS cmplx_opt_id ,COALESCE((SELECT\n"
			+ "t_cmplx_option.cmplx_opt_name FROM t_cmplx_option WHERE c.cmplx_id=t_cmplx_option.cmplx_id) ,0 )AS cmplx_opt_name FROM t_complexity c ,t_technology t,m_form_type f ,m_phase_type p ,t_cmplx_option o WHERE c.tech_id=t.tech_id AND c.form_type_id=f.form_type_id  AND c.m_phase_id=p.m_phase_id AND c.is_used=1   AND o.cmplx_opt_id IN(:cmplxOptId) AND o.cmplx_id=c.cmplx_id order by c.cmplx_id desc", nativeQuery = true)
	List<GetCmplxHrs> getComplexAllocatedHrs(@Param("cmplxOptId") List<Integer> cmplxOptId);

	@Query(value = "SELECT c.*,t.tech_name,f.form_type_name,p.phase_name, COALESCE((SELECT t_cmplx_option.allocated_hrs FROM t_cmplx_option WHERE c.cmplx_id=t_cmplx_option.cmplx_id) ,0 )AS allocated_hrs,COALESCE((SELECT t_cmplx_option.cmplx_opt_id FROM t_cmplx_option WHERE c.cmplx_id=t_cmplx_option.cmplx_id) ,0 )AS cmplx_opt_id ,COALESCE((SELECT\n"
			+ "t_cmplx_option.cmplx_opt_name FROM t_cmplx_option WHERE c.cmplx_id=t_cmplx_option.cmplx_id) ,0 )AS cmplx_opt_name FROM t_complexity c ,t_technology t,m_form_type f ,m_phase_type p ,t_cmplx_option o WHERE c.tech_id=t.tech_id AND c.form_type_id=f.form_type_id  AND c.m_phase_id=p.m_phase_id AND c.is_used=1  AND o.cmplx_id=c.cmplx_id order by c.cmplx_id desc", nativeQuery = true)
	List<GetCmplxHrs> getComplexAllocatedHrsList();

}
