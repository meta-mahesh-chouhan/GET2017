	import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class ConverterTest {
	
	/**
	 * length of binary number is not a multiple of 3.
	 */
	 @Test
	  public void testCase1() {
	   Converter converter = new Converter();
	    int ans = converter.convertBinaryToOctal(11100101);
	    assertEquals(345, ans);
	  }
	 
	 @Test
	  public void testCase2() {
	   Converter converter = new Converter();
	    int ans = converter.convertBinaryToOctal(100100);
	    assertEquals(44, ans);
	  }
	 

}
