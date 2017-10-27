/**
 * @Date 02-October-2017
 * @author Rajat Jain
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.model.User;

/**
 * The Interface UserService.
 */
public interface UserService {
	
	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	Iterable<User> getAllUsers();
	
	/**
	 * Gets the user by id.
	 *
	 * @param id the id
	 * @return the user by id
	 */
	User getUserById(String id);
}
