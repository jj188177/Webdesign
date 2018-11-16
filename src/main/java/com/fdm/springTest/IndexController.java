package com.fdm.springTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
//method = RequestMethod.GET
	
	@RequestMapping(value = { "/", "/index" })
	public String goToIndex() {

		return "index";
	}

}
