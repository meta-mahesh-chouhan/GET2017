/**
 * @Date 02-October-2017
 * @author Rajat Jain
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.shoppingcart.dao.order.OrderDao;
import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.model.Order;
import com.metacube.shoppingcart.model.OrderDetail;

/**
 * The Class DefaultOrderService.
 */
@Service("orderService")
@Transactional
public class DefaultOrderService implements OrderService {
	
	/** The order dao. */
	@Resource(name = "hibernateOrderDao")
	OrderDao orderDao;
	
	/** The cart service. */
	@Resource(name = "cartService")
	CartService cartService;
	
	/**
	 * Gets the order dao.
	 *
	 * @return the order dao
	 */
	public OrderDao getOrderDao() {
		return orderDao;
	}

	/**
	 * Sets the order dao.
	 *
	 * @param orderDao the new order dao
	 */
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.service.OrderService#saveCart(java.lang.String, com.metacube.shoppingcart.model.Order)
	 */
	@Override
	public boolean saveCart(String id, Order order) {

		int orderId = orderDao.saveOrder(id, order);
		Iterable<Cart> cart = cartService.getAll(id);

		System.out.println(cart.toString());
		Cart carts;
		List<Cart> cartModel = new ArrayList<Cart>();
		for (Cart cartObj : cart) {
			carts = new Cart();
			carts.setPname(cartObj.getPname());
			carts.setPrice(cartObj.getPrice());
			carts.setQuantity(1);
			cartModel.add(carts);
		}
		System.out.println("cart list" + cartModel.toString());
		orderDao.saveCart(cartModel, orderId);
		cartService.checkout(id);
		return true;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.service.OrderService#getAllOrder(java.lang.String)
	 */
	@Override
	public Iterable<Order> getAllOrder(String id) {
		return orderDao.getAllOrder(id);
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.service.OrderService#getOrderDetail(int)
	 */
	@Override
	public Iterable<OrderDetail> getOrderDetail(int id) {
		return orderDao.getOrderDetail(id);
	}
}
