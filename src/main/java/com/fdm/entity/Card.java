package com.fdm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Card_table")
public class Card {

	@Id
	private String cardName;

	private double discount;

	private double priceOff;

	private double minToUse;

	private double chanceToGet;

	private String productName;

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getPriceOff() {
		return priceOff;
	}

	public void setPriceOff(double priceOff) {
		this.priceOff = priceOff;
	}

	public double getMinToUse() {
		return minToUse;
	}

	public void setMinToUse(double minToUse) {
		this.minToUse = minToUse;
	}

	public double getChanceToGet() {
		return chanceToGet;
	}

	public void setChanceToGet(double chanceToGet) {
		this.chanceToGet = chanceToGet;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardName == null) ? 0 : cardName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(chanceToGet);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(minToUse);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceOff);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
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
		Card other = (Card) obj;
		if (cardName == null) {
			if (other.cardName != null)
				return false;
		} else if (!cardName.equals(other.cardName))
			return false;
		if (Double.doubleToLongBits(chanceToGet) != Double.doubleToLongBits(other.chanceToGet))
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (Double.doubleToLongBits(minToUse) != Double.doubleToLongBits(other.minToUse))
			return false;
		if (Double.doubleToLongBits(priceOff) != Double.doubleToLongBits(other.priceOff))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [cardName=" + cardName + ", discount=" + discount + ", priceOff=" + priceOff + ", minToUse="
				+ minToUse + ", chanceToGet=" + chanceToGet + ", productName=" + productName + "]";
	}

	public Card(String cardName, double discount, double priceOff, double minToUse, double chanceToGet,
			String productName) {
		super();
		this.cardName = cardName;
		this.discount = discount;
		this.priceOff = priceOff;
		this.minToUse = minToUse;
		this.chanceToGet = chanceToGet;
		this.productName = productName;
	}

	public Card() {
		super();
	}

}
