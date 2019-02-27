package com.fdm.legendtrading.springmvc.dao;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.mockito.InOrder;

import com.fdm.legendtrading.springmvc.model.Asset;

public class AssetDaoImplTest {
	
	@Test
	public void given_Asset_when_AddingAssetToDatabase_then_AssetIsPersistedAndResourcesClosed()
	{
		Asset mockAsset = mock(Asset.class);
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		
		AssetDaoImpl assetDAO = new AssetDaoImpl(mockEmf);
		assetDAO.addAsset(mockAsset);
		
		InOrder order = inOrder(mockEm, mockEmf, mockEt);
		
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEt).begin();
		order.verify(mockEm).persist(mockAsset);
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
	}
	
	@Test
	public void given_existingAsset_when_findingBySymbol_then_returnAssetFromDatabase()
	{
		String symbol = "AAPL";
		
		Asset mockAsset = mock(Asset.class);
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		TypedQuery<Asset> mockQ = mock(TypedQuery.class);
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		when(mockEm.createQuery("SELECT a FROM Asset a WHERE a.symbol = '" + symbol + "'", Asset.class)).thenReturn(mockQ);
		when(mockQ.setParameter("symbol", symbol)).thenReturn(mockQ);
		when(mockQ.getSingleResult()).thenReturn(mockAsset);
		
		AssetDaoImpl assetDao = new AssetDaoImpl(mockEmf);
		assetDao.getAssetBySymbol(symbol);
		
		InOrder order = inOrder(mockEmf, mockEm, mockQ, mockEt);
		
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEm).createQuery("SELECT a FROM Asset a WHERE a.symbol = '" + symbol + "'", Asset.class);
		order.verify(mockQ).setParameter("symbol", symbol);
		order.verify(mockEt).begin();
		order.verify(mockQ).getSingleResult();
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
	}
	
	@Test
	public void when_getAssetList_is_invoked_it_returns_a_list_of_all_assets() {
		List<Asset> mockList = mock(List.class);
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		TypedQuery<Asset> mockQ = mock(TypedQuery.class);
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		when(mockEm.createQuery("SELECT a FROM Asset a", Asset.class)).thenReturn(mockQ);
		when(mockQ.getResultList()).thenReturn(mockList);
		
		AssetDaoImpl assetDao = new AssetDaoImpl (mockEmf);
		assetDao.listAssets();
		
		InOrder order = inOrder(mockEmf, mockEm, mockEt, mockQ);
		
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEm).createQuery("SELECT a FROM Asset a", Asset.class);
		order.verify(mockEt).begin();
		order.verify(mockQ).getResultList();
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
	}
}
