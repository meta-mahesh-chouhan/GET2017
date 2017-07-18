import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;


public class RemoveDuplicateTest {


	 @Test
	  public void testCase1() {
	RemoveDuplicate rd=new RemoveDuplicate();
	int[] input= {2,5,4,6,3,8,5,9,3,3,6,3,9,0};
	int [] ans=rd.removeDuplicate(input);
	int[] expec={2,5,4,6,3,8,9,0};
	assertArrayEquals(expec,ans);
	  }
}
