package com.fdm.legendtrading.springmvc.dao;

import java.util.List;
import com.fdm.legendtrading.springmvc.model.Trade;

public interface TradeDao {

	public List<Trade> findAllByBuyAccountId(long id);
	public List<Trade> findAllBySellAccountId(long id);
	public void addTrade(Trade trade);
	
}

