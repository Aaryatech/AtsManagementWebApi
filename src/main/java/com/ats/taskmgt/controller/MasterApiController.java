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

import com.ats.taskmgt.model.Employee;
import com.ats.taskmgt.model.FormType;
import com.ats.taskmgt.model.Forms;
import com.ats.taskmgt.model.Module;
import com.ats.taskmgt.model.Project;
import com.ats.taskmgt.model.Task;
import com.ats.taskmgt.model.TaskType; 
import com.ats.taskmgt.repository.EmployeeRepository;
import com.ats.taskmgt.repository.FormTypeRepository;
import com.ats.taskmgt.repository.FormsRepository;
import com.ats.taskmgt.repository.ModuleRepository;
import com.ats.taskmgt.repository.ProjectRepository;
import com.ats.taskmgt.repository.TaskRepository;
import com.ats.taskmgt.repository.TaskTypeRepository;
 ;
 

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
	
	//----------------------------------------Employee----------------------------------------------------
	
	@RequestMapping(value = { "/saveEmployee" }, method = RequestMethod.POST)
	public @ResponseBody Employee saveEmployee(@RequestBody Employee employee) {

		Employee emp = new Employee(); 
		
		try {
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
			
			if(delete==1)
			{
				info.setError(false);
				info.setMessage("successfully Deleted");
			}
			else
			{
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
			 employee = employeeRepository.findByEmpIdAndIsUsed(empId,0);
			 
		} catch (Exception e) { 
			
			e.printStackTrace(); 

		}
		return employee;

	}
	
	@RequestMapping(value = { "/getAllEmpList" }, method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmpList() {

		List<Employee> employeeList = new ArrayList<Employee>(); 
		
		try {
			
			employeeList = employeeRepository.findByIsUsed(0);
			 
		} catch (Exception e) { 
			
			e.printStackTrace(); 

		}
		return employeeList;

	}
	
	//--------------------------------------------------Project-----------------------------------------------------
	
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
			
			if(delete==1)
			{
				info.setError(false);
				info.setMessage("successfully Deleted");
			}
			else
			{
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
	
	//-------------------------------formType--------------------------
	
	@RequestMapping(value = { "/getAllFormType" }, method = RequestMethod.GET)
	public @ResponseBody List<FormType> getAllFormType() {

		List<FormType> formTypeList = new ArrayList<FormType>(); 
		
		try {
			
			formTypeList = formTypeRepository.findByIsUsed(0);
			 
		} catch (Exception e) { 
			
			e.printStackTrace(); 

		}
		return formTypeList;

	}
	
	//----------------------------taskType---------------------------
	
	@RequestMapping(value = { "/getAllTaskTypeList" }, method = RequestMethod.GET)
	public @ResponseBody List<TaskType> getAllTaskTypeList() {

		List<TaskType> taskTypeList = new ArrayList<TaskType>(); 
		
		try {
			
			taskTypeList = taskTypeRepository.findByIsUsed(0);
			 
		} catch (Exception e) { 
			
			e.printStackTrace(); 

		}
		return taskTypeList;

	}
	
	//---------------------------------------form------------------------------------------
	
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
	
	//----------------------------------------Module---------------------------------------------------
	
	@RequestMapping(value = { "/saveModule" }, method = RequestMethod.POST)
	public @ResponseBody Module saveModule(@RequestBody Module module) {

		Module mod  = new Module(); 
		
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
	
	//-----------------------------------task------------------------
	
	@RequestMapping(value = { "/saveTask" }, method = RequestMethod.POST)
	public @ResponseBody Task saveTask(@RequestBody Task task) {

		Task tas  = new Task(); 
		
		try {
			tas = taskRepository.saveAndFlush(task);
            
		} catch (Exception e) {

			e.printStackTrace();

		}
		return tas;

	}
	
	
	@RequestMapping(value = { "/taskByFormId" }, method = RequestMethod.POST)
	public @ResponseBody List<Task> taskByFormId(@RequestParam("formId") int formId) {

		List<Task> taskList = new ArrayList<Task>(); 
		
		try {
			taskList = taskRepository.findByFormId(formId);
			 
		} catch (Exception e) { 
			
			e.printStackTrace(); 

		}
		return taskList;

	}

}
