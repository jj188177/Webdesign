package com.fdm.springTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IndexControllerTest {
	
	@Test
	public void WhenRequestFromIndexResourceThenReturnIndexJsp() {
		
		IndexController ic = new IndexController();
		String nextPage = ic.goToIndex();
		
		assertEquals("index", nextPage);
		
		
	}
	
	
}
