package com.fdm.legendtrading.springmvc.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;
import org.mockito.InOrder;

import com.fdm.legendtrading.springmvc.model.Login;

public class LoginDaoTest {
	
	
	
	@Test
	public void given_LoginInfo_When_addingLoginInfoToDataBase_then_loginInfoIsPersistedAndResourcesClosed() {
		
		Login mocklogin = mock(Login.class);
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);

		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);

		LoginDaoImpl loginDao = new LoginDaoImpl(mockEmf);
		loginDao.add(mocklogin);

		InOrder order = inOrder(mockEmf, mockEm, mockEt);

		verify(mockEmf).createEntityManager();
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).persist(mocklogin);
		verify(mockEt).commit();
		verify(mockEm).close();

	}
	
	@Test
	public void get_loginInfo_finds_username_and_cleans_up_resources() {
		
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		Login mocklogin = mock(Login.class);

		LoginDaoImpl loginDao = new LoginDaoImpl(mockEmf);
	
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		when(mockEm.find(Login.class,"abc")).thenReturn(mocklogin);

		Login loginInfoFromDB = loginDao.getByUsername("abc");
	
		InOrder order = inOrder(mockEmf, mockEm, mockEt);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEt).begin();
		order.verify(mockEm).find(Login.class, "abc");
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
		
		assertEquals(mocklogin, loginInfoFromDB);
	}
	
	@Test
	public void verify_given_nonExistingLoginInfo_when_findingByName_then_returnsFalse() {

		
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		
		LoginDaoImpl mockLoginDao = mock(LoginDaoImpl.class);
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		when(mockLoginDao.getByUsername("abc")).thenReturn(null);
		
		Boolean verification = mockLoginDao.verifyLoginInfo("abc", "edg");
		assertFalse(verification);
		

	}
	
//	@Test
//	public void verify_given_existingLoginInfo_when_findingByName_then_returnsTrue() {
//
//		String username = "abc";
//		String password = "edg";
// 		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
//		EntityManager mockEm = mock(EntityManager.class);
//		EntityTransaction mockEt = mock(EntityTransaction.class);
//		
//		LoginDao mockLoginDao = mock(LoginDao.class);
//		Login login = new Login(username, password);
//		when(mockEmf.createEntityManager()).thenReturn(mockEm);
//		when(mockEm.getTransaction()).thenReturn(mockEt);
//		when(mockLoginDao.getByUsername(username)).thenReturn(login);
//		
//		Boolean verification = mockLoginDao.verifyLoginInfo(username, password);
//		assertTrue(verification);
//		
//
//	}

}
