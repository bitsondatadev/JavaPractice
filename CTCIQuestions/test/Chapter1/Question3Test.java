package Chapter1;

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
	public void testURLify(){
		String expected;
		String testStr = "";

		assertNull(q3.URLify(null,1));
		assertNull(q3.URLify(testStr, 0));
		
		expected = "Middle%20Space";
		testStr  = "Middle Space  ";
		assertEquals(expected, q3.URLify(testStr, 12));

		expected = "%20Before_Space";
		testStr  = " Before_Space  ";
		assertEquals(expected, q3.URLify(testStr, 13));

		expected = "After_Space%20";
		testStr  = "After_Space   ";
		assertEquals(expected, q3.URLify(testStr, 12));

		expected = "This%20is%20the%20string%20to%20URLify!";
		testStr  = "This is the string to URLify!          ";
		assertEquals(expected, q3.URLify(testStr, 29));
	}
}
