import org.junit.Test;
import static org.junit.Assert.*;

public class ConcordanceTest {

	@Test
	public void positive() {

		Concordance object = new Concordance();

		String expected = "{r=[7],d=[9],e=[1],W=[5],H=[0],l=[2, 3, 8],o=[4, 6]}";
		String array[] = { "Hello", "World" };
		assertEquals(expected, object.printConcordance(array));

	}

	@Test
	public void negative() {

		Concordance object = new Concordance();

		String expected = "{r=[7],d=[9],e=[1],W=[5],H=[1],l=[8],o=[4, 6]}";
		String array[] = { "Hello", "World" };
		assertNotEquals(expected, object.printConcordance(array));

	}

}
