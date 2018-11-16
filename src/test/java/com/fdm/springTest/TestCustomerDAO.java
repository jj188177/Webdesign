package com.fdm.springTest;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;
import org.mockito.InOrder;

import com.fdm.entity.Customer;
import com.fdmgroup.DAOdemo.CustomerDAO;


public class TestCustomerDAO {
	
	@Test
	public void TestThatTheCustomerIsAddedCurrectly() {
		EntityManagerFactory mockemf = mock(EntityManagerFactory.class);
		EntityManager mockem = mock(EntityManager.class);
		EntityTransaction mocket = mock(EntityTransaction.class);
		Customer customer = mock(Customer.class);
		when(mockemf.createEntityManager()).thenReturn(mockem);
		when(mockem.getTransaction()).thenReturn(mocket);

		CustomerDAO customerDAO = new CustomerDAO(mockemf);
		customerDAO.addCustomer(customer);
		verify(mockemf).createEntityManager();
		verify(mockem).getTransaction();
		verify(mocket).begin();
		verify(mockem).persist(customer);
		verify(mocket).commit();
		verify(mockem).close();

	}
	
	@Test
	public void TestThatgetCustomerGetTheCurrectItem() {
		EntityManagerFactory mockemf = mock(EntityManagerFactory.class);
		EntityManager mockem = mock(EntityManager.class);
		EntityTransaction mocket = mock(EntityTransaction.class);
		when(mockemf.createEntityManager()).thenReturn(mockem);
		when(mockem.getTransaction()).thenReturn(mocket);
		
		CustomerDAO customerDAO = new CustomerDAO(mockemf);
		customerDAO.getCustomer("aa");
		
		InOrder order = inOrder(mockemf, mockem);
		order.verify(mockemf).createEntityManager();
		order.verify(mockem).find(Customer.class, "aa");
		order.verify(mockem).close();
	}
	
	
	@Test
	public void TestThatgetAllCustomersReturnalltheItems() {
		EntityManagerFactory mockemf = mock(EntityManagerFactory.class);
		EntityManager mockem = mock(EntityManager.class);
		EntityTransaction mocket = mock(EntityTransaction.class);
		CustomerDAO customerDAO = new CustomerDAO(mockemf);
		Customer customer = mock(Customer.class);
		when(mockemf.createEntityManager()).thenReturn(mockem);
		when(mockem.getTransaction()).thenReturn(mocket);
		ArrayList<Customer> listofcustomer = new ArrayList<Customer>();
		
		
		
	}
	
	
}
