package com.fdm.legendtrading.springmvc.dao;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fdm.legendtrading.springmvc.model.Trade;

@Repository
public class TradeDaoImpl implements TradeDao {
	static Logger log = LogManager.getLogger(TradeDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addTrade(Trade trade) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(trade);
		log.info("Trade saved successfully, Trade Details="+trade);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Trade> findAllByBuyAccountId(long id){
		Session session = this.sessionFactory.openSession();
		List<Trade> buyTradeList = session.createQuery("from Trade").list();
		session.close();
		for(Trade t : buyTradeList){
			log.info("Trade List::"+t);
		}
		return buyTradeList;
	}

	@SuppressWarnings("unchecked")
	public List<Trade> findAllBySellAccountId(long id){
		Session session = this.sessionFactory.openSession();
		List<Trade> sellTradeList = session.createQuery("from Trade").list();
		session.close();
		for(Trade t : sellTradeList){
			log.info("Trade List::"+t);
		}
		return sellTradeList;
	}

}
