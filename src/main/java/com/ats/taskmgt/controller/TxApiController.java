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

import com.ats.taskmgt.model.Info;
import com.ats.taskmgt.model.txapi.CmplxOption;
import com.ats.taskmgt.model.txapi.Complexity;
import com.ats.taskmgt.model.txapi.GetCmplxHrs;
import com.ats.taskmgt.model.txapi.GetComplexity;
import com.ats.taskmgt.model.txapi.GetComplexityOption;
import com.ats.taskmgt.model.txapi.GetFormType;
import com.ats.taskmgt.model.txapi.GetTech;
import com.ats.taskmgt.model.txapi.Technology;
import com.ats.taskmgt.repo.txapi.CmplxOptionRepo;
import com.ats.taskmgt.repo.txapi.ComplexityRepo;
import com.ats.taskmgt.repo.txapi.GetComplexityOptionRepo;
import com.ats.taskmgt.repo.txapi.GetComplexityRepo;
import com.ats.taskmgt.repo.txapi.GetFormTypeRepo;
import com.ats.taskmgt.repo.txapi.GetTechRepo;
import com.ats.taskmgt.repo.txapi.TechnologyRepo;
import com.ats.taskmgt.repository.GetCmplxHrsRepo;

@RestController
public class TxApiController {

	@Autowired
	TechnologyRepo technologyRepo;

	@Autowired
	GetCmplxHrsRepo getCmplxHrsRepo;

	@Autowired
	GetTechRepo getTechRepo;

	@Autowired
	ComplexityRepo complexityRepo;

	@Autowired
	CmplxOptionRepo cmplxOptionRepo;

	@Autowired
	GetComplexityRepo getComplexityRepo;

	@Autowired
	GetComplexityOptionRepo getComplexityOptionRepo;

	@Autowired
	GetFormTypeRepo getFormTypeRepo;

