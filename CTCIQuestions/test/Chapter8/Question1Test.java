package Chapter8;

import org.junit.*;
import static org.junit.Assert.*;

public class Question1Test{
	
	Question1 q1;

	@Before
	public void setUp(){
		q1 = new Question1();
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testComputeCount(){
		int expected = 274;
		assertEquals(expected, q1.computeCount());
		assertEquals(expected, q1.countWays(Question1.INIT_N));
		
		q1.setN(0);
		expected = 1;
		assertEquals(expected, q1.computeCount());
		assertEquals(expected, q1.countWays(0));
		
		q1.setN(1);
		expected = 1;
		assertEquals(expected, q1.computeCount());
		assertEquals(expected, q1.countWays(1));
		
		q1.setN(2);
		expected = 2;
		assertEquals(expected, q1.computeCount());
		assertEquals(expected, q1.countWays(2));
		
		q1.setN(3);
		expected = 4;
		assertEquals(expected, q1.computeCount());
		assertEquals(expected, q1.countWays(3));
		
		q1.setN(5);
		expected = 13;
		assertEquals(expected, q1.computeCount());
		assertEquals(expected, q1.countWays(5));
	}
}
