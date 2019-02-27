package com.fdm.legendtrading.springmvc.service;

import com.fdm.legendtrading.springmvc.login.Verification;
import com.fdm.legendtrading.springmvc.model.Login;

/**
 * Interface to add new login credentials and verify logins.
 * @author Karthik.Asokan
 *
 */

public interface LoginService {

	public void add(Login login);
	public Login getByUsername(String username);
	public Verification verifyLoginInfo(String username, String password);
	
}
