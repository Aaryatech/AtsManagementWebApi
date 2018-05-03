package com.ats.taskmgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.taskmgt.common.DateConvertor;
import com.ats.taskmgt.model.Leaves;
import com.ats.taskmgt.repository.LeavesRepository;

@RestController

public class TestController {

	@Autowired
	LeavesRepository leavesRepository;

	// ----------------------------------------Leaves---------------------------------------------------

	@RequestMapping(value = { "/saveLeaves" }, method = RequestMethod.POST)
	public @ResponseBody Leaves saveLeaves(@RequestBody Leaves leaves) {

		Leaves leave = new Leaves();

		try {

			leaves.setFromDate(DateConvertor.convertToYMD(leaves.getFromDate()));
			leaves.setToDate(DateConvertor.convertToYMD(leaves.getToDate()));
			leave = leavesRepository.saveAndFlush(leaves);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return leave;

	}
}
