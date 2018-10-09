package com.ats.taskmgt.repo.leave;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.taskmgt.model.leave.ApplyLeave;

public interface ApplyLeaveRepo extends JpaRepository<ApplyLeave, Integer> {
	@Transactional
	@Modifying
	@Query("UPDATE ApplyLeave SET isUsed=1  WHERE leave_id=:leaveId")
	int deleteApplayLeave(@Param("leaveId")int leaveId);

	ApplyLeave findByLeaveIdAndIsUsed(int leaveId, int i);

	List<ApplyLeave> findByIsUsed(int i);
}
