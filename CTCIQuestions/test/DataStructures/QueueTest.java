package DataStructures; 

import org.junit.*;
import static org.junit.Assert.*;

public class QueueTest{

	Queue<Integer> queue;

	@BeforeClass
	public static void initialSetUp(){
	}

	@AfterClass
	public static void finalTearDown(){
	}
	
	@Before
	public void setUp(){
		queue = new Queue<Integer>();	
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testInitialize(){
		assertNotNull(queue);
		assertTrue(queue.empty());
		assertNull(queue.peek());
		assertNull(queue.remove());
	}

	@Test
	public void testPushAndPopFromNull(){
		assertTrue(queue.empty());
		
		Integer expected = new Integer(5);
		queue.add(expected);
		
		assertFalse(queue.empty());
		assertEquals(1, queue.size());
		assertEquals(expected,queue.peek());
		assertEquals(expected,queue.remove());
		
		assertTrue(queue.empty());

	}
	
	@Test
	public void testPushAndPopAfterOneElement(){
		Integer five = new Integer(5);
		Integer eight = new Integer(8);
		
		queue.add(five);
		queue.add(eight);
		
		assertFalse(queue.empty());
		assertEquals(2, queue.size());
		assertEquals(five, queue.peek());
		assertEquals(five, queue.remove());
		
		assertEquals(1, queue.size());
		assertEquals(eight,queue.peek());
		assertEquals(eight, queue.remove());

		assertEquals(0, queue.size());
		assertTrue(queue.empty());

	}


}
