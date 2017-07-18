/**
 * RecursionFirst contains methods for finding remainder, greatest common
 * divisor and largest digit.
 * 
 * @author Mahesh Chouhan
 *
 */
public class RecursionFirst {

	// Global variable for storing maximum Digit across recursive calls
	int maxDigit = 0;

	/**
	 * remainder function find remainder when x is divided by y.
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return remainder when firstNumber is divided by secondNumber.
	 */
	int remainder(int firstNumber, int secondNumber) {

		
		if (secondNumber == 0)
			return -1;

		//Base condition
		if (firstNumber < secondNumber)
			return firstNumber;

		//Recursive call
		return remainder(firstNumber - secondNumber, secondNumber);

	}

	/**
	 * gcd finds the greatest common divisor of two numbers.
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return gcd of firstNumber and secondNumber.
	 */
	int gcd(int firstNumber, int secondNumber) {

		// Base Condition
		if (secondNumber == 0)
			return firstNumber;

		//Recursive call
		return gcd(secondNumber, firstNumber % secondNumber);
	}

	/**
	 * Returns greatest digit present in number.
	 * 
	 * @param number
	 * @return greatest digit in number
	 */
	int largestdigit(int number) {

		// Base Condition
		if (number == 0)
			return maxDigit;

		//Check if last digit is greater than maximum digit
		if (number % 10 > maxDigit)
			maxDigit = number % 10;

		//Recursive call
		return largestdigit(number / 10);

	}

}
