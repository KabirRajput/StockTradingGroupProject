package com.fdm.legendtrading.springmvc.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import org.junit.Test;
import org.mockito.InOrder;

import com.fdm.legendtrading.springmvc.model.Account;

public class AccountDaoTest {
	private EntityManagerFactory mockEmf;
	private EntityManager mockEm;
	private AccountDao accountDao;
	private EntityTransaction mockEt;
	private Account mockAccount;

	@Test
	public void adding_account_persists_to_database() {
		mockEmf = mock(EntityManagerFactory.class);
		mockEm = mock(EntityManager.class);
		mockEt = mock(EntityTransaction.class);
		mockAccount = mock(Account.class);
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);

		accountDao = new AccountDao(mockEmf);

		accountDao.create(mockAccount);

		InOrder order = inOrder(mockEmf, mockEm, mockEt);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEt).begin();
		order.verify(mockEm).persist(mockAccount);
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
	}

	@Test
	public void removing_account_removes_succesfully() {
		mockEmf = mock(EntityManagerFactory.class);
		mockEm = mock(EntityManager.class);
		mockEt = mock(EntityTransaction.class);
		mockAccount = mock(Account.class);
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		when(mockAccount.getAccountId()).thenReturn(10);
		when(mockEm.find(Account.class, 10)).thenReturn(mockAccount);
		
		accountDao = new AccountDao(mockEmf);
		accountDao.remove(mockAccount.getAccountId());

		
		InOrder order = inOrder(mockEmf, mockEm, mockEt);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEm).find(Account.class, 10);
		order.verify(mockEt).begin();
		order.verify(mockEm).remove(mockAccount);
		order.verify(mockEt).commit();
		order.verify(mockEm).close();

	}
	
	
	@Test
	public void get_account_finds_account_and_cleans_up_resources() {
		mockEmf = mock(EntityManagerFactory.class);
		mockEm = mock(EntityManager.class);
		mockEt = mock(EntityTransaction.class);
		mockAccount = mock(Account.class);
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);

		accountDao = new AccountDao(mockEmf);
		
		accountDao.create(mockAccount);
		when(mockEm.find(Account.class, (Object) 1)).thenReturn(mockAccount);
		accountDao.getById(1);
		
		InOrder order = inOrder(mockEmf, mockEm, mockEt);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEt).begin();
		order.verify(mockEm).find(Account.class, 1);
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
	}
	
	@Test
	public void get_all_account_when_no_account_available() {
		mockEmf = mock(EntityManagerFactory.class);
		mockEm = mock(EntityManager.class);
		mockEt = mock(EntityTransaction.class);
		mockAccount = mock(Account.class);
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);

		accountDao = new AccountDao(mockEmf);
		
		accountDao.create(mockAccount);
		Query mockQuery = mock(TypedQuery.class);
		when(mockEm.createQuery("SELECT e FROM Account e", Account.class)).thenReturn(null);

		List<Account> result = accountDao.getAllAccount();
		
		InOrder order = inOrder(mockEmf, mockEm, mockEt,mockQuery);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEt).begin();
		order.verify(mockEm).createQuery("SELECT e FROM Account e", Account.class);
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
		assertEquals(new ArrayList<>(),result);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void get_all_account_when_accounts_exist() {
		mockEmf = mock(EntityManagerFactory.class);
		mockEm = mock(EntityManager.class);
		mockEt = mock(EntityTransaction.class);
		mockAccount = mock(Account.class);
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);

		accountDao = new AccountDao(mockEmf);
		
		accountDao.create(mockAccount);
		Query mockQuery = mock(TypedQuery.class);
		when(mockEm.createQuery("SELECT e FROM Account e", Account.class)).thenReturn((TypedQuery<Account>)mockQuery);
		List<Account> testingList =  new ArrayList<Account>();
		testingList.add(mockAccount);
		when(mockQuery.getResultList()).thenReturn(testingList);

		List<Account> result = accountDao.getAllAccount();
		
		InOrder order = inOrder(mockEmf, mockEm, mockEt,mockQuery);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEt).begin();
		order.verify(mockEm).createQuery("SELECT e FROM Account e", Account.class);
		order.verify(mockQuery).getResultList();
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
		assertEquals(testingList,result);
	}


}
