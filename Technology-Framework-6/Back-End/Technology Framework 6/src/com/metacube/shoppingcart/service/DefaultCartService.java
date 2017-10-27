/**
 * @Date 02-October-2017
 * @author Rajat Jain
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.shoppingcart.dao.cart.CartDao;
import com.metacube.shoppingcart.dao.order.OrderDao;
import com.metacube.shoppingcart.model.Cart;

/**
 * The Class DefaultCartService.
 */
@Service("cartService")
@Transactional
public class DefaultCartService implements CartService {

	/** The cart dao. */
	@Resource(name = "hibernateCartDao")
	CartDao cartDao;

	/** The order dao. */
	@Resource(name = "hibernateOrderDao")
	OrderDao orderDao;

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.service.CartService#getAll(java.lang.String)
	 */
	@Override
	public Iterable<Cart> getAll(final String id) {
		return cartDao.getAll(id);
	}

	/**
	 * Gets the cart dao.
	 *
	 * @return the cart dao
	 */
	public CartDao getCartDao() {
		return cartDao;
	}

	/**
	 * Sets the cart dao.
	 *
	 * @param cartDao the new cart dao
	 */
	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.service.CartService#addToCart(java.lang.String, double, int, java.lang.String)
	 */
	@Override
	public Cart addToCart(String pname, double price, int productId,
			String userId) {
		return cartDao.addToCart(pname, price, productId, userId);
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.service.CartService#checkout(java.lang.String)
	 */
	@Override
	public Boolean checkout(String id) {

		return cartDao.deleteFromCart(id);
	}

}
