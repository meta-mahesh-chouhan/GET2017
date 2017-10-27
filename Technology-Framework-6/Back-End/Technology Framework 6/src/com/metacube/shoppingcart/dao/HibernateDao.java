/**
 * @Date 02-October-2017
 * @author Rajat Jain
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.model.Order;
import com.metacube.shoppingcart.model.OrderDetail;
import com.metacube.shoppingcart.model.Product;

/**
 * The Class HibernateDao.
 *
 * @param <T>
 *            the generic type
 * @param <ID>
 *            the generic type
 */
public abstract class HibernateDao<T, ID extends Serializable>
		implements
			BaseDao<T, ID> {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Gets the session factory.
	 *
	 * @return the session factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Sets the session factory.
	 *
	 * @param sessionFactory
	 *            the new session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** The model class. */
	private Class<T> modelClass;

	/**
	 * Gets the model class.
	 *
	 * @return the model class
	 */
	public Class<T> getModelClass() {
		return modelClass;
	}

	/**
	 * Instantiates a new hibernate dao.
	 *
	 * @param modelClass
	 *            the model class
	 */
	public HibernateDao(Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.dao.BaseDao#findAll()
	 */
	/*
	 * @see com.metacube.shoppingcart.dao.BaseDao#findAll()
	 */
	@Override
	public Iterable<T> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		List<T> personsList = cr.list();
		return personsList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.dao.BaseDao#findOne(java.io.Serializable)
	 */
	@Override
	public T findOne(final ID primaryKey) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		cr = cr.add(Restrictions.eq("id", primaryKey));
		return (T) cr.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.dao.BaseDao#exists(java.io.Serializable)
	 */
	@Override
	public boolean exists(final ID primaryKey) {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.dao.BaseDao#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(final ID primaryKey) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		boolean result = true;
		T product = (T) cr.add(Restrictions.eq("id", primaryKey));
		session.delete(product);
		return result;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.dao.BaseDao#save(int, java.lang.String,
	 * double)
	 */
	@Override
	public Product save(int id, String name, double price) {
		Session session = this.sessionFactory.getCurrentSession();
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		session.save(product);
		return product;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.dao.BaseDao#update(int, java.lang.String,
	 * double)
	 */
	@Override
	public Product update(int id, String name, double price) {
		Session session = this.sessionFactory.getCurrentSession();

		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		session.update(product);

		return product;

	}
	@Override
	public T getOne(final String id) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		cr = cr.add(Restrictions.eq("cname", id));
		return (T) cr.uniqueResult();
	}

	@Override
	public Iterable<Cart> getAll(final String id) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		cr = cr.add(Restrictions.eq("userId", id));
		List<Cart> productList = cr.list();
		return productList;
	}
	@Override
	public Cart addToCart(String pname, double price, int productId,
			String userId) {

		Session session = this.sessionFactory.getCurrentSession();
		Cart cart = new Cart();
		cart.setPname(pname);
		cart.setPrice(price);
		cart.setProductId(productId);
		cart.setUserId(userId);
		cart.setQuantity(1);

		session.save(cart);

		return cart;
	}
	@Override
	public boolean deleteFromCart(final String username) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		boolean result = true;
		cr = cr.add(Restrictions.eq("userId", username));
		List<Cart> productList = cr.list();
		for (Cart product : productList) {
			session.delete(product);
		}
		return result;

	}
	@Override
	public int saveOrder(String id, Order order) {
		Session session = this.sessionFactory.getCurrentSession();
		session.createCriteria(getModelClass());
		Order ord = new Order();
		ord.setUserId(id);
		ord.setDop(new Date());
		ord.setCardNumber(order.getCardNumber());
		ord.setCvv(order.getCvv());
		ord.setAmount(order.getAmount());
		session.save(ord);
		System.out.println("getting order id" + ord.getOrderId());
		return ord.getOrderId();

	}

	@Override
	public void saveCart(List<Cart> cart, int orderId) {
		Session session = this.sessionFactory.getCurrentSession();
		session.createCriteria(getModelClass());
		OrderDetail ordet = null;
		for (Cart cartObj : cart) {

			ordet = new OrderDetail();

			ordet.setOrderId(orderId);
			ordet.setPname(cartObj.getPname());
			ordet.setPrice(cartObj.getPrice());
			ordet.setQuantity(1);
			System.out.println("saving order" + ordet.toString());
			session.save(ordet);
		}

	}

	@Override
	public Iterable<Order> getAllOrder(final String id) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		cr = cr.add(Restrictions.eq("userId", id));
		List<Order> orderList = cr.list();
		return orderList;
	}

	@Override
	public Iterable<OrderDetail> getOrderDetail(final int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(OrderDetail.class);
		cr = cr.add(Restrictions.eq("orderId", id));
		List<OrderDetail> orderList = cr.list();
		System.out.println("in order List" + orderList.toString());
		return orderList;
	}

}
