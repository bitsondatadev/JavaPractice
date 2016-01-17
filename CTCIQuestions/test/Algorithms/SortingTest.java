package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

public class SortingTest{

	List<CustomClass> arr;

	@Before
	public void setUp(){
		arr = new ArrayList<CustomClass>();

		arr.add(new CustomClass(4, "F", 11));
		arr.add(new CustomClass(5, "G", 6));
		arr.add(new CustomClass(10, "A", 10));
		arr.add(new CustomClass(3, "D", 7));
		arr.add(new CustomClass(1, "D", 8));
		arr.add(new CustomClass(6, "A", 8));
		arr.add(new CustomClass(6, "D", 3));
		arr.add(new CustomClass(1, "A", 5));
		arr.add(new CustomClass(4, "C", 2));
		arr.add(new CustomClass(5, "D", 3));
		arr.add(new CustomClass(9, "A", 4));
		arr.add(new CustomClass(2, "C", 1));
		arr.add(new CustomClass(1, "B", 9));
	}

	@After
	public void tearDown(){

	}
	
	@Test
	public void testInsertionSortCustomClass(){
		int expected = 1;
		
		//System.out.println("Before Sort: ");
		//System.out.println(arr);
		
		Sorting.insertionsort(arr);

		//System.out.println("After Sort: ");
		//System.out.println(arr);
		
		//Notice notId doesn't have to match
		assertEquals(expected, BinarySearch.binarySearch(arr, new CustomClass(1, "B", 122)));
		
		expected = 4;
		assertEquals(expected, BinarySearch.binarySearch(arr, new CustomClass(3, "D", 123)));
		
		expected = 7;
		assertEquals(expected, BinarySearch.binarySearch(arr, new CustomClass(5, "D", 99)));
		
		expected = 12;
		assertEquals(expected, BinarySearch.binarySearch(arr, new CustomClass(10, "A", 8675309)));
	}

	@Test
	public void testQuicksortCustomClass(){
		int expected = 1;
		
		//System.out.println("Before Sort: ");
		//System.out.println(arr);
		
		Sorting.quicksort(arr);

		//System.out.println("After Sort: ");
		//System.out.println(arr);
		
		//Notice notId doesn't have to match
		assertEquals(expected, BinarySearch.binarySearch(arr, new CustomClass(1, "B", 122)));
		
		expected = 4;
		assertEquals(expected, BinarySearch.binarySearch(arr, new CustomClass(3, "D", 123)));
		
		expected = 7;
		assertEquals(expected, BinarySearch.binarySearch(arr, new CustomClass(5, "D", 99)));
		
		expected = 12;
		assertEquals(expected, BinarySearch.binarySearch(arr, new CustomClass(10, "A", 8675309)));
	}
	
	@Test
	public void testMergesortCustomClass(){
		int expected = 1;
		
		//System.out.println("Before Sort: ");
		//System.out.println(arr);
		
		Sorting.mergesort(arr);

		//System.out.println("After Sort: ");
		//System.out.println(arr);
		
		//Notice notId doesn't have to match
		assertEquals(expected, BinarySearch.binarySearch(arr, new CustomClass(1, "B", 122)));
		
		expected = 4;
		assertEquals(expected, BinarySearch.binarySearch(arr, new CustomClass(3, "D", 123)));
		
		expected = 7;
		assertEquals(expected, BinarySearch.binarySearch(arr, new CustomClass(5, "D", 99)));
		
		expected = 12;
		assertEquals(expected, BinarySearch.binarySearch(arr, new CustomClass(10, "A", 8675309)));
	}
}
