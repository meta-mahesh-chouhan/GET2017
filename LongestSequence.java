/**
 * LongestSequnce Class
 * 
 * @author Mahesh Chouhan
 *
 */
public class LongestSequence {
	/**
	 * getLS(int []) gives longest increasing sequence from input array.
	 * @param input
	 * @return
	 */
	 int[] getLS(int[] input){
		 /**
		  * start_index, end_index and length is used for each increasing sequence.
		  */
		int start_index=0;
		int end_index=0;
		int length=1;
		
		/**
		 * max_start , max_end and max_length is used for maximum increasing sequence.
		 */
		
		int max_length=1;
		int max_start=0;
		int max_end=0;
		
		for(int i=0;i<input.length-1;i++){
			if(input[i]<input[i+1]){
				//If next element is greater, increase end_index
				end_index++;
				length++;
			}
			else{
			   //If next element is not greater,change start_index and end_index to next elements location.
				if(length>max_length){
					//if length of current sequence is greater than max_length ,store it in max_length
					max_start=start_index;
					max_end=end_index;
				}
			start_index=i+1;
			end_index=start_index;
			length=0;
			}
			
		}
		if(length>max_length){
			max_start=start_index;
			max_end=end_index;
		}
		
		//Create new array to store maximum increasing sequence
		int[] res=new int[max_end-max_start+1];
		for(int i=max_start,k=0;i<=max_end;i++)
			res[k++]=input[i];
		
		
		return res;
	}


}
