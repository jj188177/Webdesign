package com.fdm.springTest;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.mockito.InOrder;

import com.fdm.entity.Item;
import com.fdmgroup.DAOdemo.ItemDAO;


public class TestItemDAO {

	@Test
	public void TestThatTheItemIsAddedCurrectly() {
		EntityManagerFactory mockemf = mock(EntityManagerFactory.class);
		EntityManager mockem = mock(EntityManager.class);
		EntityTransaction mocket = mock(EntityTransaction.class);
		Item item = mock(Item.class);
		when(mockemf.createEntityManager()).thenReturn(mockem);
		when(mockem.getTransaction()).thenReturn(mocket);

		ItemDAO itemDAO = new ItemDAO(mockemf);
		itemDAO.addItem(item);
		verify(mockemf).createEntityManager();
		verify(mockem).getTransaction();
		verify(mocket).begin();
		verify(mockem).persist(item);
		verify(mocket).commit();
		verify(mockem).close();

	}
	
	
	@Test
	public void TestThatgetItemGetTheCurrectItem() {
		EntityManagerFactory mockemf = mock(EntityManagerFactory.class);
		EntityManager mockem = mock(EntityManager.class);
		EntityTransaction mocket = mock(EntityTransaction.class);
		Item item = mock(Item.class);
		when(mockemf.createEntityManager()).thenReturn(mockem);
		when(mockem.getTransaction()).thenReturn(mocket);
		
		ItemDAO itemDAO = new ItemDAO(mockemf);
		itemDAO.getItem("pen");
		
		InOrder order = inOrder(mockemf, mockem);
		order.verify(mockemf).createEntityManager();
		order.verify(mockem).find(Item.class, "pen");
		order.verify(mockem).close();
	}
	
	@Test
	public void TestThatremoveItemwillUpdateItem() {
		EntityManagerFactory mockemf = mock(EntityManagerFactory.class);
		EntityManager mockem = mock(EntityManager.class);
		EntityTransaction mocket = mock(EntityTransaction.class);
		Item item = mock(Item.class);
		when(mockemf.createEntityManager()).thenReturn(mockem);
		when(mockem.getTransaction()).thenReturn(mocket);
		when(mockem.find(Item.class, "pen")).thenReturn(item);
		ItemDAO itemDAO = new ItemDAO(mockemf);
		itemDAO.removeItem("pen");
		
		verify(mockemf).createEntityManager();
		verify(mockem).getTransaction();
		verify(mocket).begin();
		verify(mockem).remove(item);
		verify(mocket).commit();
		verify(mockem).close();
		
	}
	
	@Test
	public void TestThatupdateItemRemoveTheCurrectUser() {
		EntityManagerFactory mockemf = mock(EntityManagerFactory.class);
		EntityManager mockem = mock(EntityManager.class);
		EntityTransaction mocket = mock(EntityTransaction.class);
		Item item = mock(Item.class);
		when(mockemf.createEntityManager()).thenReturn(mockem);
		when(mockem.getTransaction()).thenReturn(mocket);
		
		ItemDAO itemDAO = new ItemDAO(mockemf);
		itemDAO.updateItem(item);
		
		verify(mockemf).createEntityManager();
		verify(mockem).getTransaction();
		verify(mocket).begin();
		verify(mockem).merge(item);
		verify(mocket).commit();
		verify(mockem).close();
		
	}
	
	@Test
	public void TestThatgetAllItemsReturnalltheItems() {
		EntityManagerFactory mockemf = mock(EntityManagerFactory.class);
		EntityManager mockem = mock(EntityManager.class);
		EntityTransaction mocket = mock(EntityTransaction.class);
		ItemDAO itemDAO = new ItemDAO(mockemf);
		Item item = mock(Item.class);
		when(mockemf.createEntityManager()).thenReturn(mockem);
		when(mockem.getTransaction()).thenReturn(mocket);
		ArrayList<Item> itemList1 = new ArrayList<Item>();
		
		
		//when(itemDAO.getallItems()).thenReturn(itemList1);
		//List<Item> itemList = itemDAO.getallItems();
		//verify(mockemf).createEntityManager();
		//verify(mockem).close();
		//assertTrue(itemList.equals(itemList1));
		
		
	}
}
