package com.ats.taskmgt.repo.leave;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.leave.GetShortLeave;

public interface GetShortLeaveRepo extends JpaRepository<GetShortLeave, Integer> {

	@Query(value = "SELECT a.*,e.emp_name FROM short_leave a ,m_employee e WHERE a.send_to=e.emp_id AND a.is_used=1 AND a.emp_id=:empId ORDER BY a.short_leave_id DESC", nativeQuery = true)
	List<GetShortLeave> getShortLeaveByEmpId(@Param("empId") int empId);

	@Query(value = "SELECT a.*,e.emp_name FROM short_leave a ,m_employee e WHERE a.send_to=e.emp_id AND a.is_used=1 AND a.send_to=:empId ORDER BY a.short_leave_id DESC", nativeQuery = true)
	List<GetShortLeave> getShortLeaveBySendTo(@Param("empId") int empId);

	@Query(value = "SELECT a.*,e.emp_name FROM short_leave a ,m_employee e WHERE a.emp_id=e.emp_id AND a.is_used=1 AND a.short_leave_id=:shortLeaveId ORDER BY a.short_leave_id DESC", nativeQuery = true)
	GetShortLeave getShortLeaveByLeaveId(@Param("shortLeaveId") int shortLeaveId);

}
