package com.fdm.springTest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdm.entity.Customer;
import com.fdmgroup.DAOdemo.CustomerDAO;

@Controller
public class RegisterSuccessController {

	@Resource(name = "Customer")
	Customer customer;
	
	@Resource(name = "Customer")
	Customer customertoAdd;
	
	@Resource(name = "Customer")
	Customer customerModel;

	@Resource(name = "CustomerDAOBean")
	CustomerDAO customerDAO;

	@RequestMapping(value = "/registerSuccess")
	public String registerSuccess(HttpServletRequest request, Model model) {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String address = request.getParameter("address");

		request.setAttribute("email", email);
		request.setAttribute("password", password);
		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);
		request.setAttribute("username", username);
		request.setAttribute("address", address);

		model.addAttribute("register_customer", customer);
		Customer customer = customerDAO.getCustomer(email);
		if (customer != null) {
			request.setAttribute("emailERROR", "email already exist");
			return "register";
		} else if (password == null || firstName == null || lastName == null || username == null || address == null) {
			request.setAttribute("ERROR", "can not be empty!!");
			return "register";
		} else if (password.length() < 3) {
			request.setAttribute("passwordERROR", "password too short");
			return "register";
		} else if (firstName.length() < 3) {
			request.setAttribute("firstNameERROR", "firstName too short");
			return "register";
		} else if (lastName.length() < 3) {
			request.setAttribute("lastNameERROR", "last name too short");
			return "register";
		} else if (username.length() < 3) {
			request.setAttribute("userNameERROR", "user name 2 short");
			return "register";
		} else if (address.length() < 3) {
			request.setAttribute("addressERROR", "address 2 short");
			return "register";
		} else {
			customertoAdd.setAddress(address);
			customertoAdd.setEmail(email);
			customertoAdd.setFirstName(firstName);
			customertoAdd.setLastName(lastName);
			customertoAdd.setPassword(password);
			customertoAdd.setUsername(username);
			customerDAO.addCustomer(customertoAdd);
			request.setAttribute("OK", "register success now you can login");
		}

		model.addAttribute("login_customer", customerModel);
		return "Login";

	}

}
