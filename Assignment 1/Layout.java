/**
 * Determines the layout
 * 
 * @author Mahesh Chouhan
 */
public class Layout {

	private int screenSize[][];

	void addLayoutComponent(Component comp) {
		/*
		 * Adds the component comp to the layout, associating it with the string
		 * specified by name
		 */
	}

	void minimumLayoutSize() {
		/*
		 * Calculates the minimum size dimensions, given the components it
		 * contain
		 */
	}

	void preferredLayoutSize() {
		// Calculates the preferred size dimensions, given the components it
		// contains
	}

	void removeLayoutComponent(Component comp) {
		// Removes the specified component from the layout
	}

	public void setStatusLabel() {
		// add labels on the buttons
	}

	public void prepareGUI() {
		// add labels on the buttons
	}

	public void setScreenSize() {
		// int screen[][] that contain a 2D screen area
		screenSize = new int[5][5]; // setscreen size for calculator
	}
}
