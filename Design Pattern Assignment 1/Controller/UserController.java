package Controller;

import Entity.User;
import Enums.UserStatus;
import Facade.UserFacade;

/**
 * Act as interface between View and Facade Layer.
 * 
 * @author User19
 *
 */
public class UserController {
	private static UserController userController;

	private UserController() {

	}

	/**
	 * Ensure only single instance of class is created
	 * 
	 * @return User Controller object
	 */
	public static UserController getInstance() {

		if (userController == null) {
			synchronized (UserController.class) {

				if (userController == null) {
					userController = new UserController();
				}

			}
		}

		return userController;
	}

	/**
	 * Check whether user is authorized or not.
	 * 
	 * @param username
	 * @param password
	 * @return true if user is authorized and false if it is not.
	 */
	public boolean checkAuthorization(String username, String password) {

		if (UserFacade.getInstance().checkAuthorization(username, password) == UserStatus.Authorized) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Add new user
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		UserFacade.getInstance().addUser(user);
	}

}
