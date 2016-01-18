package Chapter16;

import org.junit.*;

import DataStructures.AssortedMethods;

import static org.junit.Assert.*;

import java.util.Map;

public class Question2Test{
	
	Question2 q2;
	String book;
	@Before
	public void setUp(){
		q2 = new Question2();
		book = AssortedMethods.getLongTextBlob();
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testGetWordFrequencies(){
		Map<String, Integer> freqs = q2.getWordFrequencies(book);
		Integer one = new Integer(1);
		Integer eighteen = new Integer(18);
		
		assertEquals(one, freqs.get("outcropping"));
		assertEquals(one, freqs.get("rounded"));
		assertEquals(one, freqs.get("limestone"));
		
		assertEquals(eighteen, freqs.get("the"));
	}
}
