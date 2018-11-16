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

import com.fdm.entity.Card;
import com.fdmgroup.DAOdemo.CardDAO;


public class TestCardDAO {
	
	@Test
	public void TestThatTheCardIsAddedCurrectly() {
		EntityManagerFactory mockemf = mock(EntityManagerFactory.class);
		EntityManager mockem = mock(EntityManager.class);
		EntityTransaction mocket = mock(EntityTransaction.class);
		Card card = mock(Card.class);
		when(mockemf.createEntityManager()).thenReturn(mockem);
		when(mockem.getTransaction()).thenReturn(mocket);

		CardDAO cardDAO = new CardDAO(mockemf);
		cardDAO.addCard(card);
		verify(mockemf).createEntityManager();
		verify(mockem).getTransaction();
		verify(mocket).begin();
		verify(mockem).persist(card);
		verify(mocket).commit();
		verify(mockem).close();

	}
	
	@Test
	public void TestThatgetCardGetTheCurrectItem() {
		EntityManagerFactory mockemf = mock(EntityManagerFactory.class);
		EntityManager mockem = mock(EntityManager.class);
		EntityTransaction mocket = mock(EntityTransaction.class);
		when(mockemf.createEntityManager()).thenReturn(mockem);
		when(mockem.getTransaction()).thenReturn(mocket);
		
		CardDAO cardDAO = new CardDAO(mockemf);
		cardDAO.getCard("aa");
		
		InOrder order = inOrder(mockemf, mockem);
		order.verify(mockemf).createEntityManager();
		order.verify(mockem).find(Card.class, "aa");
		order.verify(mockem).close();
	}
	
	@Test
	public void TestThatgetAllItemsReturnalltheItems() {
		EntityManagerFactory mockemf = mock(EntityManagerFactory.class);
		EntityManager mockem = mock(EntityManager.class);
		EntityTransaction mocket = mock(EntityTransaction.class);
		CardDAO cardDAO = new CardDAO(mockemf);
		Card card = mock(Card.class);
		when(mockemf.createEntityManager()).thenReturn(mockem);
		when(mockem.getTransaction()).thenReturn(mocket);
		ArrayList<Card> itemCard = new ArrayList<Card>();
	}
	
}
