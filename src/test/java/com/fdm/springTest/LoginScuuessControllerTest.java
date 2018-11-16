package com.fdm.springTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.ui.Model;

public class LoginScuuessControllerTest {
	
	
	@Test
	public void WhenloginSuccessReturnHomePage() {
		Model model = mock(Model.class);
		HttpServletRequest ht = mock(HttpServletRequest.class);
		LoginSuccessController is = new LoginSuccessController();
		String nextPage = is.goToHome(ht, model);
		
		assertEquals("home", nextPage);
		
		
	}
}
