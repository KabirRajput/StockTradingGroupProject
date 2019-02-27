package com.fdm.legendtrading.springmvc.dao;

import com.fdm.legendtrading.springmvc.login.Verification;
import com.fdm.legendtrading.springmvc.model.Login;

public interface LoginDao {
	public void add(Login login);
	public Login getByUsername(String username);
	public Verification verifyLoginInfo(String username, String password);
}	
	