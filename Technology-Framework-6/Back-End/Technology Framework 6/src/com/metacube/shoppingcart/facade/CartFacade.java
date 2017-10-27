/**
 * @Date 02-October-2017
 * @author Rajat Jain
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.model.Cart;

/**
 * The Interface CartFacade.
 */
public interface CartFacade {

	/**
	 * Gets the all.
	 *
	 * @param id the id
	 * @return the all
	 */
	Iterable<Cart> getAll(final String id);

	/**
	 * Adds the to cart.
	 *
	 * @param pname the pname
	 * @param price the price
	 * @param productId the product id
	 * @param userId the user id
	 * @return the cart
	 */
	Cart addToCart(String pname, double price, int productId, String userId);

	/**
	 * Checkout.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	Boolean checkout(String id);

}
