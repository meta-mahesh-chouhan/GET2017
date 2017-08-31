import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class for Binary Search class
 * 
 * @author Mahesh Chouhan
 *
 */
public class TestCases {

	/**
	 * Search element in integer array
	 */
	@Test
	public void searchElementPass1() {

		BinarySearch object = new BinarySearch();
		Integer array[] = { 1, 2, 3, 3, 4, 4, 5 };
		assertEquals(2, object.performBinarySearch(array, 3));

	}

	/**
	 * Search element in character array containing same elements
	 */
	@Test
	public void searchElementPass2() {

		BinarySearch object = new BinarySearch();
		Integer array[] = { 4,4,4,4,4,4 };
		assertEquals(0, object.performBinarySearch(array, 4));

	}
	
	/**
	 * search element with leftmost index in string array
	 */
	@Test
	public void searchElementPass3() {

		BinarySearch object = new BinarySearch();
		String array[] = {"mahesh","rahul","udit","rahul","rahul","gaurav","chetan","prateek"};
		assertEquals(1, object.performBinarySearch(array, "rahul"));

	}
	
	
	/**
	 * Search element in string array with same element multiple times
	 */
	@Test
	public void searchElementPass4() {

		BinarySearch object = new BinarySearch();
		String array[] = {"mahesh","mahesh","mahesh","mahesh","mahesh","mahesh"};
		assertEquals(0, object.performBinarySearch(array, "mahesh"));

	}
	
	/**
	 * Search element in the character array
	 */
	@Test
	public void searchElementPass5() {

		BinarySearch object = new BinarySearch();
		Character array[] = {'a','b','b','e','c','d','e','f','g','h','i'};
		assertEquals(3, object.performBinarySearch(array, 'e'));

	}
	
	/**
	 *  Search element in character array containing same elements
	 */
	@Test
	public void searchElementPass6() {

		BinarySearch object = new BinarySearch();
		Character array[] = {'a','a','a','a','a','a','a','a','a','a'};
		assertEquals(0, object.performBinarySearch(array, 'a'));

	}
	
	/**
	 * Search character in null array
	 */
	@Test(expected = NullPointerException.class)
	public void searchElementException1() {

		BinarySearch object = new BinarySearch();
		Character array[] = null;
		assertEquals(2, object.performBinarySearch(array, 'e'));

	}
	
	/**
	 * Search string in null array
	 */
	@Test(expected = NullPointerException.class)
	public void searchElementException7() {

		BinarySearch object = new BinarySearch();
		Character array[] = null;
		assertEquals(2, object.performBinarySearch(array, "mahesh"));

	}
	
	/**
	 * Search integer in null array
	 */
	@Test(expected = NullPointerException.class)
	public void searchElementException8() {

		BinarySearch object = new BinarySearch();
		Character array[] = null;
		assertEquals(2, object.performBinarySearch(array, 5));

	}
	
	/**
	 * Searching null in character array
	 */
	@Test(expected = NullPointerException.class)
	public void searchElementException2() {

		BinarySearch object = new BinarySearch();
		Character array[] = {'a','b','e','c','d','e','f','g','h','i'};
		assertEquals(2, object.performBinarySearch(array, null ));

	}
	
	
	/**
	 * Searching element in character array with null values
	 */
	@Test(expected = NullPointerException.class)
	public void searchElementException3() {

		BinarySearch object = new BinarySearch();
		Character array[] = {null,'b','e','c',null,'e','f',null,'h','i'};
		assertEquals(2, object.performBinarySearch(array,'e' ));

	}
	
	/**
	 * Searching integer element in character array
	 */
	@Test(expected = ClassCastException.class)
	public void searchElementException4() {

		BinarySearch object = new BinarySearch();
		Character array[] = {'a','b','e','c','d','e','f','g','h','i'};
		assertEquals(2, object.performBinarySearch(array,3 ));

	}
	
	/**
	 * Searching character element in integer array
	 */
	@Test(expected = ClassCastException.class)
	public void searchElementException5() {

		BinarySearch object = new BinarySearch();
		Integer array[] = { 1, 2, 3, 3, 4, 4, 5 };
		assertEquals(2, object.performBinarySearch(array, 'a'));

	}
	
