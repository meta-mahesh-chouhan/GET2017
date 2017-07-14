/**
 * Converter class
 * 
 * @author Mahesh Chouhan
 * @version 1.0
 *
 */
public class Converter {
	
	/**
	 * checkBinary(int) checks if the given number is binary or not.
	 * @param n
	 * @return flag
	 */
	
	boolean checkBinary(int n){

		boolean flag=true;
		
		while(n>1){
			//Check if each digit is either 0 or 1.
			if(n%10>1){
				flag=false ;
			    break;	
		     }
			n=n/10;
		}
		return flag;
	}
	
	/**
	 * convertBinaryToOctal(int) converts given binary number to octal.
	 * 
	 * @param n
	 * 
	 */
	int convertBinaryToOctal(int n){
		
		
		String result="";
	
		if(!checkBinary(n)){
			//if given number is not binary , display a message to console and terminate.
			System.out.println("Not a binary number");
			System.exit(0);
		}
		
		
		
		while(n>1){
			
			switch(n%1000){
			
			case 0:result="0"+result;
					break;

			case 1:result="1"+result;
					break;

			case 10:result="2"+result;
					break;
			case 11:result="3"+result;
			         break;
			case 100:result="4"+result;
			         break;

			case 101:result="5"+result;
					break;

			case 110:result="6"+result;
					break;

			case 111:result="7"+result;
					break;
					
			}
			
			n=n/1000;
			
			}
			
		
		//Return the integer value parsed from string.
		return Integer.parseInt(result); 

	}

}
