package com.ats.taskmgt.repo.leave;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.leave.ShortLeave;

public interface ShortLeaveRepo extends JpaRepository<ShortLeave, Integer> {

	@Query(value = "SELECT * FROM short_leave WHERE MONTH(date) = MONTH(CURRENT_DATE()) AND YEAR(date) = YEAR(CURRENT_DATE()) AND emp_id =:empId", nativeQuery = true)
	List<ShortLeave> getShortLeaveByEmpId(@Param("empId") int empId);

}
