/**
 * @Date 02-October-2017
 * @author Rajat Jain
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Cart.
 */
@Entity
@Table(name = "cart")
public class Cart {

	/** The cart id. */
	@Id
	@Column(name = "cartId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;

	/** The user id. */
	@Column(name = "userId")
	private String userId;

	/** The pname. */
	@Column(name = "pname")
	private String pname;

	/** The price. */
	@Column(name = "price")
	private double price;

	/** The product id. */
	@Column(name = "productId")
	private int productId;

	/** The quantity. */
	@Column(name = "quantity")
	private int quantity;

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

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

	/**
	 * Gets the cart id.
	 *
	 * @return the cart id
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * Sets the cart id.
	 *
	 * @param cartId the new cart id
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", pname="
				+ pname + ", price=" + price + ", productId=" + productId
				+ ", quantity=" + quantity + "]";
	}

}
