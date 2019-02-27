package com.fdm.legendtrading.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Index Controller managers all the trade interactions between the client (view) and the model.
 * @author Kabir.Rajput
 *
 */

@Controller
public class IndexController {

	@RequestMapping(value = "/")
	public String indexPage (Model model) {
		model.addAttribute("greeting", "Welcome to legend trading");
		return "index";
	}

}
