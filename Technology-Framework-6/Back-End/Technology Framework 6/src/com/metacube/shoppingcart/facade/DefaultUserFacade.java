/**
 * @Date 02-October-2017
 * @author Rajat Jain
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.model.User;
import com.metacube.shoppingcart.service.UserService;

/**
 * The Class DefaultUserFacade.
 */
@Component("userFacade")
public class DefaultUserFacade implements UserFacade {
	
	/** The user service. */
	@Autowired
	UserService userService;

	/**
	 * Instantiates a new default user facade.
	 */
	public DefaultUserFacade() {

	}

	/**
	 * Sets the user service.
	 *
	 * @param userService the new user service
	 */
	public void setUserService(final UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user service.
	 *
	 * @return the user service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Instantiates a new default user facade.
	 *
	 * @param userService the user service
	 */
	public DefaultUserFacade(UserService userService) {
		this.userService = userService;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.facade.UserFacade#getAllUsers()
	 */
	@Override
	public Iterable<UserDto> getAllUsers() {
		List<UserDto> userDtoList = new ArrayList<>();

		for (User user : userService.getAllUsers()) {
			userDtoList.add(modelToDto(user));
		}

		return userDtoList;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.facade.UserFacade#getUserById(java.lang.String)
	 */
	@Override
	public UserDto getUserById(final String id) {
		return modelToDto(userService.getUserById(id));
	}

	/**
	 * Dto to model.
	 *
	 * @param userDto the user dto
	 * @return the user
	 */
	protected User dtoToModel(UserDto userDto) {
		if (userDto == null) {
			return null;
		}
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());

		return user;
	}

	/**
	 * Model to dto.
	 *
	 * @param user the user
	 * @return the user dto
	 */
	protected UserDto modelToDto(User user) {
		if (user == null) {
			return null;
		}
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setPassword(user.getPassword());

		return userDto;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.facade.UserFacade#authenticate(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean authenticate(String username, String password) {
		return false;
	}
}
