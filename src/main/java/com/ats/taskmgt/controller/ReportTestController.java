package com.ats.taskmgt.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.taskmgt.model.EmpAllocatedWorkReport;
import com.ats.taskmgt.model.EmpConReport;
import com.ats.taskmgt.repository.EmpAllocatedWorkRepo;
import com.ats.taskmgt.repository.EmployeeConsumptionRepository;

@RestController
@RequestMapping("/Test")
public class ReportTestController {

	@Autowired
	EmployeeConsumptionRepository employeeConsumptionRepository;

	@Autowired
	EmpAllocatedWorkRepo empAllocatedWorkRepo;

	EmpConReport empConReport = null;
	EmpAllocatedWorkReport empAllocatedWorkReport = null;

	// -------------------------------------------------------------------------
	// ----------------------- Employee Consumption Report---------

	@RequestMapping(value = "/getDatewiseEmpCon", method = RequestMethod.POST)
	public @ResponseBody EmpConReport getDatewiseEmpCon(@RequestParam("fromDate") Date fromDate,
			@RequestParam("toDate") Date toDate, @RequestParam("empId") int empId) {

		try {
			empConReport = employeeConsumptionRepository.findDateWiseEmpConsumption(fromDate, toDate, empId);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return empConReport;

	}

	// -------------------------------------------------------------------------
	// ----------------------- Employee Allocated Report---------

	@RequestMapping(value = "/getEmployeeAllocatedWork", method = RequestMethod.POST)
	public @ResponseBody EmpAllocatedWorkReport getEmployeeAllocatedWork(@RequestParam("fromDate") Date fromDate,
			@RequestParam("toDate") Date toDate, @RequestParam("empId") int empId) {

		try {
			empAllocatedWorkReport = empAllocatedWorkRepo.findAllocatedEmpWork(fromDate, toDate, empId);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return empAllocatedWorkReport;

	}

	// -------------------------------------------------------------------------
	// ----------------------- Employee Allocated Report BY ProjectId---------

	@RequestMapping(value = "/getEmployeeAllocatedWorkById", method = RequestMethod.POST)
	public @ResponseBody EmpAllocatedWorkReport getEmployeeAllocatedWorkById(@RequestParam("projectId") int projectId,
			@RequestParam("empId") int empId) {

		try {
			empAllocatedWorkReport = empAllocatedWorkRepo.findAllocatedEmpWorkById(projectId, empId);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return empAllocatedWorkReport;

	}

}
