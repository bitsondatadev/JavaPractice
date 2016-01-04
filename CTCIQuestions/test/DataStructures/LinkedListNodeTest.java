package DataStructures; 

import org.junit.*;
import static org.junit.Assert.*;

public class LinkedListNodeTest{
	
	LinkedListNode<Integer> node;

	@BeforeClass
	public static void initialSetUp(){
	}

	@AfterClass
	public static void finalTearDown(){
	}
	
	@Before
	public void setUp(){
		node = new LinkedListNode<Integer>(5);
	}

	@After
	public void tearDown(){
	}

	@Test
	public void testInitialize(){
		node = new LinkedListNode<Integer>(7);
		assertNotNull(node);
		assertEquals(new Integer(7), node.getData());
	}

	
	@Test
	public void testGetSetData(){
		node.setData(10);
		assertEquals(new Integer(10), node.getData());

		node.setData(100);
		assertEquals(new Integer(100), node.getData());

		node.setData(0);
		assertEquals(new Integer(0), node.getData());

		node.setData(-10);
		assertEquals(new Integer(-10), node.getData());

		node.setData(Integer.MAX_VALUE);
		assertEquals(new Integer(Integer.MAX_VALUE), node.getData());
	}

	@Test
	public void testGetSetNext(){
		LinkedListNode<Integer> nextNode = new LinkedListNode<Integer>(7);
		node.setNext(nextNode);
		assertNotNull(nextNode);
		assertEquals(new Integer(7), nextNode.getData());
		assertEquals(new Integer(5), node.getData());
		assertEquals(nextNode.getData(), node.getNext().getData());
		assertSame(nextNode, node.getNext());
	}

	@Test
	public void testGetSetPrev(){
		LinkedListNode<Integer> prevNode = new LinkedListNode<Integer>(7);
		node.setPrev(prevNode);
		assertNotNull(prevNode);
		assertEquals(new Integer(7), prevNode.getData());
		assertEquals(new Integer(5), node.getData());
		assertEquals(prevNode.getData(), node.getPrev().getData());
		assertSame(prevNode, node.getPrev());
	}
}
