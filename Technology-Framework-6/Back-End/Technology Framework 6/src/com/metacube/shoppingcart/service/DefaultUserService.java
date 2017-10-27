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

import com.metacube.shoppingcart.dao.user.UserDao;
import com.metacube.shoppingcart.model.User;

/**
 * The Class DefaultUserService.
 */
@Service("userService")
@Transactional
public class DefaultUserService implements UserService {
	
	/** The user dao. */
	@Resource(name = "hibernateUserDao")
	UserDao userDao;

	/**
	 * Gets the user dao.
	 *
	 * @return the user dao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * Sets the user dao.
	 *
	 * @param userDao the new user dao
	 */
	public void setUserDao(final UserDao userDao) {
		this.userDao = userDao;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.service.UserService#getAllUsers()
	 */
	@Override
	public Iterable<User> getAllUsers() {
		return userDao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.service.UserService#getUserById(java.lang.String)
	 */
	@Override
	public User getUserById(final String id) {
		return userDao.getOne(id);
	}
}
