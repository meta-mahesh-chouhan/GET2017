/**
 * @Date 02-October-2017
 * @author Rajat Jain
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.dto;

/**
 * The Class CartDto.
 */
public class CartDto {

	/** The user id. */
	private String userId;

	/** The pname. */
	private String pname;

	/** The price. */
	private double price;

	/** The product id. */
	private int productId;

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the pname.
	 *
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * Sets the pname.
	 *
	 * @param pname the new pname
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * Sets the product id.
	 *
	 * @param productId the new product id
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

}
