import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {
	
	@Test
	public void positiveTestCase(){
		QuickSort object=new QuickSort();
		
		int input[]={2,5,8,9,10,77,55,11};
		object.quickSort(input, 0, input.length-1);
		
		int expected[]={2,5,8,9,10,11,55,77};
		assertArrayEquals(expected, input);
		
		
	}
	
	@Test
	public void negativeCase(){
		QuickSort object=new QuickSort();
		
		int input[]={};
		object.quickSort(input, 0, input.length-1);
		
		int expected[]={};
		assertArrayEquals(expected, input);
		
		
	}

}
