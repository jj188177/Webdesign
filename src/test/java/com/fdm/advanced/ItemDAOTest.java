package com.fdm.advanced;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.DAOdemo.ItemDAO;

public class ItemDAOTest {

	@Mock
	private EntityManagerFactory emf;
	
	@InjectMocks
	private ItemDAO itemDAO = new ItemDAO();
	
	@Before
	public void startInjectingMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getEMFTest() {
		EntityManagerFactory injectedemf = itemDAO.getEmf();
		assertEquals(emf, injectedemf);
	}

}
