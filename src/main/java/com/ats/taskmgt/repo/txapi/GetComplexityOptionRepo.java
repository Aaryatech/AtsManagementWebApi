package com.ats.taskmgt.repo.txapi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.taskmgt.model.txapi.GetComplexityOption;

public interface GetComplexityOptionRepo extends JpaRepository<GetComplexityOption, Integer> {

	@Query(value = "SELECT c.*,p.cmplx_name FROm t_cmplx_option c,t_complexity p  WHERE c.is_used=1 AND p.cmplx_id=c.cmplx_id order by c.cmplx_opt_id desc", nativeQuery = true)
	List<GetComplexityOption> getComplexityOption();

}
