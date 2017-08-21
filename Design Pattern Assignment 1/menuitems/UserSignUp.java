package menuitems;

import View.Input;
import menu.Action;

public class UserSignUp implements Action {

	@Override
	public void performAction() {
		Input.getInstance().addUser();
	}

}
