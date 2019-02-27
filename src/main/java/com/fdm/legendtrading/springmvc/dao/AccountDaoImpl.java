package com.fdm.legendtrading.springmvc.dao;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fdm.legendtrading.springmvc.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao{
	static Logger log = LogManager.getLogger(TradeDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void addAccount(Account account) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(account);
		log.info("Account created successfully, Account Details="+account);
	}
	
	@Override
	public void remove(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Account p = (Account) session.load(Account.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		log.info("Account deleted successfully, account details="+p);
	}
	
	@Override
	public Account getAccountById(long id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Account p = (Account) session.load(Account.class, new Long(id));
		log.info("Account loaded successfully, account details="+p);
		return p;
	}
	
	@Override
	public List<Account> listAccount() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Account> accountsList = session.createQuery("from Account").list();
		for(Account p : accountsList){
			log.info("Account List::"+p);
		}
		return accountsList;
	}
}