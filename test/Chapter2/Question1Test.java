package Chapter2;

import DataStructures.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Question1Test{
	LinkedList<Integer> list;	
	Question1 q1;

	@Before
	public void setUp(){
		q1 = new Question1();
		list = new LinkedList<Integer>();
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testRemoveDuplicates(){
		LinkedListNode expected = list.getHead();
		assertNull(expected);
		assertEquals(expected, q1.removeDuplicates(list.getHead()));

		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);

		LinkedList<Integer> expectedList = new LinkedList<Integer>();

		expectedList.appendToTail(1);
		expectedList.appendToTail(2);
		expectedList.appendToTail(3);

		list.setHead(q1.removeDuplicates(list.getHead()));
		assertTrue(expectedList.equals(list));
	
		list.appendToTail(1);
		list.appendToTail(2);

		assertFalse(expectedList.equals(list));
		
		list.setHead(q1.removeDuplicates(list.getHead()));
		list.updateSize();
		assertTrue(expectedList.equals(list));
	}

}
