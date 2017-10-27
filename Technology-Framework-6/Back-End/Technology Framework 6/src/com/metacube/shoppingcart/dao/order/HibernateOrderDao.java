/**
 * @Date 02-October-2017
 * @author Rajat Jain
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.dao.order;

import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.HibernateDao;
import com.metacube.shoppingcart.model.Order;

/**
 * The Class HibernateOrderDao.
 */
@Repository("hibernateOrderDao")
public class HibernateOrderDao extends HibernateDao<Order, Integer>
implements
OrderDao {
	
	/**
	 * Instantiates a new hibernate order dao.
	 */
	public HibernateOrderDao() {
		super(Order.class);
	}
}
