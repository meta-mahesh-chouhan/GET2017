/**
 * @Date 02-October-2017
 * @author Rajat Jain
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.util.List;

import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.model.Order;
import com.metacube.shoppingcart.model.OrderDetail;
import com.metacube.shoppingcart.model.Product;

/**
 * The Interface BaseDao.
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
public interface BaseDao<T, ID extends Serializable> {

	/**
	 * Find one.
	 *
	 * @param primaryKey the primary key
	 * @return the t
	 */
	T findOne(ID primaryKey);
	
	/**
	 * Gets the one.
	 *
	 * @param id the id
	 * @return the one
	 */
	T getOne(String id);

	/**
	 * Find all.
	 *
	 * @return the iterable
	 */
	Iterable<T> findAll();

	/**
	 * Delete.
	 *
	 * @param primaryKey the primary key
	 * @return true, if successful
	 */
	boolean delete(ID primaryKey);

	/**
	 * Exists.
	 *
	 * @param primaryKey the primary key
	 * @return true, if successful
	 */
	boolean exists(ID primaryKey);

	/**
	 * Update.
	 *
	 * @param id the id
	 * @param name the name
	 * @param price the price
	 * @return the product
	 */
	Product update(int id, String name, double price);

	/**
	 * Save.
	 *
	 * @param id the id
	 * @param name the name
	 * @param price the price
	 * @return the product
	 */
	Product save(int id, String name, double price);

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
	 * Delete from cart.
	 *
	 * @param username the username
	 * @return true, if successful
	 */
	boolean deleteFromCart(String username);
	
	/**
	 * Save order.
	 *
	 * @param id the id
	 * @param order the order
	 * @return the int
	 */
	int saveOrder(String id, Order order);
	
	/**
	 * Save cart.
	 *
	 * @param cart the cart
	 * @param orderId the order id
	 */
	void saveCart(List<Cart> cart, int orderId);
	
	/**
	 * Gets the all order.
	 *
	 * @param id the id
	 * @return the all order
	 */
	Iterable<Order> getAllOrder(String id);
	
	/**
	 * Gets the order detail.
	 *
	 * @param id the id
	 * @return the order detail
	 */
	Iterable<OrderDetail> getOrderDetail(int id);
}
