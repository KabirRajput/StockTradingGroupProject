package com.fdm.legendtrading.springmvc.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdm.legendtrading.spring.mvc.factory.TradeFactory;
import com.fdm.legendtrading.springmvc.dao.TradeDao;
import com.fdm.legendtrading.springmvc.model.Account;
import com.fdm.legendtrading.springmvc.model.Trade;
/**
 * 
 * Inserts and finds trades by the respective id
 * @author Kabir.Rajput
 * @version 1.0
 *
 */
@Service("tradeService")
public class TradeServiceImpl implements TradeService {


	@Autowired
	private TradeDao tradeDao;

	public void setTradeDao(TradeDao tradeDao) {
		this.tradeDao = tradeDao;
	}
	
	@Override
	@Transactional
	public void addTrade(Trade t) {
		t.setTransactionTime(new Date());
		this.tradeDao.addTrade(t);
	}
	
	public List<Trade> findAllByAccountId(long id) {
		return this.tradeDao.findAllByBuyAccountId(id);
	}
	
	public List<Trade> findAllByBuyAccountId(long id) {
		return this.tradeDao.findAllByBuyAccountId(id);
	}

	public List<Trade> findAllBySellAccountId(long id) {
		return this.tradeDao.findAllBySellAccountId(id);
	}
	

}
