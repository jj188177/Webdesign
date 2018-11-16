package com.fdmgroup.DAOdemo;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.fdm.entity.Customer;

import oracle.sql.CustomDatum;

public class CustomerDAO {

	@Resource(name = "emfbean")
	private EntityManagerFactory emf;

	public CustomerDAO(EntityManagerFactory mockemf) {
		// TODO Auto-generated constructor stub
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void addCustomer(Customer customer) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(customer);
		transaction.commit();
		entityManager.close();

	}

	public Customer getCustomer(String name) {
		EntityManager entityManager = emf.createEntityManager();
		Customer customer = entityManager.find(Customer.class, name);
		entityManager.close();
		return customer;
	}

	public List<Customer> getallCustomer() {
		EntityManager entityManager = emf.createEntityManager();
		TypedQuery<Customer> query = entityManager.createQuery("SELECT u FROM Customer u", Customer.class);
		List<Customer> customerList = query.getResultList();
		entityManager.close();
		return customerList;

	}

}
