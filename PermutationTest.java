import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class PermutationTest {
	
	/*
	 * All letters are distinct
	 */
	@Test
	public void positiveTestCase1(){
		
		Permutation object=new Permutation();
		String input="ABC";
		List<String> actual=object.generatePermutations(input, 0, input.length()-1);
		
		List<String> expected=new ArrayList<String>();
		expected.add("ABC");
		expected.add("ACB");
		expected.add("BAC");
		expected.add("BCA");
		expected.add("CBA");
		expected.add("CAB");
		assertEquals(expected, actual);
	}
	
	/*
	 * Some letters are same
	 */
	@Test
	public void positiveTestCase2(){
		
		Permutation object=new Permutation();
		String input="AAB";
		List<String> actual=object.generatePermutations(input, 0, input.length()-1);
		
		List<String> expected=new ArrayList<String>();
		expected.add("AAB");
		expected.add("ABA");
		expected.add("BAA");

		assertEquals(expected, actual);
	}
	
	/*
	 * All letters are same
	 */
	@Test
	public void positiveTestCase3(){
		
		Permutation object=new Permutation();
		String input="AAAAAAA";
		List<String> actual=object.generatePermutations(input, 0, input.length()-1);
		
		List<String> expected=new ArrayList<String>();
		expected.add("AAAAAAA");
	

		assertEquals(expected, actual);
	}
	


}
