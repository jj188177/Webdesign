package com.fdm.springTest;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdm.entity.Customer;

@Controller
public class LoginController {
	
	@Resource(name = "Customer")
	Customer customer;
	
	@RequestMapping(value = "/Login")
	public String loginUser(HttpServletRequest request, Model model) {
		
		model.addAttribute("login_customer", customer);
		return "Login";
	}
}
