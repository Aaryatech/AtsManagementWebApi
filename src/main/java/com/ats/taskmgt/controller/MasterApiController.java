package com.ats.taskmgt.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.taskmgt.common.DateConvertor;
import com.ats.taskmgt.model.DevloperListFromTask;
import com.ats.taskmgt.model.Employee;
import com.ats.taskmgt.model.FormType;
import com.ats.taskmgt.model.Forms;
import com.ats.taskmgt.model.GetFormList;
import com.ats.taskmgt.model.GetModuleProject;
import com.ats.taskmgt.model.GetPhaseTask;
import com.ats.taskmgt.model.GetProjects;
import com.ats.taskmgt.model.GetSupportTask;
import com.ats.taskmgt.model.GetTask;
import com.ats.taskmgt.model.GetTaskList;
import com.ats.taskmgt.model.Info;
import com.ats.taskmgt.model.LoginResponse;
import com.ats.taskmgt.model.Module;
import com.ats.taskmgt.model.PhaseTask;
import com.ats.taskmgt.model.PhaseType;
import com.ats.taskmgt.model.Project;
import com.ats.taskmgt.model.SupportTask;
import com.ats.taskmgt.model.Task;
import com.ats.taskmgt.model.TaskType;
import com.ats.taskmgt.repository.DevloperListFromTaskRepo;
import com.ats.taskmgt.repository.EmployeeRepository;
import com.ats.taskmgt.repository.FormTypeRepository;
import com.ats.taskmgt.repository.FormsRepository;
import com.ats.taskmgt.repository.GetFormListRepository;
import com.ats.taskmgt.repository.GetModuleProjectRepo;
import com.ats.taskmgt.repository.GetPhaseTaskRepository;
import com.ats.taskmgt.repository.GetProjectsRepo;
import com.ats.taskmgt.repository.GetSupportTaskRepository;
import com.ats.taskmgt.repository.GetTaskListRepository;
import com.ats.taskmgt.repository.GetTaskRepository;
import com.ats.taskmgt.repository.ModuleRepository;
import com.ats.taskmgt.repository.PhaseTaskRepository;
import com.ats.taskmgt.repository.PhaseTypeRepository;
import com.ats.taskmgt.repository.ProjectRepository;
import com.ats.taskmgt.repository.SupportTaskRepository;
import com.ats.taskmgt.repository.TaskRepository;
import com.ats.taskmgt.repository.TaskTypeRepository;

@RestController
@RequestMapping("/masters")
public class MasterApiController {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	FormTypeRepository formTypeRepository;

	@Autowired
	TaskTypeRepository taskTypeRepository;

	@Autowired
	FormsRepository formsRepository;

	@Autowired
	ModuleRepository moduleRepository;

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	GetProjectsRepo getProjectsRepo;

	@Autowired
	GetModuleProjectRepo getModuleProjectRepo;

	@Autowired
	GetFormListRepository getFormListRepository;

	@Autowired
	GetTaskRepository getTaskRepository;

	@Autowired
	PhaseTypeRepository phaseTypeRepository;

	@Autowired
	PhaseTaskRepository phaseTaskRepository;

	@Autowired
	GetPhaseTaskRepository getPhaseTaskRepository;

	@Autowired
	GetTaskListRepository getTaskListRepository;

	@Autowired
	DevloperListFromTaskRepo devloperListFromTaskRepo;

	@Autowired
	SupportTaskRepository supportTaskRepository;

	@Autowired
	GetSupportTaskRepository getSupportTaskRepository;

	// ----------------------------------------Employee----------------------------------------------------

