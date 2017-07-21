/**
 * Button class decides the layout and position to place the button.
 * 
 * @author Mahesh Chouhan
 *
 */
public class Button {

	protected int height, width;
	protected int row_index, column_index;
	private String value;

	/**
	 * Getter to get value of variable value.
	 * 
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Setter to set value of variable value.
	 * 
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * To set the position of button.
	 */
	public void setButtonPosition(int height, int width) {
		// this will set height and width of a button
		height = this.height;
		width = this.width;
	}

	/**
	 * Decides the layout of button.
	 * 
	 * @param row_index
	 * @param column_index
	 * @param height
	 * @param width
	 */
	public void setButtonLayout(int row_index, int column_index) {
		// to set position such as row and column for a particular button
		this.column_index = column_index;
		this.row_index = row_index;
	}

	/**
	 * Decides the actions to be performed on the events or click of a button.
	 */
	public void onClick() {
		// this will help to perform operations on buttons such as onclick event
		Calculator calculator = new Calculator();
		calculator.getInput(this.getValue());
	}

}
