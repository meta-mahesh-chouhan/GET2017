package menu;
import java.util.ArrayList;
import java.util.List;

/**
 * Menu class contains a list of menu items and other sub menus.
 * @author Mahesh Chouhan
 *
 */
public class Menu extends MenuItem{
	
	private List<MenuItem> menu = new ArrayList<MenuItem>();

	public List<MenuItem> getSubMenu() {
		return menu;
	}

	public void setSubMenu(List<MenuItem> list) {
		this.menu= list;
	}
	
	/**
	 * Return MenuItem based on choice.
	 * @param choice
	 */
	public MenuItem getSelection(int choice){
		if(choice>=menu.size())return null;
		
		return menu.get(choice);
	}

	
}
