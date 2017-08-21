package DAO;

import java.util.ArrayList;
import java.util.List;

import Entity.User;

/**
 * Data Acces Object to handle list of users in memory.
 * 
 * @author Mahesh Chouhan
 *
 */
public class InMemoryUserDAO implements UserDAO {

	private static InMemoryUserDAO inMemoryUserDao;
	private List<User> listOfUsers;

	private InMemoryUserDAO() {

		listOfUsers = new ArrayList<User>();

		listOfUsers.add(new User("mahesh", "ezio"));
		listOfUsers.add(new User("akshay", "joker"));
		listOfUsers.add(new User("abhishek", "bro"));

	}

	/**
	 * Ensure only single instance of class is created
	 * 
	 * @return InMemoryUserDAO  object
	 */
	public static InMemoryUserDAO getInstance() {

		if (inMemoryUserDao == null) {
			synchronized (InMemoryUserDAO.class) {

				if (inMemoryUserDao == null) {
					inMemoryUserDao = new InMemoryUserDAO();
				}

			}

		}
		return inMemoryUserDao;
	}

	@Override
	public void create(User t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAll() {
		return listOfUsers;
	}

	/**
	 * Add new user to list of users in memory.
	 */
	@Override
	public void addUser(User user) {
		listOfUsers.add(user);
	}

}
