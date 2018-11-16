package com.fdm.springTest;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdm.entity.Customer;

@Controller
public class RegisterController {
	
	@Resource(name = "Customer")
	Customer customer;
	
	@RequestMapping(value = "/register")
	public String goToRegister(Model model) {
		model.addAttribute("register_customer", customer);
		
		
		
		
		return "register";
		
	}
	
	
	
	
	
}
