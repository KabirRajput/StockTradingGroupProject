package com.fdm.legendtrading.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdm.legendtrading.springmvc.dao.AccountDao;
import com.fdm.legendtrading.springmvc.model.Account;

/**
 * Account Service can find account by id and list all accounts
 * 
 * @author Kabir.Rajput
 *
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountDao;

	@Override
	@Transactional
	public void addAccount(Account account) {
		accountDao.addAccount(account);
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	@Transactional
	public Account getById(int id) {
		return accountDao.getAccountById(id);
	}

	@Override
	public void removeAccount(int id) {
		accountDao.remove(id);
	}

	@Override
	public List<Account> getAllAccount() {
		return accountDao.listAccount();
	}

}
