package com.fdm.legendtrading.springmvc.dao;
import java.util.List;
import org.hibernate.SessionFactory;
import com.fdm.legendtrading.springmvc.model.Account;
public interface AccountDao {
	
	void setSessionFactory(SessionFactory sessionFactory);
	void addAccount(Account account);
	void remove(int id);
	Account getAccountById(long id);
	List<Account> listAccount();
}