/**
 * RemoveDuplicate Class
 * @author Mahesh Chouhan
 *
 */
public class RemoveDuplicate {
	/**
	 * removeDuplicate(int []) removes duplicates and gives an array with distinct elements.
	 * @param input
	 * @return 
	 */
	 int[] removeDuplicate(int input[]){

		 
		 for(int i=0;i<input.length;i++){
		
			 for(int j=i+1;j<input.length;j++){
				 
				 if(input[i]==input[j]){
					 //Replace duplicate elements with #
					 input[j]='#';
				
				 }
			 }
		 }
		 
		 
		 int temp[]=new int[input.length];
		 int j=0;
		 for(int i=0;i<input.length;i++){
			 if(input[i]!='#'){
				 //Copy index where value is not equal to #
				 temp[j++]=input[i];
			 }
		 }
		 
		 /**
		  * Create output array
		  */
		 int output[]=new int[j];
		 
		 for(int i=0;i<j;i++){
			 output[i]=temp[i];
		 }
	
		 return output;
	 }

}
