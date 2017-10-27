/**
 * @Date 02-October-2017
 * @author Rajat Jain
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dto.CartDto;
import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.service.CartService;

/**
 * The Class DefaultCartFacade.
 */
@Component("cartFacade")
public class DefaultCartFacade implements CartFacade {

	/** The cart service. */
	@Autowired
	CartService cartService;

	/**
	 * Instantiates a new default cart facade.
	 */
	public DefaultCartFacade() {

	}

	/**
	 * Instantiates a new default cart facade.
	 *
	 * @param cartService the cart service
	 */
	public DefaultCartFacade(CartService cartService) {
		this.cartService = cartService;
	}

	/**
	 * Gets the cart service.
	 *
	 * @return the cart service
	 */
	public CartService getCartService() {
		return cartService;
	}

	/**
	 * Sets the cart service.
	 *
	 * @param cartService the new cart service
	 */
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	/**
	 * Dto to model.
	 *
	 * @param cartDto the cart dto
	 * @return the cart
	 */
	protected Cart dtoToModel(CartDto cartDto) {
		if (cartDto == null) {
			return null;
		}
		Cart cart = new Cart();
		cart.setUserId(cartDto.getUserId());
		cart.setProductId(cartDto.getProductId());
		cart.setPname(cartDto.getPname());
		cart.setPrice(cartDto.getPrice());

		return cart;
	}

	/**
	 * Model to dto.
	 *
	 * @param cart the cart
	 * @return the cart dto
	 */
	protected CartDto modelToDto(Cart cart) {
		if (cart == null) {
			return null;
		}
		CartDto cartDto = new CartDto();
		cartDto.setUserId(cart.getUserId());
		cartDto.setProductId(cart.getProductId());
		cartDto.setPname(cart.getPname());
		cartDto.setPrice(cart.getPrice());

		return cartDto;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.facade.CartFacade#getAll(java.lang.String)
	 */
	@Override
	public Iterable<Cart> getAll(final String id) {
		return cartService.getAll(id);

	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.facade.CartFacade#addToCart(java.lang.String, double, int, java.lang.String)
	 */
	@Override
	public Cart addToCart(String pname, double price, int productId,
			String userId) {
		return cartService.addToCart(pname, price, productId, userId);
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.facade.CartFacade#checkout(java.lang.String)
	 */
	@Override
	public Boolean checkout(String id) {

		return cartService.checkout(id);
	}
}