	@RequestMapping(value = { "/getAllFormTypeList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetFormType> getAllFormTypeList() {

		List<GetFormType> techList = new ArrayList<GetFormType>();

		try {

			techList = getFormTypeRepo.getFormTechPhaseName();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return techList;

	}

	// ----------------------------------------ComplexityOption------------------------------------------

	@RequestMapping(value = { "/saveComplexityOption" }, method = RequestMethod.POST)
	public @ResponseBody CmplxOption saveComplexityOption(@RequestBody CmplxOption cmplxOption) {

		CmplxOption comp = new CmplxOption();

		try {

			comp = cmplxOptionRepo.saveAndFlush(cmplxOption);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return comp;

	}

	@RequestMapping(value = { "/saveComplexityOptionList" }, method = RequestMethod.POST)
	public @ResponseBody List<CmplxOption> saveComplexityOptionList(@RequestBody List<CmplxOption> cmplxOptionList) {

		List<CmplxOption> comp = new ArrayList<CmplxOption>();

		try {

			comp = cmplxOptionRepo.saveAll(cmplxOptionList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return comp;

	}

	@RequestMapping(value = { "/compOptionByCmplxOptId" }, method = RequestMethod.POST)
	public @ResponseBody CmplxOption compOptionByCmplxOptId(@RequestParam("cmplxOptId") int cmplxOptId) {

		CmplxOption comp = new CmplxOption();

		try {
			comp = cmplxOptionRepo.findByCmplxOptId(cmplxOptId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return comp;

	}

	@RequestMapping(value = { "/getAllCompOptionList" }, method = RequestMethod.GET)
	public @ResponseBody List<CmplxOption> getAllCompOptionList() {

		List<CmplxOption> compList = new ArrayList<CmplxOption>();

		try {

			compList = cmplxOptionRepo.findByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return compList;

	}

	@RequestMapping(value = { "/getAllCompOptionListWithName" }, method = RequestMethod.GET)
	public @ResponseBody List<GetComplexityOption> getAllCompOptionListWithName() {

		List<GetComplexityOption> compList = new ArrayList<GetComplexityOption>();

		try {

			compList = getComplexityOptionRepo.getComplexityOption();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return compList;

	}

	@RequestMapping(value = { "/deleteComplexityOption" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteComplexityOption(@RequestParam("cmplxOptId") int cmplxOptId) {

		Info info = new Info();

		try {
			int delete = cmplxOptionRepo.deleteComplexOption(cmplxOptId);

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

	// ----------------------------------------Complexity------------------------------------------

	@RequestMapping(value = { "/saveComplexity" }, method = RequestMethod.POST)
	public @ResponseBody Complexity saveComplexity(@RequestBody Complexity complexity) {

		Complexity comp = new Complexity();

		try {

			comp = complexityRepo.saveAndFlush(complexity);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return comp;

	}

	@RequestMapping(value = { "/compByCmplxId" }, method = RequestMethod.POST)
	public @ResponseBody Complexity compByCmplxId(@RequestParam("cmplxId") int cmplxId) {

		Complexity comp = new Complexity();

		try {
			comp = complexityRepo.findByCmplxId(cmplxId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return comp;

	}

	@RequestMapping(value = { "/getAllCompList" }, method = RequestMethod.GET)
	public @ResponseBody List<Complexity> getAllCompList() {

		List<Complexity> compList = new ArrayList<Complexity>();

		try {

			compList = complexityRepo.findByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return compList;

	}

	@RequestMapping(value = { "/deleteComplexity" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteComplexity(@RequestParam("cmplxId") int cmplxId) {

		Info info = new Info();

		try {
			int delete = complexityRepo.deleteComplexity(cmplxId);

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

	// ----------------------------------------Technology------------------------------------------

	@RequestMapping(value = { "/saveTechnology" }, method = RequestMethod.POST)
	public @ResponseBody Technology saveTechnology(@RequestBody Technology technology) {

		Technology tech = new Technology();

		try {

			tech = technologyRepo.saveAndFlush(technology);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return tech;

	}

	@RequestMapping(value = { "/techByTechId" }, method = RequestMethod.POST)
	public @ResponseBody Technology techByTechId(@RequestParam("techId") int techId) {

		Technology tech = new Technology();

		try {
			tech = technologyRepo.findByTechId(techId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return tech;

	}

	@RequestMapping(value = { "/getAllTechList" }, method = RequestMethod.GET)
	public @ResponseBody List<Technology> getAllTechList() {

		List<Technology> techList = new ArrayList<Technology>();

		try {

			techList = technologyRepo.findByIsUsedOrderByTechIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return techList;

	}

	@RequestMapping(value = { "/getAllTechPhaseList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetTech> getAllTechPhaseList() {

		List<GetTech> techList = new ArrayList<GetTech>();

		try {

			techList = getTechRepo.getTechPhaseName();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return techList;

	}

	@RequestMapping(value = { "/deleteTech" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteTech(@RequestParam("techId") int techId) {

		Info info = new Info();

		try {
			int delete = technologyRepo.deleteTech(techId);

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

	@RequestMapping(value = { "/getAllComplexityList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetComplexity> getAllComplexityList() {

		List<GetComplexity> techList = new ArrayList<GetComplexity>();

		try {

			techList = getComplexityRepo.getComplexityAllName();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return techList;

	}

	@RequestMapping(value = { "/getHeaderDetailCompByTechId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetComplexity> getHeaderDetailCompByTechId(@RequestParam("techId") int techId,
			@RequestParam("phaseId") int phaseId) {

		List<GetComplexity> techList = new ArrayList<GetComplexity>();

		try {
			techList = getComplexityRepo.getComplexityByIds(techId, phaseId);
			for (int i = 0; i < techList.size(); i++) {
				List<CmplxOption> optList = cmplxOptionRepo.findByCmplxId(techList.get(i).getCmplxId());
				techList.get(i).setCmplxOptionList(optList);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return techList;

	}

	@RequestMapping(value = { "/getCompByTechIdListAndPhaseIdList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetComplexity> getCompByTechIdListAndPhaseIdList(
			@RequestParam("techId") List<Integer> techId, @RequestParam("phaseId") List<Integer> phaseId) {

		List<GetComplexity> techList = new ArrayList<GetComplexity>();

		try {
			techList = getComplexityRepo.getComplexityByIdsList(techId, phaseId);
			for (int i = 0; i < techList.size(); i++) {
				List<CmplxOption> optList = cmplxOptionRepo.findByCmplxId(techList.get(i).getCmplxId());
				techList.get(i).setCmplxOptionList(optList);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return techList;

	}

	@RequestMapping(value = { "/getCompListByIdList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCmplxHrs> getCompListByIdList(@RequestParam("techId") List<Integer> techId,
			@RequestParam("phaseId") List<Integer> phaseId, @RequestParam("cmplxOptId") List<Integer> cmplxOptId) {

		List<GetCmplxHrs> techList = new ArrayList<GetCmplxHrs>();

		try {

			if (techId.contains(0) && phaseId.contains(0)) {
				techList = getCmplxHrsRepo.getComplexAllocatedHrs(cmplxOptId);
			} else {
				techList = getCmplxHrsRepo.getComplexAllocatedHrsByList(techId, phaseId, cmplxOptId);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return techList;

	}

	@RequestMapping(value = { "/getAllCmplxOptionListAllocatedHrs" }, method = RequestMethod.GET)
	public @ResponseBody List<GetCmplxHrs> getAllCmplxOptionListAllocatedHrs() {

		List<GetCmplxHrs> techList = new ArrayList<GetCmplxHrs>();

		try {

			techList = getCmplxHrsRepo.getComplexAllocatedHrsList();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return techList;

	}

}
