package com.ats.taskmgt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.taskmgt.common.DateConvertor;
import com.ats.taskmgt.model.Info;
import com.ats.taskmgt.model.leave.ApplyLeave;
import com.ats.taskmgt.model.leave.GetApplyLeave;
import com.ats.taskmgt.model.leave.GetLeaveCount;
import com.ats.taskmgt.model.leave.GetShortLeave;
import com.ats.taskmgt.model.leave.ShortLeave;
import com.ats.taskmgt.repo.leave.ApplyLeaveRepo;
import com.ats.taskmgt.repo.leave.GetApplyLeaveRepo;
import com.ats.taskmgt.repo.leave.GetLeaveCountRepo;
import com.ats.taskmgt.repo.leave.GetShortLeaveRepo;
import com.ats.taskmgt.repo.leave.ShortLeaveRepo;

@RestController
public class LeaveApiController {
	@Autowired
	ApplyLeaveRepo applyLeaveRepo;

	@Autowired
	GetLeaveCountRepo getLeaveCountRepo;

	@Autowired
	GetApplyLeaveRepo getApplyLeaveRepo;

	@Autowired
	ShortLeaveRepo shortLeaveRepo;

	@Autowired
	GetShortLeaveRepo getShortLeaveRepo;

	// --------------------------------------------------Leave-----------------------------------------------------

