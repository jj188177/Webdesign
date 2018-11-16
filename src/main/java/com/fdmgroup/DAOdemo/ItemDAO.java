package com.fdmgroup.DAOdemo;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.fdm.entity.Item;


public class ItemDAO {

	@Resource(name = "emfbean")
	private EntityManagerFactory emf;

	public ItemDAO(EntityManagerFactory mockemf) {
		// TODO Auto-generated constructor stub
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	// public void setEmf(EntityManagerFactory emf) {
	// this.emf = emf;
	// }
	public void addItem(Item item) {
	    EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(item);
		transaction.commit();
		entityManager.close();
		
	}

	public Item getItem(String name) {
		EntityManager entityManager = emf.createEntityManager();
		Item item = entityManager.find(Item.class, name);
		entityManager.close();
		return item;
	}

	public void removeItem(String name) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Item item = entityManager.find(Item.class, name);
		transaction.begin();
		entityManager.remove(item);
		transaction.commit();
		entityManager.close();
		
	}

	public void updateItem(Item item) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(item);
		transaction.commit();
		entityManager.close();
		
	}

	public List<Item> getallItems() {
		EntityManager entityManager = emf.createEntityManager();
		TypedQuery<Item> query = entityManager.createQuery("SELECT u FROM Item u", Item.class);
		List<Item> itemList = query.getResultList();
		entityManager.close();
		return itemList;
		
	}
	

}