package com.fdm.springTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;

public class LoginControllerTest {
	
	@Test
	public void whenRequestForLoginThenREturnLogingJspPage() {
		
		LoginController lc = new LoginController();
		Model model = mock(Model.class);
		HttpServletRequest ht = mock(HttpServletRequest.class);
		
		String go = lc.loginUser(ht, model);
		
		assertEquals("Login", go);
		
	}
	
}