	@RequestMapping(value = { "/saveLeave" }, method = RequestMethod.POST)
	public @ResponseBody ApplyLeave saveLeave(@RequestBody ApplyLeave applyLeave) {

		ApplyLeave appLeave = new ApplyLeave();

		try {
			Date now = new Date();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy_MM_dd hh:mm:ss");

			applyLeave.setFromDate(DateConvertor.convertToYMD(applyLeave.getFromDate()));
			applyLeave.setToDate(DateConvertor.convertToYMD(applyLeave.getToDate()));
			applyLeave.setDate(sdf.format(now));
			applyLeave.setApproveDate(sdf1.format(now));
			appLeave = applyLeaveRepo.saveAndFlush(applyLeave);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return appLeave;

	}

	@RequestMapping(value = { "/deleteApplayLeave" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteApplayLeave(@RequestParam("leaveId") int leaveId) {

		Info info = new Info();

		try {
			int delete = applyLeaveRepo.deleteApplayLeave(leaveId);

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

	@RequestMapping(value = { "/getCountForSickLeave" }, method = RequestMethod.GET)
	public @ResponseBody List<GetLeaveCount> getCountForSickLeave() {
		List<GetLeaveCount> leavelist = new ArrayList<>();

		try {
			leavelist = getLeaveCountRepo.getCountForSickLeave();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return leavelist;

	}

	@RequestMapping(value = { "/getCountForCasualLeave" }, method = RequestMethod.GET)
	public @ResponseBody List<GetLeaveCount> getCountForCasualLeave() {
		List<GetLeaveCount> leavelist = new ArrayList<>();

		try {
			leavelist = getLeaveCountRepo.getCountForCasualLeave();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return leavelist;

	}

	@RequestMapping(value = { "/leaveByLeaveId" }, method = RequestMethod.POST)
	public @ResponseBody ApplyLeave leaveByLeaveId(@RequestParam("leaveId") int leaveId) {

		ApplyLeave appLeave = new ApplyLeave();

		try {
			appLeave = applyLeaveRepo.findByLeaveIdAndIsUsed(leaveId, 1);
			appLeave.setFromDate(DateConvertor.convertToDMY(appLeave.getFromDate()));
			appLeave.setToDate(DateConvertor.convertToDMY(appLeave.getToDate()));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return appLeave;

	}

	@RequestMapping(value = { "/getAllLeaveList" }, method = RequestMethod.GET)
	public @ResponseBody List<ApplyLeave> getAllLeaveList() {

		List<ApplyLeave> leaveList = new ArrayList<ApplyLeave>();

		try {

			leaveList = applyLeaveRepo.findByIsUsed(1);
			for (int i = 0; i < leaveList.size(); i++) {
				leaveList.get(i).setDate(DateConvertor.convertToDMY(leaveList.get(i).getDate()));

				leaveList.get(i).setFromDate(DateConvertor.convertToDMY(leaveList.get(i).getFromDate()));
				leaveList.get(i).setToDate(DateConvertor.convertToDMY(leaveList.get(i).getToDate()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return leaveList;

	}

	@RequestMapping(value = { "/getAllLeaveListByEmpId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetApplyLeave> getAllLeaveListByEmpId(@RequestParam("empId") int empId) {

		List<GetApplyLeave> leaveList = new ArrayList<GetApplyLeave>();

		try {

			leaveList = getApplyLeaveRepo.getApplyLeaveByEmpId(empId);
			for (int i = 0; i < leaveList.size(); i++) {
				leaveList.get(i).setDate(DateConvertor.convertToDMY(leaveList.get(i).getDate()));

				leaveList.get(i).setFromDate(DateConvertor.convertToDMY(leaveList.get(i).getFromDate()));
				leaveList.get(i).setToDate(DateConvertor.convertToDMY(leaveList.get(i).getToDate()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return leaveList;

	}

	@RequestMapping(value = { "/getAllLeaveListReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetApplyLeave> getAllLeaveListReport(@RequestParam("empIdList") List<Integer> empIdList,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<GetApplyLeave> leaveList = new ArrayList<GetApplyLeave>();

		try {

			if (empIdList.contains(0)) {
				leaveList = getApplyLeaveRepo.getApplyLeaveReportBetweenDate(fromDate, toDate);
			} else {
				leaveList = getApplyLeaveRepo.getApplyLeaveReportByEmpIdList(empIdList, fromDate, toDate);
			}

			for (int i = 0; i < leaveList.size(); i++) {
				leaveList.get(i).setDate(DateConvertor.convertToDMY(leaveList.get(i).getDate()));

				leaveList.get(i).setFromDate(DateConvertor.convertToDMY(leaveList.get(i).getFromDate()));
				leaveList.get(i).setToDate(DateConvertor.convertToDMY(leaveList.get(i).getToDate()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return leaveList;

	}

	@RequestMapping(value = { "/getLeaveByLeaveId" }, method = RequestMethod.POST)
	public @ResponseBody GetApplyLeave getLeaveByLeaveId(@RequestParam("leaveId") int leaveId) {

		GetApplyLeave leaveList = new GetApplyLeave();

		try {

			leaveList = getApplyLeaveRepo.getApplyLeaveByLeaveId(leaveId);

			leaveList.setDate(DateConvertor.convertToDMY(leaveList.getDate()));

			leaveList.setFromDate(DateConvertor.convertToDMY(leaveList.getFromDate()));
			leaveList.setToDate(DateConvertor.convertToDMY(leaveList.getToDate()));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return leaveList;

	}

	@RequestMapping(value = { "/getAllLeaveListBySendTo" }, method = RequestMethod.POST)
	public @ResponseBody List<GetApplyLeave> getAllLeaveListBySendTo(@RequestParam("empId") int empId) {

		List<GetApplyLeave> leaveList = new ArrayList<GetApplyLeave>();

		try {

			leaveList = getApplyLeaveRepo.getApplyLeaveBySendTo(empId);
			for (int i = 0; i < leaveList.size(); i++) {
				leaveList.get(i).setDate(DateConvertor.convertToDMY(leaveList.get(i).getDate()));

				leaveList.get(i).setFromDate(DateConvertor.convertToDMY(leaveList.get(i).getFromDate()));
				leaveList.get(i).setToDate(DateConvertor.convertToDMY(leaveList.get(i).getToDate()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return leaveList;

	}

	// -------------------------------------------------Short-Leave----------------

	@RequestMapping(value = { "/saveShortLeave" }, method = RequestMethod.POST)
	public @ResponseBody ShortLeave saveShortLeave(@RequestBody ShortLeave shortLeave) {

		ShortLeave shLeave = new ShortLeave();

		try {
			Date now = new Date();

			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy_MM_dd hh:mm:ss");
			shortLeave.setDate(DateConvertor.convertToYMD(shortLeave.getDate()));
			shortLeave.setApproveDate(sdf1.format(now));
			shLeave = shortLeaveRepo.saveAndFlush(shortLeave);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return shLeave;

	}

	@RequestMapping(value = { "/getAllShortLeaveByEmpId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetShortLeave> getAllShortLeaveByEmpId(@RequestParam("empId") int empId) {

		List<GetShortLeave> leaveList = new ArrayList<GetShortLeave>();

		try {

			leaveList = getShortLeaveRepo.getShortLeaveByEmpId(empId);
			for (int i = 0; i < leaveList.size(); i++) {
				leaveList.get(i).setDate(DateConvertor.convertToDMY(leaveList.get(i).getDate()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return leaveList;

	}

	@RequestMapping(value = { "/getAllShortLeaveListBySendTo" }, method = RequestMethod.POST)
	public @ResponseBody List<GetShortLeave> getAllShortLeaveListBySendTo(@RequestParam("empId") int empId) {

		List<GetShortLeave> leaveList = new ArrayList<GetShortLeave>();

		try {

			leaveList = getShortLeaveRepo.getShortLeaveBySendTo(empId);
			for (int i = 0; i < leaveList.size(); i++) {
				leaveList.get(i).setDate(DateConvertor.convertToDMY(leaveList.get(i).getDate()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return leaveList;

	}

	@RequestMapping(value = { "/getShortLeaveByLeaveId" }, method = RequestMethod.POST)
	public @ResponseBody GetShortLeave getShortLeaveByLeaveId(@RequestParam("shortLeaveId") int shortLeaveId) {

		GetShortLeave leaveList = new GetShortLeave();

		try {

			leaveList = getShortLeaveRepo.getShortLeaveByLeaveId(shortLeaveId);

			leaveList.setDate(DateConvertor.convertToDMY(leaveList.getDate()));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return leaveList;

	}

	@RequestMapping(value = { "/checkShortLeave" }, method = RequestMethod.POST)
	public @ResponseBody Info checkShortLeave(@RequestParam("empId") int empId) {

		Info info = new Info();

		List<ShortLeave> shortLeaveList = new ArrayList<ShortLeave>();

		try {
			shortLeaveList = shortLeaveRepo.getShortLeaveByEmpId(empId);

			if (shortLeaveList.size() == 0) {
				info.setError(false);
				info.setMessage("Applicable");

			} else if (shortLeaveList.size() > 0) {
				info.setError(true);
				info.setMessage("Not Applicable ");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage("exception ");

		}
		return info;

	}

}
