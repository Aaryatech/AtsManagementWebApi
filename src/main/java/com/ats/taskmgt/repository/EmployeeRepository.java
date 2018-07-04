package com.ats.taskmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.taskmgt.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Transactional
	@Modifying
	@Query("UPDATE Employee SET isUsed=0  WHERE emp_id=:empId")
	int deleteEmp(@Param("empId")int empId);

	Employee findByEmpIdAndIsUsed(int empId, int delStatus);

	List<Employee> findByIsUsed(int delStatus);

	Employee findByEmpMobileAndEmpPwdAndIsUsed(String empMobile, String empPwd, int isUsed);

}
