package com.ats.taskmgt.repo.leave;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.taskmgt.model.leave.ShortLeave;

public interface ShortLeaveRepo extends JpaRepository<ShortLeave, Integer> {

}
