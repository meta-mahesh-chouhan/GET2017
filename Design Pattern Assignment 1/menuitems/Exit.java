package menuitems;

import menu.Action;

public class Exit implements Action{

	@Override
	public void performAction() {
		System.out.print("\nSuccessfully Exit !");
		System.exit(0);
	}

	
}
