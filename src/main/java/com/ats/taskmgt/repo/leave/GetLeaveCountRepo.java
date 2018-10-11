package com.ats.taskmgt.repo.leave;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.taskmgt.model.leave.GetLeaveCount;

public interface GetLeaveCountRepo extends JpaRepository<GetLeaveCount, Integer> {

	@Query(value = "SELECT m_employee.emp_id,m_employee.emp_name ,coalesce((SELECT COUNT(apply_leave.leave_id) FROM apply_leave WHERE apply_leave.type=0 AND apply_leave.status=1 AND apply_leave.is_used=1 AND m_employee.emp_id=apply_leave.emp_id),0) AS leave_count FROM m_employee ", nativeQuery = true)
	List<GetLeaveCount> getCountForSickLeave();

	@Query(value = "SELECT m_employee.emp_id,m_employee.emp_name ,coalesce((SELECT COUNT(apply_leave.leave_id) FROM apply_leave WHERE apply_leave.type=1 AND apply_leave.status=1 AND apply_leave.is_used=1 AND m_employee.emp_id=apply_leave.emp_id),0) AS leave_count FROM m_employee ", nativeQuery = true)
	List<GetLeaveCount> getCountForCasualLeave();

}
