
public class FCFS {
	/**
	 * FCFS class uses First Come First Serve scheduling algorithm for job scheduling. 
	 * 
	 * @version 1.0
	 * @author Mahesh Chouhan
	 */

	
	
	/**
	 * getWaitingTime(int [],int []) takes two 1-d array of arrival time and job size.
	 * 
	 * @param arrival_time
	 * @param job_size
	 * @return output 2-D array
	 */
	public int[][] getWaitingTime(int[] arrival_time,int[] job_size){
		
		/**
		 * Output 2-D matrix 
		 */
		int [][] output=new int[arrival_time.length][5];
		
		
		/**
		 * output[][0] first column contains job number.
		 */
		for(int i=0;i<arrival_time.length;i++)
			output[i][0]=i+1;
		

		/**
		 * output[][1] second column contains job arrival time.
		 */
		for(int i=0;i<arrival_time.length;i++)
			output[i][1]=arrival_time[i];
		
		

		/**
		 * output[][3] forth column contains job start time.
		 */

		//Job start time of first job is same as job arrival time.
		output[0][3]=arrival_time[0];
		
		//Job start time for rest of the jobs.
		for(int i=1;i<arrival_time.length;i++){
			output[i][3]=Math.max(output[i-1][3]+job_size[i-1],arrival_time[i]);
			
		}
		
		

		/**
		 * output[][2] third column contains job wait time.
		 */
		for(int i=0;i<arrival_time.length;i++){
			//wait time=job start time - job arrival time 
			output[i][2]=output[i][3]-output[i][1];
		}
		
		

		/**
		 * output[][4] fifth column contains job finish time.
		 */
		for(int i=0;i<arrival_time.length;i++){
			//job finish time = job start time + job size -1;
			output[i][4]=output[i][3]+job_size[i]-1;
		}
	
		
		return output;
		
	}
	
}
