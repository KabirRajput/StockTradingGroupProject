package com.fdm.legendtrading.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdm.legendtrading.springmvc.dao.LoginDao;
import com.fdm.legendtrading.springmvc.login.Verification;
import com.fdm.legendtrading.springmvc.model.Login;

/**
 * 
 * Adds new login credentials and verifies logins
 * @author Karthik.Asokan
 * @version 1.0
 *
 */

@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao loginDao;

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	@Override
	public void add(Login login) {

		loginDao.add(login);
	}

	@Override
	public Login getByUsername(String username) {
		Login login = loginDao.getByUsername(username);
		return login;
	}

	@Override
	public Verification verifyLoginInfo(String username, String password) {
		Verification verification = loginDao.verifyLoginInfo(username, password);
		return verification;
	}

}



