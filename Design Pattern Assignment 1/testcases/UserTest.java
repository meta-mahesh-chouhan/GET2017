package testcases;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Entity.EntityFactory;
import Entity.User;
import Enums.EntityName;
import Enums.UserStatus;
import Facade.UserFacade;
public class UserTest {
	
	@Test
	public void checkAuthorizationPass(){
		
		assertEquals(UserStatus.Authorized, UserFacade.getInstance().checkAuthorization("mahesh", "ezio"));
		
	}
	
	@Test
	public void checkAuthorizationFail(){
		
		assertEquals(UserStatus.Unauthorized, UserFacade.getInstance().checkAuthorization("mahesh", "sedfd"));
		
	}
	
	@Test
	public void addUser(){
		User user = (User) EntityFactory.getEntityFromFactory(EntityName.User);

		user.setUsername("sumit");
		user.setPassword("vyas");
		UserFacade.getInstance().addUser(user);
		assertEquals(UserStatus.Authorized,UserFacade.getInstance().checkAuthorization("sumit", "vyas"));
		
	}

}
