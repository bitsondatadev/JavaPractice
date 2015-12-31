package DataStructures; 

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class HashTableTest{
	
	HashTable<Integer,Integer> hTable;

	@BeforeClass
	public static void initialSetUp(){
	}

	@AfterClass
	public static void finalTearDown(){
	}
	
	@Before
	public void setUp(){
		hTable = new HashTable<Integer, Integer>();		
	}

	@After
	public void tearDown(){
		
	}

	@Test
	public void testIsPrime(){
		//negative values aren't prime
		assertFalse(hTable.isPrime(-1000));

		assertFalse(hTable.isPrime(-2));
		
		assertFalse(hTable.isPrime(-1));
		
		//zero and one aren't prime
		assertFalse(hTable.isPrime(0));
		
		assertFalse(hTable.isPrime(1));
		
		//two and three are prime
		assertTrue(hTable.isPrime(2));
		
		assertTrue(hTable.isPrime(3));

		//even values arent prime
		assertFalse(hTable.isPrime(4));

		assertFalse(hTable.isPrime(10));
		
		assertFalse(hTable.isPrime(32));

		//odd values >=5 not divisable by lesser values are prime
		assertTrue(hTable.isPrime(5));

		assertTrue(hTable.isPrime(7));
		
		assertFalse(hTable.isPrime(9));

		assertTrue(hTable.isPrime(11));

		assertTrue(hTable.isPrime(13));

		assertFalse(hTable.isPrime(15));

		assertTrue(hTable.isPrime(701));

	}

	@Test
	public void testGetNextGreatestPrime(){
		int expected = 2;

		assertEquals(expected, hTable.getNextGreatestPrime(-100));
		assertEquals(expected, hTable.getNextGreatestPrime(-1));
		assertEquals(expected, hTable.getNextGreatestPrime(0));
		assertEquals(expected, hTable.getNextGreatestPrime(1));
		assertEquals(expected, hTable.getNextGreatestPrime(2));
		
		expected = 3;

		assertEquals(expected, hTable.getNextGreatestPrime(3));
		
		expected = 31;

		assertEquals(expected, hTable.getNextGreatestPrime(30));
		assertEquals(expected, hTable.getNextGreatestPrime(31));

		expected = 79;

		assertEquals(expected, hTable.getNextGreatestPrime(74));
		assertEquals(expected, hTable.getNextGreatestPrime(79));

		expected = 701;

		assertEquals(expected, hTable.getNextGreatestPrime(692));
		assertEquals(expected, hTable.getNextGreatestPrime(701));


	}

	@Test
	public void testPutAndRemove(){
		int expected = 0;
		int key = 0;


		assertEquals(expected, hTable.size());
		assertFalse(hTable.contains(key));
		
		expected = 1;
		hTable.put(key, expected);
		assertEquals(expected, hTable.size());
		assertEquals(expected, (int)hTable.get(key));
		assertTrue(hTable.contains(key));
		assertNull(hTable.get(1));

		key = 1;
		expected = 2;
		hTable.put(key, expected);
		assertEquals(expected, hTable.size());
		assertEquals(expected, (int)hTable.get(key));
		assertTrue(hTable.contains(key));
		assertNull(hTable.get(2));

		key = 0;
		expected = 1;
		hTable.remove(key);
		assertEquals(expected, hTable.size());
		assertNull(hTable.get(key));
		assertFalse(hTable.contains(key));

		key = 32;
		expected = 2;
		hTable.put(key, expected);
		assertEquals(expected, hTable.size());
		assertEquals(expected, (int)hTable.get(key));
		assertTrue(hTable.contains(key));
		hTable.remove(key);
	}

	@Test
	public void testCapacityResize(){
		int expected = hTable.INIT_TABLE_SIZE;
		assertEquals(expected, hTable.capacity());
		
		expected = hTable.getNextGreatestPrime(expected * 2);
		for(int i=0; i < (hTable.INIT_TABLE_SIZE + 5); i++){
			hTable.put(i,i);
		}
		assertEquals(expected, hTable.capacity());
	//	System.out.println(hTable.toString());
	}
}
