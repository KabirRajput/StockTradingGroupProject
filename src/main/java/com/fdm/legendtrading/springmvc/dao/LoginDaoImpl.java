package com.fdm.legendtrading.springmvc.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fdm.legendtrading.springmvc.login.Verification;
import com.fdm.legendtrading.springmvc.model.Login;

@Repository
public class LoginDaoImpl implements LoginDao {

	static Logger log = LogManager.getLogger(AssetDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public LoginDaoImpl() {
		super();
	}

	@Override
	public void add(Login login) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		session.persist(login);
		tx.commit();
		session.close();
		log.info("New login info saved successfully");
	}

	@Override
	public Login getByUsername(String username) {

		Session session = this.sessionFactory.openSession();
		Login login = (Login) session.get(Login.class, username);
		session.close();

		log.info("Retrieved login details");

		return login;
	}

	@Override
	public Verification verifyLoginInfo(String username, String password) {

		// Login login = getByUsername(username);

		Session session = this.sessionFactory.openSession();
		Login login = (Login) session.get(Login.class, username);
		session.close();

		if (login == null) {
			log.info("User does not exist");
			return Verification.NoUser;
		} else {

			String pw = login.getPassword();
			System.out.println(pw);
			System.out.println(password);
			if (password.equals(pw)) {
				log.info("Login credentials verified");
				return Verification.Verified;
			} else {
				log.info("Login credentials not verified");
				return Verification.NotVerified;
			}
		}
	}
}
