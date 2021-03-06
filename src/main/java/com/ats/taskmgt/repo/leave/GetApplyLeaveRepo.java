package com.ats.taskmgt.repo.leave;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.leave.GetApplyLeave;

public interface GetApplyLeaveRepo extends JpaRepository<GetApplyLeave, Integer> {

	@Query(value = "SELECT a.*,e.emp_name FROM apply_leave a ,m_employee e WHERE a.send_to=e.emp_id AND a.is_used=1 AND a.emp_id=:empId ORDER BY a.leave_id DESC", nativeQuery = true)
	List<GetApplyLeave> getApplyLeaveByEmpId(@Param("empId") int empId);

	@Query(value = "SELECT a.*,e.emp_name FROM apply_leave a ,m_employee e WHERE a.emp_id=e.emp_id AND a.is_used=1 AND a.send_to=:empId ORDER BY a.leave_id DESC", nativeQuery = true)
	List<GetApplyLeave> getApplyLeaveBySendTo(@Param("empId") int empId);

	@Query(value = "SELECT a.*,e.emp_name FROM apply_leave a ,m_employee e WHERE a.emp_id=e.emp_id AND a.is_used=1 AND a.leave_id=:leaveId ORDER BY a.leave_id DESC", nativeQuery = true)
	GetApplyLeave getApplyLeaveByLeaveId(@Param("leaveId") int leaveId);

	@Query(value = "SELECT a.* ,e.emp_name FROM apply_leave a ,m_employee e  WHERE a.emp_id=e.emp_id AND a.date BETWEEN :fromDate AND :toDate AND a.is_used=1 ORDER BY a.leave_id DESC", nativeQuery = true)
	List<GetApplyLeave> getApplyLeaveReportBetweenDate(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = "SELECT a.*,e.emp_name FROM apply_leave a ,m_employee e  WHERE a.emp_id=e.emp_id AND a.date BETWEEN :fromDate AND :toDate AND a.emp_id IN(:empIdList) "
			+ "AND a.is_used=1 ORDER BY a.leave_id DESC", nativeQuery = true)
	List<GetApplyLeave> getApplyLeaveReportByEmpIdList(@Param("empIdList") List<Integer> empIdList,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
