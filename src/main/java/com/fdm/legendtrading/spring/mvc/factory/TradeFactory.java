package com.fdm.legendtrading.spring.mvc.factory;

import com.fdm.legendtrading.springmvc.model.Trade;

public class TradeFactory {

	public static Trade getTrade() {
		
		return new Trade();
	}
	
}
