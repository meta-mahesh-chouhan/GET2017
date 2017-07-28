package menu;

/**
 * MenuItems can be Actionable MenuItems or another subMenu.
 * 
 * @author Mahesh Chouhan
 *
 */
public abstract class MenuItem {
	private String displayName;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	

}
