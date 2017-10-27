/**
 * @Date 02-October-2017
 * @author Rajat Jain
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.dto;

import java.sql.Date;

/**
 * The Class OrderDto.
 */
public class OrderDto {

	/** The card number. */
	private String cardNumber;

	/** The expiration date. */
	private Date expirationDate;

	/** The cvv. */
	private int cvv;

	/** The dop. */
	private Date dop;

	/** The amount. */
	private double amount;

	/**
	 * Gets the card number.
	 *
	 * @return the card number
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * Sets the card number.
	 *
	 * @param cardNumber the new card number
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * Gets the expiration date.
	 *
	 * @return the expiration date
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * Sets the expiration date.
	 *
	 * @param expirationDate the new expiration date
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * Gets the cvv.
	 *
	 * @return the cvv
	 */
	public int getCvv() {
		return cvv;
	}

	/**
	 * Sets the cvv.
	 *
	 * @param cvv the new cvv
	 */
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	/**
	 * Gets the dop.
	 *
	 * @return the dop
	 */
	public Date getDop() {
		return dop;
	}

	/**
	 * Sets the dop.
	 *
	 * @param dop the new dop
	 */
	public void setDop(Date dop) {
		this.dop = dop;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
