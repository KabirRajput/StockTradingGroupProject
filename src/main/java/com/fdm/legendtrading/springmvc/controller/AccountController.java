package com.fdm.legendtrading.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.fdm.legendtrading.springmvc.service.AccountService;

@Controller
public class AccountController {
	
	private AccountService accountService;
	
	
	@Autowired(required=true)
	@Qualifier(value="accountService")
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	
	
	
	
	

}
