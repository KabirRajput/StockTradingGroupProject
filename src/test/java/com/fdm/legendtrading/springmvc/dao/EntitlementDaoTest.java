package com.fdm.legendtrading.springmvc.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;
import org.mockito.InOrder;

import com.fdm.legendtrading.springmvc.model.Entitlement;

public class EntitlementDaoTest {
	
	
	
	@Test
	public void given_Entitlement_When_addingEntitlementToDataBase_then_entitlementIsPersistedAndResourcesClosed() {
		
		Entitlement mockEntitlement = mock(Entitlement.class);
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);

		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);

		EntitlementDaoImpl entitlementDao = new EntitlementDaoImpl(mockEmf);
		entitlementDao.add(mockEntitlement);

		InOrder order = inOrder(mockEmf, mockEm, mockEt);

		verify(mockEmf).createEntityManager();
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).persist(mockEntitlement);
		verify(mockEt).commit();
		verify(mockEm).close();

	}

	
	
	@Test
	public void get_entitlement_finds_username_and_cleans_up_resources() {
		
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		Entitlement mockEntitlement = mock(Entitlement.class);

		EntitlementDaoImpl entitlementDao = new EntitlementDaoImpl(mockEmf);
	
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		when(mockEm.find(Entitlement.class,"abc")).thenReturn(mockEntitlement);

		Entitlement entitlmentFromDB = entitlementDao.getByUsername("abc");
	
		InOrder order = inOrder(mockEmf, mockEm, mockEt);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEt).begin();
		order.verify(mockEm).find(Entitlement.class, "abc");
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
		
		assertEquals(mockEntitlement, entitlmentFromDB);
	}
	
	
	
	

}
