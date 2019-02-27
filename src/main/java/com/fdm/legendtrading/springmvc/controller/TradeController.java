package com.fdm.legendtrading.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fdm.legendtrading.springmvc.model.Trade;
import com.fdm.legendtrading.springmvc.service.PositionService;
import com.fdm.legendtrading.springmvc.service.TradeService;

@Controller
public class TradeController {
	private TradeService tradeService;
	private PositionService positionService;

	@Autowired(required=true)
	@Qualifier(value="tradeService")
	public void setTradeService(TradeService tradeService) {
		this.tradeService = tradeService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="positionService")
	public void setTradeService(PositionService positionService) {
		this.positionService = positionService;
	}
	
	@RequestMapping(value="/trades", method = RequestMethod.GET)
	public String showTrades(Model model) {
		model.addAttribute("trades", tradeService.findAllByAccountId(1));
		return "trades";
	}
	
	@RequestMapping(value="/addTrade", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("addTrade", "addTrade", new Trade());
	}
	
	@RequestMapping(value="/addTrade", method = RequestMethod.POST)
	public String submitTrade(@ModelAttribute("addTrade")Trade trade) {
		tradeService.addTrade(trade);
		positionService.updatePosition(trade);
		return "index";
	}
}
