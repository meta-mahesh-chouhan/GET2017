package menuitems;

import menu.Action;
import View.Input;

public class UserLogin implements Action {

	@Override
	public void performAction() {
		Input.getInstance().inputLoginDetails();
	}

}
