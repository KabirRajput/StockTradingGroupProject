package com.fdm.legendtrading.springmvc.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fdm.legendtrading.springmvc.model.Position;

@Repository
public class PositionDaoImpl implements PositionDao {
	
	static Logger log = LogManager.getLogger(TradeDaoImpl.class);
	Transaction tx;
	int result;
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPosition(Position position) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(position);
		log.info("Position saved successfully, Position Details="+position);
	}

	@Override
	public void updatePosition(long accountId, String assetSymbol, long quantity) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			tx = (Transaction) session.beginTransaction();
			Query query = session.createQuery("update Position set quantity = :quantity" +
					" where accountId = :accountId and assetSymbol = :assetSymbol");
			query.setParameter("quantity", quantity);
			query.setParameter("accountId", accountId);
			query.setParameter("assetSymbol", assetSymbol);
			result = query.executeUpdate();
			if (!tx.wasCommitted())
			    tx.commit();

		} catch (Exception exp) {
			tx.rollback();

		}
		 
		log.info("Position updated successfully, Result="+result);
	}

	@SuppressWarnings("unchecked")
	public List<Position> listPositions() {

		Session session = this.sessionFactory.getCurrentSession();
		List<Position> positionsList = session.createQuery("from Position").list();
		for(Position p : positionsList){
			log.info("Position List::"+p);
		}
		return positionsList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Position> getPositionsByAccountId(long id) {
		Session session = this.sessionFactory.getCurrentSession();		
		List<Position> positions = session.createQuery("FROM Position p WHERE p.accountId = '" + id + "'").list();
		log.info("Positions retrieved " + positions);
		return positions;
	}

	@Override
	public Position getPositionByAssetSymbolAndAccountId(String assetSymbol, long accountId) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from Position where accountId =:accountId and assetSymbol =:assetSymbol");
		query.setParameter("accountId", accountId);
		query.setParameter("assetSymbol", assetSymbol);
		Position retrievedPosition = (Position)query.uniqueResult();
		log.info("Position loaded successfully, Position details="+retrievedPosition);
		return retrievedPosition;

	}

	@Override
	public void removePosition(Position position) {

		Session session = this.sessionFactory.getCurrentSession();
		session.delete(position);

		log.info("Position deleted successfully, Position details="+position);
	}

}
