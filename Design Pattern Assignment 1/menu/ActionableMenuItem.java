package menu;
/**
 * ActionMenuItem class sets action for particular ActionableMenuItem.
 * 
 * @author Mahesh Chouhan
 *
 */
public class ActionableMenuItem extends MenuItem{
	
	Action action;

	/**
	 * Performs the action corresponding to Action object.
	 */
	public void triggerAction() {
		this.action.performAction();
	}
	

	/**
	 * Sets the action to be performed.
	 * @param action
	 */
	public ActionableMenuItem(Action action) {
		
		this.action = action;
	}


}
