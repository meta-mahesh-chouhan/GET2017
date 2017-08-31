package UniqueCharacters;

import org.junit.Test;
import static org.junit.Assert.*;
public class UniqueCharactersTest {
	

	/**
	 * Test case for character string
	 */
	@Test
	public void putValueInCachePass(){
		
		UniqueCharacter object = new UniqueCharacter();
		
		int actual = object.getNumberOfUniqueCharacters("Rohit Jain");
		int expected = 8;
		assertEquals(expected, actual);
	}
	/**
	 * Test case for integer string
	 */
	@Test
	public void putValueInCachePass1(){
		
		UniqueCharacter object = new UniqueCharacter();
		
		int actual = object.getNumberOfUniqueCharacters("111222245523");
		int expected = 5;
		assertEquals(expected, actual);
	}
	
	/**
	 * Test case for character and integer string
	 */
	@Test
	public void putValueInCachePass2(){
		
		UniqueCharacter object = new UniqueCharacter();
		
		int actual = object.getNumberOfUniqueCharacters("111222aabbcdess245523");
		int expected = 11 ;
		assertEquals(expected, actual);
	}
	
	/**
	 * Test case for null
	 */
	@Test(expected = NullPointerException.class)
	public void putValueInCachePass3(){
		
		UniqueCharacter object = new UniqueCharacter();
		
		int actual = object.getNumberOfUniqueCharacters(null);
		int expected = 11 ;
		assertEquals(expected, actual);
	}
	
	/**
	 * Test case for null and characters string
	 */
	@Test
	public void putValueInCachePass4(){
		
		UniqueCharacter object = new UniqueCharacter();
		
		int actual = object.getNumberOfUniqueCharacters(null+"aabcd");
		int expected = 7 ;
		assertEquals(expected, actual);
	}
	
	/**
	 * Test case for empty string
	 */
	@Test
	public void putValueInCachePass5(){
		
		UniqueCharacter object = new UniqueCharacter();
		
		int actual = object.getNumberOfUniqueCharacters("");
		int expected = 0;
		assertEquals(expected, actual);
	}
	
	/**
	 * Test case for special character string
	 */
	@Test
	public void putValueInCachePass6(){
		
		UniqueCharacter object = new UniqueCharacter();
		
		int actual = object.getNumberOfUniqueCharacters("!@$#@@^$!^@$#^$!^&*&");
		int expected = 7 ;
		assertEquals(expected, actual);
	}
	
	
	/**
	 * Getting value from cache for character string
	 */
	@Test
	public void getValueFromCache(){
		
		UniqueCharacter object = new UniqueCharacter();
		
		object.getNumberOfUniqueCharacters("Rohit Jain");
		object.getNumberOfUniqueCharacters("Mahesh Chouhan");
		int actual = object.getNumberOfUniqueCharacters("Rohit Jain");
		int expected = 8;
		assertEquals(expected, actual);
	}

	/**
	 * Getting value from cache for integer string
	 */
	@Test
	public void getValueFromCache1(){
		
		UniqueCharacter object = new UniqueCharacter();
		
		object.getNumberOfUniqueCharacters("111222245523");
		object.getNumberOfUniqueCharacters("Mahesh Chouhan");
		int actual = object.getNumberOfUniqueCharacters("111222245523");
		int expected = 5 ;
		assertEquals(expected, actual);
	}

	/**
	 * Getting value from cache for character and integer string
	 */
	@Test
	public void getValueFromCache2(){
		
		UniqueCharacter object = new UniqueCharacter();
		
		object.getNumberOfUniqueCharacters("111222aabbcdess245523");
		object.getNumberOfUniqueCharacters("Rohit Jain");
		int actual = object.getNumberOfUniqueCharacters("111222aabbcdess245523");
		int expected = 11;
		assertEquals(expected, actual);
	}

	/**
	 * Getting value from cache for null
	 */
	@Test(expected = NullPointerException.class)
	public void getValueFromCache3(){
		
		UniqueCharacter object = new UniqueCharacter();
		
		object.getNumberOfUniqueCharacters(null);
		object.getNumberOfUniqueCharacters("Mahesh Chouhan");
		int actual = object.getNumberOfUniqueCharacters(null);
		int expected = 8;
		assertEquals(expected, actual);
	}

	/**
	 * Getting value from cache for special character string
	 */
	@Test
	public void getValueFromCache4(){
		
		UniqueCharacter object = new UniqueCharacter();
		
		object.getNumberOfUniqueCharacters("!@$#@@^$!^@$#^$!^&*&");
		object.getNumberOfUniqueCharacters("Mahesh Chouhan");
		int actual = object.getNumberOfUniqueCharacters("!@$#@@^$!^@$#^$!^&*&");
		int expected = 7;
		assertEquals(expected, actual);
	}

	/**
	 * Getting value from cache for empty string
	 */
	@Test
	public void getValueFromCache5(){
		
		UniqueCharacter object = new UniqueCharacter();
		
		object.getNumberOfUniqueCharacters("");
		object.getNumberOfUniqueCharacters("Mahesh Chouhan");
		int actual = object.getNumberOfUniqueCharacters("");
		int expected = 0 ;
		assertEquals(expected, actual);
	}
	
	/**
	 * Getting value from cache for null + character string
	 */
	@Test
	public void getValueFromCache6(){
		
		UniqueCharacter object = new UniqueCharacter();
		
		object.getNumberOfUniqueCharacters(null+"aabcd");
		object.getNumberOfUniqueCharacters("Mahesh Chouhan");
		int actual = object.getNumberOfUniqueCharacters(null+"aabcd");
		int expected = 7 ;
		assertEquals(expected, actual);
	}
}