package com.ats.taskmgt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.taskmgt.model.proj.ProjList;
import com.ats.taskmgt.model.proj.ProjTaskDetail;
import com.ats.taskmgt.repo.proj.ProjListRepo;
import com.ats.taskmgt.repo.proj.ProjTaskDetailRepo;

@RestController
public class ProjectApiController {

	@Autowired
	ProjListRepo getProjListRepo;

	@RequestMapping(value = { "/getProjList" }, method = RequestMethod.GET)
	public @ResponseBody List<ProjList> getProjList() {

		List<ProjList> projList = new ArrayList<ProjList>();

		try {
			projList = getProjListRepo.getProjList();

		} catch (Exception e) {

			System.err.println("Ex in getProjList " + e.getMessage());
			e.printStackTrace();

		}

		return projList;

	}

	@Autowired
	ProjTaskDetailRepo getProjTaskDetailRepo;

	@RequestMapping(value = { "/getProjTaskDetailOnLoad" }, method = RequestMethod.POST)
	public @ResponseBody List<ProjTaskDetail> getProjTaskDetail(@RequestParam("projId") int projId) {

		List<ProjTaskDetail> projTaskDetail = new ArrayList<ProjTaskDetail>();

		try {

			projTaskDetail = getProjTaskDetailRepo.getProjTaskDetail(projId);

		} catch (Exception e) {

			System.err.println("Ex in getProjTaskDetail " + e.getMessage());
			e.printStackTrace();

		}

		return projTaskDetail;

	}

	@RequestMapping(value = { "/getProjTaskDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<ProjTaskDetail> getProjTaskDetail(@RequestParam("projId") int projId,
			@RequestParam("empIdList") int empIdList, @RequestParam("techIdList") int techIdList,
			@RequestParam("phaseIdList") int phaseIdList) {

		List<ProjTaskDetail> projTaskDetail = new ArrayList<ProjTaskDetail>();
System.err.println("tech Id " +techIdList + "emp Id List  " +empIdList);
		try {

			if (empIdList == -1 && techIdList == -1) {
				System.err.println("Inside geting proj detail by all emp and all techIds ");
				projTaskDetail = getProjTaskDetailRepo.getProjTaskDetail(projId);
			}
			 else if (empIdList == -1 && techIdList>0) {
				System.err.println("Inside geting proj detail by all emp and spec techIds ");
				projTaskDetail = getProjTaskDetailRepo.getProjTaskDetailAllEmpSpecTechId(projId, techIdList);
			 
			}
			 else if (empIdList>0 && techIdList==-1) {
					System.err.println("Inside geting proj detail by SPEC emp and ALL techIds ");
					projTaskDetail = getProjTaskDetailRepo.getProjTaskDetailAllTechSpecEmp(projId, empIdList);
				 
				}
			 
			 else if(empIdList>0 && techIdList>0) {
				System.err.println("Inside geting proj detail by spec techIds and spec  emp ");
				projTaskDetail = getProjTaskDetailRepo.getProjTaskDetailSpec(projId, empIdList, techIdList);
			}
	
		} catch (Exception e) {

			System.err.println("Ex in getProjTaskDetail " + e.getMessage());
			e.printStackTrace();

		}
		System.err.println("projTaskDetail " +projTaskDetail.toString());

		return projTaskDetail;

	}

}
