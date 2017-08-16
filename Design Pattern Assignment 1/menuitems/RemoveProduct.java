package menuitems;

import View.Input;
import menu.Action;

public class RemoveProduct implements Action {

	@Override
	public void performAction() {
		Input.getInstance().removeProduct();
	}

}
