/**
 * Controls the functioning of calculator
 * 
 * @author Mahesh Chouhan
 *
 */
public class Calculator {
	private static double operand1;
	private static double operand2;
	private Operator operation;
	private static String fetchOperator;
	private static String fetchNewOperator;

	/**
	 * Gets input from user
	 * @param input
	 */
	public void getInput(String input) {
		//if fetchOperator is empty
		if(){
			//until operator is pressed insert value in operand1
			//if operator is pressed store its value in fetchOperator
		}
		
		//after storing operator, store next value in operand2
		//if equals or any other operator is pressed then store it in fetchNewOperator and call
		this.calculate();
		//handle exception if expression is invalid
	}

	public void calculate() {
		// check for fetchOperator and call appropriate method from operator class
		// store result in operand1
		this.setOutput();
		fetchOperator = fetchNewOperator;

	}

	public void setOutput() {
		new Display(this.operand1);
	}
}
