package com.fdm.legendtrading.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdm.legendtrading.springmvc.service.PositionService;

@Controller
public class PositionController {

	private PositionService positionService;

	@Autowired(required=true)
	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}
	
	@RequestMapping(value="/positions", method = RequestMethod.GET)
	public String displayPosition(Model model) {
		model.addAttribute("positions", positionService.getPositionsByAccountId(1));
		return "positions";
	}
}
