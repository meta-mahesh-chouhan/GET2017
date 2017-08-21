package Facade;

import java.util.Iterator;

import DAO.BaseDAO;
import DAO.DAOFactory;
import DAO.InMemoryUserDAO;
import Entity.User;
import Enums.DBType;
import Enums.EntityName;
import Enums.UserStatus;
/**
 * Handles all calculations related to users.
 * @author Mahesh Chouhan
 *
 */
public class UserFacade {

	private static UserFacade userFacade;
	@SuppressWarnings("unchecked")
	private static BaseDAO<User> userDao = (BaseDAO<User>) DAOFactory.getDAOForEntity(EntityName.User, DBType.InMemory);
	
	private UserFacade(){
		
	}
	/**
	 * Ensure only single instance of class is created
	 * 
	 * @return UserFacade object
	 */
	public static UserFacade getInstance(){
		
		if ( userFacade == null){
			
			synchronized (UserFacade.class) {
				
				if ( userFacade == null){
					userFacade = new UserFacade();
				}
				
			}
		}
		return userFacade;
	}
	
	/**
	 * Check whether user is authorized or not.
	 * 
	 * @param username
	 * @param password
	 * @return Return UserStatus representing whether user is Authorized or not.
	 */
	public UserStatus checkAuthorization(String username, String password){
		
		Iterator<User> itr = userDao.getAll().iterator();
		User user;
		while ( itr.hasNext())
		{
			user = itr.next();
			if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)){
				return UserStatus.Authorized;
				
			}
			
		}
		
		return UserStatus.Unauthorized;

	}
	
	/**
	 * Add new user
	 * 
	 * @param user
	 */
	public void addUser(User user){
		
		InMemoryUserDAO userDao = (InMemoryUserDAO) DAOFactory.getDAOForEntity(EntityName.User, DBType.InMemory);
		userDao.addUser(user);
	}
	
}
