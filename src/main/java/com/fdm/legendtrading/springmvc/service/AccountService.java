package com.fdm.legendtrading.springmvc.service;

import java.util.List;

import com.fdm.legendtrading.springmvc.model.Account;

public interface AccountService {

	Account getById(int id);

	List<Account> getAllAccount();

	void addAccount(Account account);

	void removeAccount(int id);

}