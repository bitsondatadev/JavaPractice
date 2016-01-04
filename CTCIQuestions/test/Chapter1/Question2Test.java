package Chapter1;

import org.junit.*;
import static org.junit.Assert.*;

public class Question2Test{
	
	Question2 q2;

	@Before
	public void setUp(){
		q2 = new Question2();
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testIsPermutation(){
		assertFalse(q2.isPermutation(null, null));
		assertFalse(q2.isPermutation("test", null));
		assertFalse(q2.isPermutation(null, "test"));

		assertTrue(q2.isPermutation("",""));
		assertTrue(q2.isPermutation("test","estt"));
		assertTrue(q2.isPermutation("aaaabbbb","bbbbaaaa"));
		assertTrue(q2.isPermutation("abcdefghijk","gakcdejfihb"));

		assertFalse(q2.isPermutation(""," "));
		assertFalse(q2.isPermutation("test","est"));
		assertFalse(q2.isPermutation("aaaabbbb","bbbbcaaaa"));
		assertFalse(q2.isPermutation("abcdefghijk","gakdejfihb"));
	}
}
