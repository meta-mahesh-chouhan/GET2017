/**
 * CheckSorted Class
 * @author Mahesh Chouhan
 *
 */
public class CheckSorted {
/**
 * checkSorted(int[]) checks whether given input array is sorted or not.
 * @param input
 * @return
 */
	public int checkSorted(int input[]){
		
		if(input[0]<input[1]){
			//Increasing order
			for(int i=0;i<input.length-1;i++){
				if(input[i]>input[i+1])
	               return 0;
	           
			}
			return 1;
		}
		else{
			//Decreasing order
			for(int i=0;i<input.length-1;i++){
				if(input[i]<input[i+1])
	               return 0;
	           
			}
			return 2;
			
		}
		
	}
	
	/**
	 * message(int []) displays string result based on return value from checkSorted() method.
	 * @param input
	 * @return 
	 */
	
	public String message (int[] input)
    {
        int flag = checkSorted(input);
        if(flag==1)
        {
            return "Array is in ascending order";
        }
        else if(flag==2)
        {
            return "Array is in descending order";
        }
        else 
        {
            return "Unsorted Array";
        }
        
    }
}
