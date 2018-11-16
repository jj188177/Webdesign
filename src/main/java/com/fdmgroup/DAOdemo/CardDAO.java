package com.fdmgroup.DAOdemo;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.fdm.entity.Card;

public class CardDAO {

	@Resource(name = "emfbean")
	private EntityManagerFactory emf;

	public CardDAO(EntityManagerFactory mockemf) {
		// TODO Auto-generated constructor stub
	}

	public void addCard(Card card) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(card);
		transaction.commit();
		entityManager.close();
	}

	public Card getCard(String name) {
		EntityManager entityManager = emf.createEntityManager();
		Card card = entityManager.find(Card.class, name);
		entityManager.close();
		return card;
	}

	public List<Card> getallCards() {
		EntityManager entityManager = emf.createEntityManager();
		TypedQuery<Card> query = entityManager.createQuery("SELECT u FROM Card u", Card.class);
		List<Card> cardList = query.getResultList();
		entityManager.close();
		return cardList;

	}

}
