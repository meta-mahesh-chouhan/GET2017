import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
public class MergeTest {
	
	@Test
	public void testCase1(){
		
		Merge obj=new Merge();
		int[] a={1,2,3,3,4,5,5};
		int[] b={0,1,1,4,4,6,7};
		int[] c={};
		int[] expected= {0,1,1,1,2,3,3,4,4,4,5,5,6,7};
		int[] output=obj.join(a, a.length, b, b.length, c);
	
		assertArrayEquals(expected,output);
		
	}
	
	/**
	 * If one array is empty.
	 */
	@Test
	public void testCase2(){
		
		Merge obj=new Merge();
		int[] a={};
		int[] b={0,1,1,4,4,6,7};
		int[] c={};
		int[] expected= {0,1,1,4,4,6,7};
		int[] output=obj.join(a, a.length, b, b.length, c);

		assertArrayEquals(expected,output);
		
	}
	
	/**
	 * If both arrays are empty.
	 */
	@Test
	public void testCase3(){
		
		Merge obj=new Merge();
		int[] a={};
		int[] b={};
		int[] c={};
		int[] expected= {};
		int[] output=obj.join(a, a.length, b, b.length, c);
	
		assertArrayEquals(expected,output);
		
	}
	
	

}
