package Chapter2;

import DataStructures.*;

import org.junit.*;

import static org.junit.Assert.*;

public class Question3Test{
	LinkedList<Integer> list;	
	Question3 q3;

	@Before
	public void setUp(){
		q3 = new Question3();
		list = new LinkedList<Integer>();
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testRemoveDuplicates(){
		LinkedListNode<Integer> expected = list.getHead();
		LinkedList<Integer> expectedList = new LinkedList<Integer>();
		
		assertNull(expected);
		q3.deleteMiddleNode(expected);
		assertNull(expected);

		list.appendToTail(1);
		expected = list.getTail();

		list.appendToTail(2);
		list.appendToTail(3);

		expectedList.appendToTail(2);
		expectedList.appendToTail(3);
		
		assertFalse(expectedList.equals(list));
		
		//remove head of list works
		q3.deleteMiddleNode(expected);
		list.updateSize();
		
		assertTrue(expectedList.equals(list));
	
		list.appendToTail(4);
		expected = list.getTail();
		expectedList.appendToTail(4);
		
		//this delete shouldn't change anything since the next node is null
		q3.deleteMiddleNode(expected);
		//should still be true
		assertTrue(expectedList.equals(list));
		
		list.appendToTail(5);
		expected = list.getTail();
		
		list.appendToTail(6);
		list.appendToTail(7);
		expectedList.appendToTail(6);
		expectedList.appendToTail(7);
		
		assertFalse(expectedList.equals(list));
		
		q3.deleteMiddleNode(expected);
		list.updateSize();
		
		assertTrue(expectedList.equals(list));
		
	}

}
