package Algorithms;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

public class BinarySearchTest{
	List<Integer> arr;
	BinarySearch<Integer> bs;

	@Before
	public void setUp(){
		arr = new ArrayList<Integer>();
		bs = new BinarySearch<Integer>();
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testBinarySearch(){
		int expected = -1;
		assertEquals(expected, bs.binarySearch(arr, 1));
		assertEquals(expected, bs.binarySearchRecursive(arr, 1));
		assertEquals(expected, bs.binarySearch(null, 1));
		assertEquals(expected, bs.binarySearchRecursive(null, 1));
		
		for(expected = 0; expected < 10; expected++){
			arr.add(expected);
			assertEquals(expected, bs.binarySearch(arr, expected));
			assertEquals(expected, bs.binarySearchRecursive(arr, expected));
		}
	}
}
