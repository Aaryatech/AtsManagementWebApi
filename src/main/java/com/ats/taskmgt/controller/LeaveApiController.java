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
import com.ats.taskmgt.repo.leave.ApplyLeaveRepo;
import com.ats.taskmgt.repo.leave.GetApplyLeaveRepo;

@RestController
public class LeaveApiController {
	@Autowired
	ApplyLeaveRepo applyLeaveRepo;

	@Autowired
	GetApplyLeaveRepo getApplyLeaveRepo;

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

}
