package com.fdm.legendtrading.springmvc.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdm.legendtrading.springmvc.model.Asset;

@Repository
public class AssetDaoImpl implements AssetDao {
	
	static Logger log = LogManager.getLogger(AssetDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addAsset(Asset asset) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(asset);
		log.info("Asset saved successfully, Asset Details="+asset);
	}

	@Override
	public Asset getAssetBySymbol(String symbol) {
		
		Session session = this.sessionFactory.getCurrentSession();		
		Asset retrievedAsset = (Asset) session.load(Asset.class, symbol);
		log.info("Asset loaded successfully, Asset details="+retrievedAsset);
		
		return retrievedAsset;
	}

	@SuppressWarnings("unchecked")
	public List<Asset> listAssets() {
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Asset> assetsList = session.createQuery("from Asset").list();
		for(Asset p : assetsList){
			log.info("Assets List::"+p);
		}
		return assetsList;
	}
}
