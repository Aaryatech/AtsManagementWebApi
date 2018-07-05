package com.ats.taskmgt.controller;

import java.sql.Date;
import java.util.ArrayList;
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
import com.ats.taskmgt.model.ProjectHours;
import com.ats.taskmgt.model.ProjectPhaseTracking;
import com.ats.taskmgt.model.RemainingTaskGraph;
import com.ats.taskmgt.model.SupportTaskReport;
import com.ats.taskmgt.repository.DevelopmentHrsProwiseRepo;
import com.ats.taskmgt.repository.EmpAllocatedWorkRepo;
import com.ats.taskmgt.repository.EmpPerformanceRepository;
import com.ats.taskmgt.repository.EmployeeConsumptionRepository;
import com.ats.taskmgt.repository.ProjectHoursRepo;
import com.ats.taskmgt.repository.ProjectPhaseTrackingRepository;
import com.ats.taskmgt.repository.RemainingTaskGraphRepo;
import com.ats.taskmgt.repository.SupportTaskReportrepo;

@RestController
public class ReportTestController {

	@Autowired
	EmployeeConsumptionRepository employeeConsumptionRepository;

	@Autowired
	SupportTaskReportrepo supportTaskReportrepo;

	@Autowired
	ProjectHoursRepo projectHoursRepo;

	@Autowired
	EmpAllocatedWorkRepo empAllocatedWorkRepo;

	@Autowired
	EmpPerformanceRepository empPerformanceRepository;

	@Autowired
	DevelopmentHrsProwiseRepo developmentHrsProwiseRepo;

	@Autowired
	ProjectPhaseTrackingRepository projectPhaseTrackingRepository;

	@Autowired
	RemainingTaskGraphRepo remainingTaskGraphRepo;

	// -------------------------------------------------------------------------
	// ----------------------- Employee Consumption Report---------

	@RequestMapping(value = "/getDatewiseEmpCon", method = RequestMethod.POST)
	public @ResponseBody EmpConReport getDatewiseEmpCon(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("empId") int empId,
			@RequestParam("projectId") int projectId) {

		EmpConReport empConReport = new EmpConReport();
		try {

			if (projectId == 0) {
				empConReport = employeeConsumptionRepository.findDateWiseEmpConsumption(fromDate, toDate, empId);
				empConReport.setProjectName("All Project");
			} else {

				System.err.println("inside else");
				empConReport = employeeConsumptionRepository.findDateWiseEmpConsumption(projectId, empId);
			}
			System.out.println(empConReport);

		} catch (Exception e) {
			System.err.println("ex occ " + e.getMessage());
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
			if (projectId == 0) {
				empAllocatedWorkReport = empAllocatedWorkRepo.findAllocatedEmpWorkById(empId);
				empAllocatedWorkReport.setProjectName("All Projects");
			} else {
				empAllocatedWorkReport = empAllocatedWorkRepo.findAllocatedEmpWorkById(projectId, empId);
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return empAllocatedWorkReport;

	}

	// -------------------------------------------------------------------------
	// ----------------------- Employee Performance--------

	@RequestMapping(value = "/getEmployeePerformance", method = RequestMethod.POST)
	public @ResponseBody List<EmpPerformance> getEmployeePerformance(@RequestParam("projectId") int projectId,
			@RequestParam("empId") int empId) {
		List<EmpPerformance> empPerformance = new ArrayList<EmpPerformance>();
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
		List<DevelopmentHrsProwise> developmentHrsProwiseList = new ArrayList<DevelopmentHrsProwise>();

		try {

			developmentHrsProwiseList = developmentHrsProwiseRepo.findDevHrs(projectId);
		} catch (Exception e) {
			System.err.println("Emp performance exce " + e.getMessage());
			e.printStackTrace();

		}

		System.err.println("output  " + developmentHrsProwiseList);

		return developmentHrsProwiseList;

	}

	// -------------------------------------------------------------------------
	// -------------------- Project Phase Tracking--------

	@RequestMapping(value = "/getProjectPhaseTracking", method = RequestMethod.POST)
	public @ResponseBody List<ProjectPhaseTracking> getProjectPhaseTracking(@RequestParam("projectId") int projectId,
			@RequestParam("phaseId") int phaseId) {
		List<ProjectPhaseTracking> projectPhaseTrackingList;

		try {

			if (phaseId != 0) {
				projectPhaseTrackingList = projectPhaseTrackingRepository.findProPhase(projectId, phaseId);
			}

			else {
				projectPhaseTrackingList = projectPhaseTrackingRepository.findAllProPhase(projectId);

			}
		} catch (Exception e) {
			projectPhaseTrackingList = new ArrayList<>();
			e.printStackTrace();

		}
		return projectPhaseTrackingList;
	}

	// ----------------------- Employee Remaining Hours Graph--------

	@RequestMapping(value = "/getEmpRemainingHours", method = RequestMethod.GET)
	public @ResponseBody List<RemainingTaskGraph> getEmpRemainingHours() {

		List<RemainingTaskGraph> remainingTaskGraphList = new ArrayList<>();
		try {

			remainingTaskGraphList = remainingTaskGraphRepo.getEmpRemainingHours();

		} catch (Exception e) {
			System.err.println("ex occ " + e.getMessage());
			e.printStackTrace();

		}
		return remainingTaskGraphList;

	}

	// ----------------------- Project Hours Graph--------

	@RequestMapping(value = "/getProjectHours", method = RequestMethod.GET)
	public @ResponseBody List<ProjectHours> getProjectHours() {

		List<ProjectHours> projectHoursGraphList = new ArrayList<>();
		try {

			projectHoursGraphList = projectHoursRepo.getProjectHours();

		} catch (Exception e) {
			System.err.println("ex occ " + e.getMessage());
			e.printStackTrace();

		}
		return projectHoursGraphList;

	}

	@RequestMapping(value = "/getSupportTaskReport", method = RequestMethod.POST)
	public @ResponseBody List<SupportTaskReport> getSupportTaskReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("empId") int empId,
			@RequestParam("projectId") int projectId) {

		List<SupportTaskReport> supportTaskReportList = new ArrayList<>();
		try {

			if (projectId == 0 && empId != 0) {
				supportTaskReportList = supportTaskReportrepo.getSupportTaskByEmpId(fromDate, toDate, empId);

			} else if (empId == 0 && projectId != 0) {
				supportTaskReportList = supportTaskReportrepo.getSupportTaskByProjectId(fromDate, toDate, projectId);

			} else if (empId != 0 && projectId != 0) {

				supportTaskReportList = supportTaskReportrepo.getSupportTaskByEmpIdAndProId(fromDate, toDate, empId,
						projectId);

			} else {
				supportTaskReportList = supportTaskReportrepo.getSupportTask(fromDate, toDate);

			}

			System.out.println(supportTaskReportList);

		} catch (Exception e) {
			System.err.println("ex occ " + e.getMessage());
			e.printStackTrace();

		}
		return supportTaskReportList;

	}

}
