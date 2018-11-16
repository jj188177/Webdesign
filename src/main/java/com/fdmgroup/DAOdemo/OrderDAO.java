package com.fdmgroup.DAOdemo;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.fdm.entity.Order;


public class OrderDAO {
	
	
	@Resource(name = "emfbean")
	private EntityManagerFactory emf;

	public OrderDAO(EntityManagerFactory mockemf) {
		// TODO Auto-generated constructor stub
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void addOrder(Order order) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(order);
		transaction.commit();
		entityManager.close();
	}

	public List<Order> getallOrders() {
		EntityManager entityManager = emf.createEntityManager();
		TypedQuery<Order> query = entityManager.createQuery("SELECT d FROM Order d", Order.class);
		List<Order> orderList = query.getResultList();
		entityManager.close();
		return orderList;

	}

	
}
