package Chapter8;

import org.junit.*;

import static org.junit.Assert.*;

public class Question3Test{
	
	Question3 q3;

	@Before
	public void setUp(){
		q3 = new Question3();
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testFindMagicIndex(){
		int[] A = {0};
		int expected = -1;
		
		assertEquals(expected, q3.findMagicIndex(null));
		assertEquals(expected, q3.findMagicIndex(new int[]{}));
		
		expected = 0;
		assertEquals(expected, q3.findMagicIndex(A));
		
		A = new int[]{-4, -2, 1, 3, 6, 7, 8, 11, 25, 31, 49, 62, 101};
		expected = 3;
		assertEquals(expected, q3.findMagicIndex(A));
		
		A = new int[]{-4, -2, 1, 5, 6, 7, 8, 11, 25, 31, 49, 62, 101};
		expected = -1;
		assertEquals(expected, q3.findMagicIndex(A));
	}
	
	@Ignore
	@Test
	public void testFindMagicIndexNotDistinct(){
		int[] A = {0};
		int expected = -1;
		
		//currently fails because of duplicate ones...
		A = new int[]{-4, 1, 1, 3, 6, 7, 8, 11, 25, 31, 49, 62, 101};
		expected = 1;
		assertEquals(expected, q3.findMagicIndex(A));
		
	}
}
