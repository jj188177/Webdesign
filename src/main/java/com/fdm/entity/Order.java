package com.fdm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Order_table")
public class Order {

	@Id
	private String orderDate;

	@Column
	private double totalPrice;

	@Column
	private String exceptedReceiveDate;

	@Type(type = "yes_no")
	private boolean ifDiscount; // Will cause an error

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "Order_Item")
	private List<Item> listOfItem;

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getExceptedReceiveDate() {
		return exceptedReceiveDate;
	}

	public void setExceptedReceiveDate(String exceptedReceiveDate) {
		this.exceptedReceiveDate = exceptedReceiveDate;
	}

	public boolean isIfDiscount() {
		return ifDiscount;
	}

	public void setIfDiscount(boolean ifDiscount) {
		this.ifDiscount = ifDiscount;
	}

	public List<Item> getListOfItem() {
		return listOfItem;
	}

	public void setListOfItem(List<Item> listOfItem) {
		this.listOfItem = listOfItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exceptedReceiveDate == null) ? 0 : exceptedReceiveDate.hashCode());
		result = prime * result + (ifDiscount ? 1231 : 1237);
		result = prime * result + ((listOfItem == null) ? 0 : listOfItem.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Order other = (Order) obj;
		if (exceptedReceiveDate == null) {
			if (other.exceptedReceiveDate != null)
				return false;
		} else if (!exceptedReceiveDate.equals(other.exceptedReceiveDate))
			return false;
		if (ifDiscount != other.ifDiscount)
			return false;
		if (listOfItem == null) {
			if (other.listOfItem != null)
				return false;
		} else if (!listOfItem.equals(other.listOfItem))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (Double.doubleToLongBits(totalPrice) != Double.doubleToLongBits(other.totalPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderDate=" + orderDate + ", totalPrice=" + totalPrice + ", exceptedReceiveDate="
				+ exceptedReceiveDate + ", ifDiscount=" + ifDiscount + ", listOfItem=" + listOfItem + "]";
	}

	public Order(String orderDate, double totalPrice, String exceptedReceiveDate, boolean ifDiscount,
			List<Item> listOfItem) {
		super();
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.exceptedReceiveDate = exceptedReceiveDate;
		this.ifDiscount = ifDiscount;
		this.listOfItem = listOfItem;
	}

	public Order() {
		super();
	}

}
