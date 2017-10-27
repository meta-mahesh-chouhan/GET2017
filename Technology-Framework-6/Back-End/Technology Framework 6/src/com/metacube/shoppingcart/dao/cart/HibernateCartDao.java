/**
 * @Date 02-October-2017
 * @author Rajat Jain
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.dao.cart;

import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.HibernateDao;
import com.metacube.shoppingcart.model.Cart;

/**
 * The Class HibernateCartDao.
 */
@Repository("hibernateCartDao")
public class HibernateCartDao extends HibernateDao<Cart, String>
		implements
			CartDao {
	
	/**
	 * Instantiates a new hibernate cart dao.
	 */
	public HibernateCartDao() {
		super(Cart.class);
	}
}
