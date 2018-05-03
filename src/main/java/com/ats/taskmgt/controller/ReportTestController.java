package com.ats.taskmgt.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.taskmgt.model.DevelopmentHrsProwise;
import com.ats.taskmgt.model.EmpAllocatedWorkReport;
import com.ats.taskmgt.model.EmpConReport;
import com.ats.taskmgt.model.EmpPerformance;
import com.ats.taskmgt.model.ProjectPhaseTracking;
import com.ats.taskmgt.repository.DevelopmentHrsProwiseRepo;
import com.ats.taskmgt.repository.EmpAllocatedWorkRepo;
import com.ats.taskmgt.repository.EmpPerformanceRepository;
import com.ats.taskmgt.repository.EmployeeConsumptionRepository;
import com.ats.taskmgt.repository.ProjectPhaseTrackingRepository;

@RestController
public class ReportTestController {

	@Autowired
	EmployeeConsumptionRepository employeeConsumptionRepository;

	@Autowired
	EmpAllocatedWorkRepo empAllocatedWorkRepo;

	@Autowired
	EmpPerformanceRepository empPerformanceRepository;

	@Autowired
	DevelopmentHrsProwiseRepo developmentHrsProwiseRepo;

	@Autowired
	ProjectPhaseTrackingRepository projectPhaseTrackingRepository;

	// -------------------------------------------------------------------------
	// ----------------------- Employee Consumption Report---------

	@RequestMapping(value = "/getDatewiseEmpCon", method = RequestMethod.POST)
	public @ResponseBody EmpConReport getDatewiseEmpCon(@RequestParam("fromDate") Date fromDate,
			@RequestParam("toDate") Date toDate, @RequestParam("empId") int empId) {

		EmpConReport empConReport = new EmpConReport();
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

		EmpAllocatedWorkReport empAllocatedWorkReport = new EmpAllocatedWorkReport();

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

		EmpAllocatedWorkReport empAllocatedWorkReport = new EmpAllocatedWorkReport();

		try {
			empAllocatedWorkReport = empAllocatedWorkRepo.findAllocatedEmpWorkById(projectId, empId);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return empAllocatedWorkReport;

	}

	// -------------------------------------------------------------------------
	// ----------------------- Employee Performance--------

	@RequestMapping(value = "/getEmployeePerformance", method = RequestMethod.POST)
	public @ResponseBody EmpPerformance getEmployeePerformance(@RequestParam("projectId") int projectId,
			@RequestParam("empId") int empId) {
		EmpPerformance empPerformance = new EmpPerformance();
		try {

			empPerformance = empPerformanceRepository.findEmpPerformance(projectId, empId);
		} catch (Exception e) {
			System.err.println("Emp performance exce " + e.getMessage());
			e.printStackTrace();

		}

		System.err.println("output  " + empPerformance.toString());
		return empPerformance;

	}

	// -------------------------------------------------------------------------
	// --------------------Development Hrs Project wise--------

	@RequestMapping(value = "/getDevelopmentHrsByProwise", method = RequestMethod.POST)
	public @ResponseBody List<DevelopmentHrsProwise> getDevelopmentHrsByProwise(
			@RequestParam("projectId") int projectId) {
		List<DevelopmentHrsProwise> developmentHrsProwiseList = null;
		try {

			developmentHrsProwiseList = developmentHrsProwiseRepo.findDevHrs(projectId);
		} catch (Exception e) {
			System.err.println("Emp performance exce " + e.getMessage());
			e.printStackTrace();

		}

		System.err.println("output  " + developmentHrsProwiseList.toString());
		return developmentHrsProwiseList;

	}

	// -------------------------------------------------------------------------
	// -------------------- Project Phase Tracking--------

	@RequestMapping(value = "/getProjectPhaseTracking", method = RequestMethod.POST)
	public @ResponseBody ProjectPhaseTracking getProjectPhaseTracking(@RequestParam("projectId") int projectId,
			@RequestParam("phaseId") int phaseId) {
		ProjectPhaseTracking projectPhaseTracking = new ProjectPhaseTracking();
		try {

			projectPhaseTracking = projectPhaseTrackingRepository.findProPhase(projectId, phaseId);
		} catch (Exception e) {
			System.err.println("Emp performance exce " + e.getMessage());
			e.printStackTrace();

		}

		System.err.println("output  " + projectPhaseTracking.toString());
		return projectPhaseTracking;

	}

}