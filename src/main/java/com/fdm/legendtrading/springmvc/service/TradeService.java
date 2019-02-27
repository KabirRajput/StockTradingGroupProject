package com.fdm.legendtrading.springmvc.service;

import java.util.List;
import com.fdm.legendtrading.springmvc.model.Trade;
/**
 * Interface to insert and find trades by respective id
 * @author Kabir.Rajput
 *
 */
public interface TradeService {

	public List<Trade> findAllByAccountId(long id);
	
//	public List<Trade> findAllByBuyAccountId(long id);
//	
//	public List<Trade> findAllBySellAccountId(long id);
	
	public void addTrade(Trade trade );
	
}
