package Chapter16;

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
	public void testSwapNumbers(){
		int a = 2;
		int b = 5;
		
		int[] ab = q1.swapNumbers(a, b);
		a = ab[0];
		b = ab[1];
		assertEquals(2, b);
		assertEquals(5, a);
		
		b = 2;
		a = 5;
		
		ab = q1.swapNumbers(a, b);
		a = ab[0];
		b = ab[1];
		assertEquals(2, a);
		assertEquals(5, b);
		
		a = -2;
		b = 2;
		
		ab = q1.swapNumbers(a, b);
		a = ab[0];
		b = ab[1];
		assertEquals(2, a);
		assertEquals(-2, b);
		
		b = -7;
		a = -2;
		
		ab = q1.swapNumbers(a, b);
		a = ab[0];
		b = ab[1];
		assertEquals(-7, a);
		assertEquals(-2, b);
		
	}
}
