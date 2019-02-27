package com.fdm.legendtrading.springmvc.dao;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.junit.Test;
import org.mockito.InOrder;

import com.fdm.legendtrading.springmvc.model.Position;
import com.fdm.legendtrading.springmvc.model.PositionId;

public class PositionDaoImplTest {

	@Test
	public void given_position_when_adding_position_toDataBase_then_position_isPersistedAndResourcesClosed() {

		Position mockPosition = mock(Position.class);
		PositionDaoImpl mockPDI = mock(PositionDaoImpl.class);
		Session mockSession = mock(Session.class);

		when(mockPDI.sessionFactory.getCurrentSession()).thenReturn(mockSession);

		PositionDaoImpl pdi = new PositionDaoImpl(mockEmf); 
		pdi.addPosition(mockPosition);

		InOrder order = inOrder(mockEmf, mockEm, mockEt);

		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEt).begin();
		order.verify(mockEm).persist(mockPosition);
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
	}
	
	@Test
	public void given_customer_when_changingPassword_then_passwordIsUpdated() {

		PositionId id = mock(PositionId.class);
		long newQuantity = 5;

		Position mockPosition = mock(Position.class);
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		TypedQuery<Position> mockQuery = mock(TypedQuery.class);

		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		when(mockEm.createQuery("SELECT c FROM Position c WHERE c.id = '" + id + "'", Position.class))
				.thenReturn(mockQuery);
		when(mockQuery.getSingleResult()).thenReturn(mockPosition);

		PositionDaoImpl pdi = new PositionDaoImpl(mockEmf); 
		pdi.updatePosition(id, newQuantity);

		InOrder order = inOrder(mockEmf, mockEm, mockEt, mockPosition);

		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEt).begin();
		order.verify(mockPosition).setQuantity(newQuantity);
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
	}
	
	@Test
	public void given_existingId_when_findingById_then_returnsFromDataBase() {
		
		PositionId id = mock(PositionId.class);
		
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		
		PositionDaoImpl pdi = new PositionDaoImpl(mockEmf); 
		pdi.getPositionById(id);
		
		InOrder order = inOrder(mockEmf, mockEm);
		
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).find(Position.class, id);
		order.verify(mockEm).close();
	}
	
	@Test
	public void given_t_when_deleting_t_toDataBase_then_t_isDeletedAndResourcesClosed() {

		Position mockPosition = mock(Position.class);
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);

		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);

		PositionDaoImpl pdi = new PositionDaoImpl(mockEmf); 
		pdi.removePosition(mockPosition);

		InOrder order = inOrder(mockEmf, mockEm, mockEt);

		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEt).begin();
		order.verify(mockEm).remove(mockPosition);
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
	}
	
}
