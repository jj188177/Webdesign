package com.fdm.springTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.ui.Model;

public class RegisterSuccessTest {

	
	@Test
	public void whenRequestForregisterThenREturnLogingJspPage() {
		
		RegisterController lc = new RegisterController();
		Model model = mock(Model.class);
		HttpServletRequest ht = mock(HttpServletRequest.class);
		
		String go = lc.goToRegister(model);
		
		assertEquals("register", go);
		
	}
}
