package DataStructures; 

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class LinkedListTest{

	LinkedList<Integer> list;

	@BeforeClass
	public static void initialSetUp(){
	}

	@AfterClass
	public static void finalTearDown(){
	}
	
	@Before
	public void setUp(){
		list = new LinkedList<Integer>();	
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testInitialize(){
		assertNotNull(list);
		assertNull(list.getHead());
		assertNull(list.getTail());
	}

	@Test
	public void testAppendFromNull(){
		Integer expected = new Integer(5);
		list.appendToTail(expected);
		assertEquals(expected,list.getHead().getData());
		assertNull(list.getHead().getNext());
		assertNull(list.getHead().getPrev());
	}

	@Test
	public void testAppendAfterOneElement(){
		Integer five = new Integer(5);
		Integer eight = new Integer(8);
		list.appendToTail(five);
		list.appendToTail(eight);

		assertEquals(eight, list.getHead().getNext().getData());
		assertEquals(eight, list.getTail().getData());
		//either getTail or get Prev is null assertEquals(five, list.getTail().getPrev().getData());
		assertEquals(five, list.getHead().getData());
	}
}
