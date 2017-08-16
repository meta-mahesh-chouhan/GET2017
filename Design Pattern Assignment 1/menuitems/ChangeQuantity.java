package menuitems;

import View.Input;
import menu.Action;

public class ChangeQuantity implements Action{

	@Override
	public void performAction() {
		Input.getInstance().changeQuantity();
	}

}
