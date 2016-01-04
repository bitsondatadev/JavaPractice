package Chapter1;

import org.junit.*;
import static org.junit.Assert.*;

public class Question4Test{
	
	Question4 q4;

	@Before
	public void setUp(){
		q4 = new Question4();
	}

	@After
	public void tearDown(){

	}
	
	@Test
	public void testIsPalindromePermutation(){
		assertFalse(q4.isPalindromePermutation(null));
		assertFalse(q4.isPalindromePermutation(""));

		assertTrue(q4.isPalindromePermutation("aa"));
		assertTrue(q4.isPalindromePermutation("aba"));
		assertTrue(q4.isPalindromePermutation("a"));
		assertTrue(q4.isPalindromePermutation("aab"));
		assertTrue(q4.isPalindromePermutation("abb"));
		assertTrue(q4.isPalindromePermutation("apbocndmelzfkgjhiihjgkflemdncobpa"));
		
		assertFalse(q4.isPalindromePermutation("ab"));
		assertFalse(q4.isPalindromePermutation("abbc"));
		assertFalse(q4.isPalindromePermutation("boom"));
		assertFalse(q4.isPalindromePermutation("apbocndmelzfkgjhiihjgkflemdncobpba"));

	}
}
