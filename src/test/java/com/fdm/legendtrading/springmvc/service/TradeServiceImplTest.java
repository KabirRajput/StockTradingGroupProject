package com.fdm.legendtrading.springmvc.service;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InOrder;

import com.fdm.legendtrading.spring.mvc.factory.TradeFactory;
import com.fdm.legendtrading.springmvc.dao.TradeDao;
import com.fdm.legendtrading.springmvc.model.Account;
import com.fdm.legendtrading.springmvc.model.Trade;

public class TradeServiceImplTest {

	@Test
	public void when_trade_is_made_trade_is_added_to_database() {
		
		String assetSymbol = "AMZN";
		long quantity = 100;
		double pricePerShare = 23.5;
		String username = "Andrew";
		Account mockAccount1 = mock(Account.class);
		Account mockAccount2 = mock(Account.class);
		Trade mockTrade = mock(Trade.class);
		TradeDao mockTD = mock(TradeDao.class);
//		TradeFactory mockTF = mock(TradeFactory.class);
		
		when(TradeFactory.getTrade()).thenReturn(mockTrade);
		
		TradeServiceImpl tsi = new TradeServiceImpl();
		tsi.setTradeDao(mockTD);
		tsi.insertTrade(assetSymbol, quantity, pricePerShare, mockAccount1, mockAccount2, username);
		
		InOrder order = inOrder(mockTD);
		
		order.verify(mockTD).addTrade(mockTrade);
	}
	
	
}
