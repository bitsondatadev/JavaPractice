package Chapter1;

import org.junit.*;

import static org.junit.Assert.*;

public class Question5Test{
	
	Question5 q5;

	@Before
	public void setUp(){
		q5 = new Question5();
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testIsOneAway(){
		assertFalse(q5.isOneAway(null, null));
		assertFalse(q5.isOneAway(null, ""));
		assertFalse(q5.isOneAway("", "ab"));
		assertFalse(q5.isOneAway("abcdefghijklmnopqrstuvwxyz", "aabbcdefghijklmnopqrstuvwxyz"));
		assertFalse(q5.isOneAway("aab", "aba"));

		assertTrue(q5.isOneAway("", "a"));
		assertTrue(q5.isOneAway("aa", "aa"));
		assertTrue(q5.isOneAway("aba", "aa"));
		assertTrue(q5.isOneAway("abb", "ab"));
		assertTrue(q5.isOneAway("bba", "ba"));
		assertTrue(q5.isOneAway("aa", "aba"));
		assertTrue(q5.isOneAway("ab", "abb"));
		assertTrue(q5.isOneAway("ba", "bba"));
		assertTrue(q5.isOneAway("abb", "aab"));
		assertTrue(q5.isOneAway("abcdefghijklmnopqrstuvwxyz", "aabcdefghijklmnopqrstuvwxyz"));
		assertTrue(q5.isOneAway("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz"));
	}
}
