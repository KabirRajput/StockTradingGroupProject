package com.fdm.legendtrading.springmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.fdm.legendtrading.springmvc.model.Entitlement;


public class EntitlementDaoImpl implements EntitlementDao{
	
	private EntityManagerFactory emf;

	public EntitlementDaoImpl(EntityManagerFactory emf) {

		this.emf = emf;

	}
	@Override
	public void add(Entitlement entitlement) {

		EntityManager Em =  emf.createEntityManager();
		EntityTransaction Et = Em.getTransaction();
		Et.begin();
		Em.persist(entitlement);
		Et.commit();
		Em.close();
	}
	
	@Override
	public Entitlement getByUsername(String username) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Entitlement entitlement = em.find(Entitlement.class, username);
		et.commit();
		em.close();
		return entitlement;
	}

}
