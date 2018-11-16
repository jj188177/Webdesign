package com.fdm.springTest;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.mockito.InOrder;

import com.fdm.entity.Order;
import com.fdmgroup.DAOdemo.OrderDAO;

import antlr.collections.List;

public class TestOrderDAO {

	@Test
	public void TestThatAddOrderIsAddedCurrectly() {
		EntityManagerFactory mockemf = mock(EntityManagerFactory.class);
		EntityManager mockem = mock(EntityManager.class);
		EntityTransaction mocket = mock(EntityTransaction.class);
		Order order = mock(Order.class);
		when(mockemf.createEntityManager()).thenReturn(mockem);
		when(mockem.getTransaction()).thenReturn(mocket);

		OrderDAO orderDAO = new OrderDAO(mockemf);
		orderDAO.addOrder(order);
		verify(mockemf).createEntityManager();
		verify(mockem).getTransaction();
		verify(mocket).begin();
		verify(mockem).persist(order);
		verify(mocket).commit();
		verify(mockem).close();

	}
	
	@Test
	public void TestThatgetAllOrdersReturnalltheItems() {
//		EntityManagerFactory mockemf = mock(EntityManagerFactory.class);
//		EntityManager mockem = mock(EntityManager.class);
//		EntityTransaction mocket = mock(EntityTransaction.class);
//		OrderDAO orderDAO = new OrderDAO(mockemf);
//		Order order = mock(Order.class);
//		when(mockemf.createEntityManager()).thenReturn(mockem);
//		TypedQuery<Order> query = null;
//		when(mockem.createQuery("SELECT u FROM order u", Order.class)).thenReturn(query);
//		List orderList = (List) new ArrayList();
//		orderList.add(order);
//		when(query.getResultList()).thenReturn(orderList);
//		
//		orderDAO.getallOrders();
		
//		when(orderDAO.getallOrders()).thenReturn(orderList);
//		when(orderDAO.getallOrders()).thenReturn(orderList);
//		List orderList1 = (List) orderDAO.getallOrders();
//		verify(mockemf).createEntityManager();
//		verify(mockem).close();
//		verify(mockem).createQuery("SELECT u FROM order u", Order.class);
//		assertTrue(orderList.equals(orderList1));
		
		
	}
	
	

}
