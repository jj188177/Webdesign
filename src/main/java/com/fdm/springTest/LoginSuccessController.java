package com.fdm.springTest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdm.entity.Customer;
import com.fdmgroup.DAOdemo.CustomerDAO;

@Controller
public class LoginSuccessController {

	@Resource(name = "CustomerDAOBean")
	CustomerDAO customerDAO;

	@Resource(name = "Customer")
	Customer customer;
	
	@RequestMapping(value = "/home")
	public String goToHome(HttpServletRequest request, Model model) {
		model.addAttribute("login_customer", customer);
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (customerDAO.getCustomer(email) == null) {

			request.setAttribute("emailERROR", "Email not found");
			request.setAttribute("password", password);
			request.setAttribute("email", email);
			return "Login";

		} else if (!(customerDAO.getCustomer(email).getPassword().equals(password))) {
			request.setAttribute("passwordERROR", "wrong password");
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			return "Login";
		}
		
		return "home";
	}

}
