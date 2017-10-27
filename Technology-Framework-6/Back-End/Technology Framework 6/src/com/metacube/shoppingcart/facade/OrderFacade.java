/**
 * @Date 02-October-2017
 * @author Rajat Jain
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.model.Order;
import com.metacube.shoppingcart.model.OrderDetail;

/**
 * The Interface OrderFacade.
 */
public interface OrderFacade {

	/**
	 * Save order.
	 *
	 * @param id the id
	 * @param order the order
	 * @return true, if successful
	 */
	boolean saveOrder(String id, Order order);

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
