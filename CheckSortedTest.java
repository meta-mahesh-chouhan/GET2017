import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CheckSortedTest {
	@Test
	public void testCase1(){
		CheckSorted object=new CheckSorted();
		int input[]={1,3,4,7,8,10};
	    assertEquals("Array is in ascending order",object.message(input));
		
	}
	
	@Test
	public void testCase2(){
		CheckSorted object=new CheckSorted();
		int input[]={5,4,3,1,0};
	    assertEquals("Array is in descending order",object.message(input));
		
	}

	@Test
	public void testCase3(){
		CheckSorted object=new CheckSorted();
		int input[]={1,4,6,8,0};
	    assertEquals("Unsorted Array",object.message(input));
		
	}
}
