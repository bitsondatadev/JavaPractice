package Chapter3; 

import org.junit.*;
import static org.junit.Assert.*;

public class Question2Test{

	Question2<Integer> stack;

	@BeforeClass
	public static void initialSetUp(){
	}

	@AfterClass
	public static void finalTearDown(){
	}
	
	@Before
	public void setUp(){
		stack = new Question2<Integer>();	
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
		assertEquals(expected,stack.min());
		assertEquals(expected,stack.pop());
		
		assertTrue(stack.empty());

	}
	
	@Test
	public void testPushAndPopAfterOneElement(){
		Integer five = new Integer(5);
		Integer eight = new Integer(8);
		
		stack.push(five);
		assertEquals(five,stack.min());
		stack.push(eight);
		
		assertFalse(stack.empty());
		assertEquals(2, stack.size());
		assertEquals(eight,stack.peek());
		assertEquals(five,stack.min());
		assertEquals(eight,stack.pop());
		
		assertEquals(1, stack.size());
		assertEquals(five,stack.peek());
		assertEquals(five,stack.min());
		assertEquals(five,stack.pop());

		assertEquals(0, stack.size());
		assertTrue(stack.empty());

	}
	
	@Test
	public void testPushAndPopAfterTwoElements(){
		Integer eight = new Integer(8);
		Integer five = new Integer(5);
		Integer two = new Integer(2);
		Integer nine = new Integer(9);
		
		stack.push(eight);
		assertEquals(eight,stack.min());
		
		stack.push(five);
		
		assertFalse(stack.empty());
		assertEquals(2, stack.size());
		assertEquals(five,stack.peek());
		assertEquals(five,stack.min());
		
		stack.push(two);
		stack.push(nine);
		assertEquals(4, stack.size());
		assertEquals(nine,stack.peek());
		assertEquals(two,stack.min());
		
		assertEquals(nine,stack.pop());
		assertEquals(two,stack.pop());
		assertEquals(five,stack.min());
		assertEquals(five,stack.pop());
		
		assertEquals(1, stack.size());
		assertEquals(eight,stack.peek());
		assertEquals(eight,stack.min());
		assertEquals(eight,stack.pop());

		assertEquals(0, stack.size());
		assertTrue(stack.empty());

	}


}