	/**
	 * Searching character element in string array
	 */
	@Test(expected = ClassCastException.class)
	public void searchElementException6() {

		BinarySearch object = new BinarySearch();
		String array[] = {"mahesh","mahesh","mahesh","mahesh","mahesh","mahesh"};
		assertEquals(0, object.performBinarySearch(array, 'a'));

	}
	
	/**
	 * Search element in integer array - Fail
	 */
	@Test
	public void searchElementFail1() {

		BinarySearch object = new BinarySearch();
		Integer array[] = { 1, 2, 3, 3, 4, 4, 5 };
		assertEquals(-1, object.performBinarySearch(array, 8));

	}
	
	/**
	 * Search element in string array - Fail
	 */
	@Test
	public void searchElementFail2() {

		BinarySearch object = new BinarySearch();
		String array[] = {"mahesh","rahul","udit","rahul","rahul","gaurav","chetan","prateek"};
		assertEquals(-1, object.performBinarySearch(array, "akshay"));


	}
	
	/**
	 * Search element in character array - Fail 
	 */
	@Test
	public void searchElementFail3() {

		BinarySearch object = new BinarySearch();
		Character array[] = {'a','b','b','e','c','d','e','f','g','h','i'};
		assertEquals(-1, object.performBinarySearch(array, 'z'));

	}
	

	/**
	 * Search null element in null array
	 */
	@Test(expected = NullPointerException.class)
	public void searchElementFail5() {

		BinarySearch object = new BinarySearch();
		Integer array[] = null ;
		assertEquals(-1, object.performBinarySearch(array, null));

	}
	
	/**
	 * Search character element in empty character array
	 */
	@Test
	public void searchElementFail4() {

		BinarySearch object = new BinarySearch();
		Character array[] = {};
		assertEquals(-1, object.performBinarySearch(array, 'a'));

	}

	/**
	 * Search character element in unsorted character array
	 */
	@Test
	public void searchElementUnsorted1() {

		BinarySearch object = new BinarySearch();
		Character array[] = {'q','z','d','e','a','z','p','u','z'};
		assertEquals(1, object.performBinarySearch(array, 'z'));
	}
	
	/**
	 * Search integer element in unsorted integer array
	 */
	@Test
	public void searchElementUnsorted2() {

		BinarySearch object = new BinarySearch();
		Integer array[] = { 1, 2, 4, 4, 3, 3, 5 };
		assertEquals(4, object.performBinarySearch(array, 3));
	}
	
	/**
	 * Search string element in unsorted string array
	 */
	@Test
	public void searchElementUnsorted3() {

		BinarySearch object = new BinarySearch();
		String array[] = { "chetan" , "dharmesh" , "Eti" , "Gaurav" , "amish" , "bhawesh" ,};
		assertEquals(4, object.performBinarySearch(array, "amish"));
	}
	
	
	/**
	 * Search element in user defined class integer
	 */
	@Test
	public void searchElementPass7() {

		BinarySearch object = new BinarySearch();
		

		Employee array[] = { new Employee(1004, "Mahesh", "Pratap Nagar"), new Employee(1002, "Udit", "Pratap Nagar"),new Employee(1003, "Lokesh", "University Road"),new Employee(1001, "Yogender", "Badi Peepli") };
		Employee searchElement = new Employee(1002, "Udit", "Pratap Nagar");
		assertEquals(1, object.performBinarySearch(array, searchElement));
	}
	
	/**
	 * Search element in user defined class integer
	 */
	@Test
	public void searchElementPass8() {

		BinarySearch object = new BinarySearch();
		

		Employee array[] = { new Employee(1004, "Mahesh", "Pratap Nagar"), new Employee(1004, "Mahesh", "Pratap Nagar") , new Employee(1004, "Mahesh", "Pratap Nagar") , new Employee(1004, "Mahesh", "Pratap Nagar") };
		Employee searchElement = new Employee(1004, "Mahesh", "Pratap Nagar");
		assertEquals(0, object.performBinarySearch(array, searchElement));
	}

}
