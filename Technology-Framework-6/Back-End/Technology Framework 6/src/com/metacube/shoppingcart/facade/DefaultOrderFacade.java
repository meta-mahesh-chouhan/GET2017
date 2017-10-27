package com.metacube.shoppingcart.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.model.Order;
import com.metacube.shoppingcart.model.OrderDetail;
import com.metacube.shoppingcart.service.OrderService;

@Component("orderFacade")
public class DefaultOrderFacade implements OrderFacade {
	@Autowired
	OrderService orderService;
	public DefaultOrderFacade() {

	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public boolean saveOrder(String id, Order order) {
		System.out.println("order service is" + orderService);
		return orderService.saveCart(id, order);
	}

	@Override
	public Iterable<Order> getAllOrder(String id) {
		return orderService.getAllOrder(id);
	}

	@Override
	public Iterable<OrderDetail> getOrderDetail(int id) {
		return orderService.getOrderDetail(id);
	}
}
