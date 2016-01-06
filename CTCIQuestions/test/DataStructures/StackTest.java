package DataStructures; 

import org.junit.*;
import static org.junit.Assert.*;

public class StackTest{

	Stack<Integer> stack;

	@BeforeClass
	public static void initialSetUp(){
	}

	@AfterClass
	public static void finalTearDown(){
	}
	
	@Before
	public void setUp(){
		stack = new Stack<Integer>();	
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testInitialize(){
		assertNotNull(stack);
		assertTrue(stack.empty());
		assertNull(stack.peek());
		assertNull(stack.pop());
	}

	@Test
	public void testPushAndPopFromNull(){
		assertTrue(stack.empty());
		
		Integer expected = new Integer(5);
		stack.push(expected);
		
		assertFalse(stack.empty());
		assertEquals(1, stack.size());
		assertEquals(expected,stack.peek());
		assertEquals(expected,stack.pop());
		
		assertTrue(stack.empty());

	}
	
	@Test
	public void testPushAndPopAfterOneElement(){
		Integer five = new Integer(5);
		Integer eight = new Integer(8);
		
		stack.push(five);
		stack.push(eight);
		
		assertFalse(stack.empty());
		assertEquals(2, stack.size());
		assertEquals(eight,stack.peek());
		assertEquals(eight,stack.pop());
		
		assertEquals(1, stack.size());
		assertEquals(five,stack.peek());
		assertEquals(five,stack.pop());

		assertEquals(0, stack.size());
		assertTrue(stack.empty());

	}


}
