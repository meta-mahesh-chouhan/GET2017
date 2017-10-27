/**
 * @Date 02-October-2017
 * @author Rajat Jain
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.dao.user;

import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.HibernateDao;
import com.metacube.shoppingcart.model.User;

/**
 * The Class HibernateUserDao.
 */
@Repository("hibernateUserDao")
public class HibernateUserDao extends HibernateDao<User, Integer>
implements
UserDao {
	
	/**
	 * Instantiates a new hibernate user dao.
	 */
	public HibernateUserDao() {
		super(User.class);
	}
}
