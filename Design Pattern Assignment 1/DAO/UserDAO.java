package DAO;

import Entity.User;

/**
 * Marker Interface for UserDAO
 * 
 * @author User19
 *
 */
public interface UserDAO extends BaseDAO<User> {

	public void addUser(User user);
}
