/**
 * Handles Display of output.
 * 
 * @author Mahesh Chouhan
 *
 */
public class Display {
	private String outputString = "";
	
	public Display(String value){
		// check the value
		// append to previous value in outputString
			outputString += value;
		// until operator equals('=') is pressed 
			outputString = value;
		
	}
	
	public Display(Double value){
			outputString = value.toString();
	}
	
}
