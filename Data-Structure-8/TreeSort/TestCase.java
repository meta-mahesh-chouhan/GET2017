import org.junit.Test;
import static org.junit.Assert.*;
public class TestCase {
	
	/**
	 * Sort unsorted student array - Pass
	 */
	@Test
	public void sortPass1(){
		Student[] array = { new Student(1005, "Mahesh"), new Student(1004, "Udit") , new Student(1001, "Prateek")};
		new SortDisorderly().sort(array);
		Student expected = new Student(1001, "Prateek");
		
		assertEquals(expected, array[0]);
		assertEquals(3, array.length);
	}
	
	/**
	 * Sort unsorted student array - Fail
	 */
	@Test
	public void sortFail1(){
		Student[] array = { new Student(1005, "Mahesh"), new Student(1004, "Udit") , new Student(1001, "Prateek")};
		new SortDisorderly().sort(array);
		Student expected = new Student(1005, "Mahesh");
		
		assertNotEquals(expected, array[0]);
		assertEquals(3, array.length);
	}
	
	/**
	 * Sort null array
	 */
	@Test(expected = NullPointerException.class)
	public void sortException1(){
		Student[] array = null ;
		new SortDisorderly().sort(array);
		
	}
	
	/**
	 * Sort array containing null student
	 */
	@Test(expected = NullPointerException.class)
	public void sortException2(){
		Student[] array = { new Student(1005, "Mahesh"), null, new Student(1001, "Prateek")};
		new SortDisorderly().sort(array);
		
	}
	
	/**
	 * Sort array containing null names - Pass
	 */
	@Test
	public void sortPass2(){
		Student[] array = { new Student(1005, "Mahesh"), new Student(1004, "Udit"), new Student(1001, null)};
		new SortDisorderly().sort(array);
		Student expected = new Student(1001, null);
		
		assertEquals(expected, array[0]);
	}
	
	/**
	 * Sort already sorted student array - Pass
	 */
	@Test
	public void sortPass3(){
		Student[] array = { new Student(1001, "Mahesh"), new Student(1002, "Udit"), new Student(1003, "Prateek")};
		new SortDisorderly().sort(array);
		Student expected = new Student(1001, "Mahesh");
		
		assertEquals(expected, array[0]);
	}
	
	/**
	 * Sort array containing student with null roll number
	 */
	@Test(expected = NullPointerException.class)
	public void sortException3(){
		Student[] array = { new Student(1005, "Mahesh"), new Student(1004, "Udit"), new Student( null, "Prateek")};
		new SortDisorderly().sort(array);
		
	}

	/**
	 * Sorting student array with no student objects
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void sortException4(){
		Student[] array = {};
		new SortDisorderly().sort(array);
		Student expected = new Student(1001, "Mahesh");
		
		assertEquals(expected, array[0]);
	}
	
	/**
	 * Array containing similar student objects - Pass
	 */
	@Test
	public void sortPass4(){
		Student[] array = { new Student(1001, "Mahesh"), new Student(1001, "Mahesh"), new Student(1001, "Mahesh")};
		new SortDisorderly().sort(array);
		Student expected = new Student(1001, "Mahesh");
		
		assertEquals(expected, array[0]);
		assertEquals(3, array.length);
	}
	
	/**
	 * Sort array containing null names - Fail
	 */
	@Test
	public void sortFail2(){
		Student[] array = { new Student(1005, "Mahesh"), new Student(1004, "Udit"), new Student(1001, null)};
		new SortDisorderly().sort(array);
		Student expected = new Student(1005, "Mahesh");
		
		assertNotEquals(expected, array[0]);
	}
	
	/**
	 * Sort already sorted student array - Fail
	 */
	@Test
	public void sortFail3(){
		Student[] array = { new Student(1001, "Mahesh"), new Student(1002, "Udit"), new Student(1003, "Prateek")};
		new SortDisorderly().sort(array);
		Student expected = new Student(1002, "Udit");
		
		assertNotEquals(expected, array[0]);
	}
	
	/**
	 * Array containing similar student objects - Fail
	 */
	@Test
	public void sortFail4(){
		Student[] array = { new Student(1001, "Mahesh"), new Student(1001, "Mahesh"), new Student(1001, "Mahesh")};
		new SortDisorderly().sort(array);
		Student expected = new Student(1002, "Udit");
		
		assertNotEquals(expected, array[0]);
		assertEquals(3, array.length);
	}
	
	

}
