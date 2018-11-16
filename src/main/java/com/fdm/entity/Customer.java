package com.fdm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_table")
public class Customer {

	@Id
	private String email;

	private String firstName;

	private String lastName;

	private String username;

	private String password;

	private String address;

	private double balance;

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "Order_Customer")
	private List<Order> listOfOrder;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "Customer_card")
	private List<Card> listOfCard;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Order> getListOfOrder() {
		return listOfOrder;
	}

	public void setListOfOrder(List<Order> listOfOrder) {
		this.listOfOrder = listOfOrder;
	}

	public List<Card> getListOfCard() {
		return listOfCard;
	}

	public void setListOfCard(List<Card> listOfCard) {
		this.listOfCard = listOfCard;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((listOfCard == null) ? 0 : listOfCard.hashCode());
		result = prime * result + ((listOfOrder == null) ? 0 : listOfOrder.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (listOfCard == null) {
			if (other.listOfCard != null)
				return false;
		} else if (!listOfCard.equals(other.listOfCard))
			return false;
		if (listOfOrder == null) {
			if (other.listOfOrder != null)
				return false;
		} else if (!listOfOrder.equals(other.listOfOrder))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", address=" + address + ", balance=" + balance
				+ ", listOfOrder=" + listOfOrder + ", listOfCard=" + listOfCard + "]";
	}

	public Customer(String email, String firstName, String lastName, String username, String password, String address,
			double balance, List<Order> listOfOrder, List<Card> listOfCard) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.balance = balance;
		this.listOfOrder = listOfOrder;
		this.listOfCard = listOfCard;
	}

	public Customer() {
		super();
	}

}
