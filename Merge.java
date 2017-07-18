/**
 * Merge class
 * 
 * @author Mahesh Chouhan
 * @version 1.0
 *
 */

public class Merge {
	
	/**
	 * join(int [],int ,int [],int,int []) takes two sorted arrays and merges them to form a third sorted array.
	 * 
	 * @param a[]
	 * @param asize
	 * @param b[]
	 * @param bsize
	 * @param c[]
	 * @return c[]
	 */

	int [] join (int a[],int asize,int b[],int bsize,int c[]){
		/**
		 * c array size is sum of size of array a and b.
		 */
		c=new int[asize + bsize];
		int k=0;
		int i=0;int j=0;
		
		/**
		 * Coping elements from array a and b into c.
		 */
		while(i< asize && j< bsize){
			//Copy the smallest element into c
			if(a[i]<b[j]){
				c[k++]=a[i++];
			}
			else{
				c[k++]=b[j++];
			}
			
		}
		
		/**
		 * If all elements of a are not copied.
		 */
		while(i<asize){
		c[k++]=a[i++];
		}
		
		/**
		 * If all elements of b are not copied.
		 */
	
		while(j<bsize){
		c[k++]=b[j++];
		}
		
		for(int q=0;q<k;q++)
		System.out.println(c[q]);
		
		return c;
		
	}
	

}