	@RequestMapping(value = { "/saveEmployee" }, method = RequestMethod.POST)
	public @ResponseBody Employee saveEmployee(@RequestBody Employee employee) {

		Employee emp = new Employee();

		try {

			employee.setEmpBirthdate(DateConvertor.convertToYMD(employee.getEmpBirthdate()));
			employee.setEmpJoiningDate(DateConvertor.convertToYMD(employee.getEmpJoiningDate()));
			emp = employeeRepository.saveAndFlush(employee);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return emp;

	}

	@RequestMapping(value = { "/deleteEmployee" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteEmployee(@RequestParam("empId") int empId) {

		Info info = new Info();

		try {
			int delete = employeeRepository.deleteEmp(empId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

	@RequestMapping(value = { "/employeeByEmpId" }, method = RequestMethod.POST)
	public @ResponseBody Employee employeeByEmpId(@RequestParam("empId") int empId) {

		Employee employee = new Employee();

		try {
			employee = employeeRepository.findByEmpIdAndIsUsed(empId, 1);
			employee.setEmpBirthdate(DateConvertor.convertToDMY(employee.getEmpBirthdate()));
			employee.setEmpJoiningDate(DateConvertor.convertToDMY(employee.getEmpJoiningDate()));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return employee;

	}

	@RequestMapping(value = { "/getAllEmpList" }, method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmpList() {

		List<Employee> employeeList = new ArrayList<Employee>();

		try {

			employeeList = employeeRepository.findByIsUsed(1);
			for (int i = 0; i < employeeList.size(); i++) {
				employeeList.get(i).setEmpBirthdate(DateConvertor.convertToDMY(employeeList.get(i).getEmpBirthdate()));
				employeeList.get(i)
						.setEmpJoiningDate(DateConvertor.convertToDMY(employeeList.get(i).getEmpJoiningDate()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return employeeList;

	}

	// --------------------------------------------------Project-----------------------------------------------------

	@RequestMapping(value = { "/saveProject" }, method = RequestMethod.POST)
	public @ResponseBody Project saveProject(@RequestBody Project project) {

		Project proj = new Project();

		try {
			proj = projectRepository.saveAndFlush(project);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return proj;

	}

	@RequestMapping(value = { "/deleteProject" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteProject(@RequestParam("projectId") int projectId) {

		Info info = new Info();

		try {
			int delete = projectRepository.deleteProject(projectId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

	@RequestMapping(value = { "/projectByProjectId" }, method = RequestMethod.POST)
	public @ResponseBody Project projectByProjectId(@RequestParam("projectId") int projectId) {

		Project project = new Project();

		try {
			project = projectRepository.findByProjectId(projectId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return project;

	}

	@RequestMapping(value = { "/getAllProjectList" }, method = RequestMethod.GET)
	public @ResponseBody List<Project> getAllProjectList() {

		List<Project> projectList = new ArrayList<Project>();

		try {

			projectList = projectRepository.findAll();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return projectList;

	}

	@RequestMapping(value = { "/getProjectList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetProjects> getProjectList() {

		List<GetProjects> projectList = new ArrayList<GetProjects>();

		try {

			projectList = getProjectsRepo.getAllProjects();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return projectList;

	}

	// -------------------------------formType--------------------------

	@RequestMapping(value = { "/getAllFormType" }, method = RequestMethod.GET)
	public @ResponseBody List<FormType> getAllFormType() {

		List<FormType> formTypeList = new ArrayList<FormType>();

		try {

			formTypeList = formTypeRepository.findByIsUsedOrderByFormTypeIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return formTypeList;

	}

	// ----------------------------taskType---------------------------

	@RequestMapping(value = { "/getAllTaskTypeList" }, method = RequestMethod.GET)
	public @ResponseBody List<TaskType> getAllTaskTypeList() {

		List<TaskType> taskTypeList = new ArrayList<TaskType>();

		try {

			taskTypeList = taskTypeRepository.findByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return taskTypeList;

	}

	// ---------------------------------------form------------------------------------------

	@RequestMapping(value = { "/saveForm" }, method = RequestMethod.POST)
	public @ResponseBody Forms saveForm(@RequestBody Forms forms) {

		Forms form = new Forms();

		try {
			form = formsRepository.saveAndFlush(forms);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return form;

	}

	@RequestMapping(value = { "/formsByModuleId" }, method = RequestMethod.POST)
	public @ResponseBody List<Forms> formsByModuleId(@RequestParam("moduleId") int moduleId) {

		List<Forms> formList = new ArrayList<Forms>();

		try {
			formList = formsRepository.findByModuleId(moduleId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return formList;

	}

	// ----------------------------------------Module---------------------------------------------------

	@RequestMapping(value = { "/saveModule" }, method = RequestMethod.POST)
	public @ResponseBody Module saveModule(@RequestBody Module module) {

		Module mod = new Module();

		try {
			mod = moduleRepository.saveAndFlush(module);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return mod;

	}

	@RequestMapping(value = { "/moduleByProjectId" }, method = RequestMethod.POST)
	public @ResponseBody List<Module> moduleByProjectId(@RequestParam("projectId") int projectId) {

		List<Module> moduleList = new ArrayList<Module>();

		try {
			moduleList = moduleRepository.findByProjectId(projectId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return moduleList;

	}

	// -----------------------------------task------------------------

	@RequestMapping(value = { "/saveTask" }, method = RequestMethod.POST)
	public @ResponseBody List<Task> saveTask(@RequestBody List<Task> postTaskList) {
		List<Task> responseTaskList = new ArrayList<Task>();
		try {

			responseTaskList = taskRepository.saveAll(postTaskList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return responseTaskList;

	}

	@RequestMapping(value = { "/getTaskById" }, method = RequestMethod.POST)
	public @ResponseBody Task getTaskById(@RequestParam("taskId") int taskId) {

		Task task = new Task();

		try {

			task = taskRepository.findByTaskId(taskId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return task;

	}

	@RequestMapping(value = { "/getSpecialTaskList" }, method = RequestMethod.POST)
	public @ResponseBody List<Task> getSpecialTaskList(@RequestParam("projectId") int projectId) {
		List<Task> responseTaskList = new ArrayList<Task>();
		try {

			responseTaskList = taskRepository.findByProjectIdAndTaskTypeId(projectId, 10);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return responseTaskList;

	}

	@RequestMapping(value = { "/taskByFormId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetTask> taskByFormId(@RequestParam("formId") int formId) {

		List<GetTask> taskList = new ArrayList<GetTask>();

		try {
			taskList = getTaskRepository.findByFormId(formId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return taskList;

	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public @ResponseBody LoginResponse findByEmpNameAndEmpPwd(@RequestParam("empMobile") String empMobile,
			@RequestParam("empPwd") String empPwd) {

		Employee employee = employeeRepository.findByEmpMobileAndEmpPwdAndIsUsed(empMobile, empPwd, 1);

		LoginResponse loginResponse = new LoginResponse();

		if (employee == null) {
			employee = new Employee();
			loginResponse.setEmployee(employee);

			loginResponse.setError(true);
			loginResponse.setMsg("Invalid");

		} else {

			loginResponse.setEmployee(employee);
			loginResponse.setError(false);
			loginResponse.setMsg("login Successfully");

		}

		return loginResponse;
	}

	@RequestMapping(value = { "/getModuleProject" }, method = RequestMethod.GET)
	public @ResponseBody List<GetModuleProject> getModuleProject() {

		List<GetModuleProject> ModuleProjectList = new ArrayList<GetModuleProject>();

		try {

			ModuleProjectList = getModuleProjectRepo.getModuleAndProject();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return ModuleProjectList;

	}

	@RequestMapping(value = { "/getFormListByProjectId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFormList> getFormListByProjectId(@RequestParam("projectId") int projectId) {

		List<GetFormList> getFormList = getFormListRepository.getFormListByProjectId(projectId);

		return getFormList;
	}

	@RequestMapping(value = { "/allTaskByDeveloperId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetTask> taskByEmpId(@RequestParam("developerId") int developerId) {

		List<GetTask> taskList = new ArrayList<GetTask>();

		try {
			taskList = getTaskRepository.findByDeveloperId(developerId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return taskList;

	}

	@RequestMapping(value = { "/getAllPhaseTypeList" }, method = RequestMethod.GET)
	public @ResponseBody List<PhaseType> getAllPhaseTypeList() {

		List<PhaseType> phaseTypeList = new ArrayList<PhaseType>();

		try {

			phaseTypeList = phaseTypeRepository.getAllPhaseTypeList(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return phaseTypeList;

	}

	@RequestMapping(value = { "/savePhaseTask" }, method = RequestMethod.POST)
	public @ResponseBody PhaseTask savePhaseTask(@RequestBody PhaseTask phaseTask) {

		PhaseTask task = new PhaseTask();

		try {

			task = phaseTaskRepository.save(phaseTask);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return task;

	}

	@RequestMapping(value = { "/phaseTaskById" }, method = RequestMethod.POST)
	public @ResponseBody PhaseTask phaseTaskById(@RequestParam("tTaskPhaseId") int tTaskPhaseId) {

		PhaseTask task = new PhaseTask();

		try {

			task = phaseTaskRepository.findBytTaskPhaseId(tTaskPhaseId);
			if (task.getActualStartDate() != "" && task.getActualStartDate() != null)
				task.setActualStartDate(DateConvertor.convertToDMY(task.getActualStartDate()));
			if (task.getAtcualEndDate() != "" && task.getAtcualEndDate() != null)
				task.setAtcualEndDate(DateConvertor.convertToDMY(task.getAtcualEndDate()));

			task.setExpEndDate(DateConvertor.convertToDMY(task.getExpEndDate()));
			task.setExpStartDate(DateConvertor.convertToDMY(task.getExpStartDate()));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return task;

	}

	@RequestMapping(value = { "/getPhaseTaskListByProjectId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPhaseTask> getPhaseTaskListByProjectId(@RequestParam("projectId") int projectId) {

		List<GetPhaseTask> getPhaseTaskList = new ArrayList<GetPhaseTask>();

		try {

			getPhaseTaskList = getPhaseTaskRepository.getPhaseTaskListByProjectId(projectId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getPhaseTaskList;

	}

	@RequestMapping(value = { "/getTaskDetailsByTaskId" }, method = RequestMethod.POST)
	public @ResponseBody GetTaskList getTaskDetailsByTaskId(@RequestParam("taskId") int taskId) {

		GetTaskList getTaskListList = new GetTaskList();

		try {

			getTaskListList = getTaskListRepository.findByTaskId(taskId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getTaskListList;

	}

	@RequestMapping(value = { "/ongoingProjectList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetProjects> ongoingProjectList() {

		List<GetProjects> projectList = new ArrayList<GetProjects>();

		try {

			projectList = getProjectsRepo.ongoingProjectList();

			for (int i = 0; i < projectList.size(); i++) {
				System.err.println("projct id " + projectList.get(i).getProjectId());
				List<DevloperListFromTask> devloperListFromTask = devloperListFromTaskRepo
						.devloperListFromTask(projectList.get(i).getProjectId());
				System.err.println("List " + devloperListFromTask);
				projectList.get(i).setDevloperListFromTask(devloperListFromTask);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return projectList;

	}

	@RequestMapping(value = { "/saveSupportTask" }, method = RequestMethod.POST)
	public @ResponseBody SupportTask saveSupportTask(@RequestBody SupportTask supportTask) {

		SupportTask task = new SupportTask();

		try {

			task = supportTaskRepository.save(supportTask);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return task;

	}

	@RequestMapping(value = { "/getSupportTaskBySuppId" }, method = RequestMethod.POST)
	public @ResponseBody GetSupportTask getSupportTaskBySuppId(@RequestParam("suppId") int suppId) {

		GetSupportTask getSupportTaskBySuppId = new GetSupportTask();

		try {

			getSupportTaskBySuppId = getSupportTaskRepository.getSupportTaskBySuppId(suppId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getSupportTaskBySuppId;

	}

	@RequestMapping(value = { "/getSupportTaskByEmpId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetSupportTask> getSupportTaskByEmpId(@RequestParam("empId") int empId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<GetSupportTask> getSupportTaskByEmpiId = new ArrayList<GetSupportTask>();

		try {

			getSupportTaskByEmpiId = getSupportTaskRepository.getSupportTaskByEmpiId(empId, fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getSupportTaskByEmpiId;

	}

}
