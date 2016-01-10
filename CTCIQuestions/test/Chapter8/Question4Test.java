package Chapter8;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

public class Question4Test{
	
	Question4 q4;
	List<Integer> set;
	int expected;

	@Before
	public void setUp(){
		q4 = new Question4();
		set = new ArrayList<Integer>();
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testGeneratePowerSetNull(){
		expected = 0;
		assertEquals(expected, q4.generatePowerSet(null).size());
	}
	
	@Test
	public void testGeneratePowerSet0(){
		List<ArrayList<Integer>> list;

		expected = (int) Math.pow(2.0, set.size());
		list = q4.generatePowerSet(set);
		assertEquals(expected, list.size());
		System.out.println(list);
	}
	
	@Test
	public void testGeneratePowerSet1(){
		List<Integer> set = new ArrayList<Integer>();
		List<ArrayList<Integer>> list;
		
		set.add(1);
		expected = (int) Math.pow(2.0, set.size());
		list = q4.generatePowerSet(set);
		assertEquals(expected, list.size());
		System.out.println(list);
	}
	
	@Test
	public void testGeneratePowerSet2(){
		List<Integer> set = new ArrayList<Integer>();
		List<ArrayList<Integer>> list;
		
		set.add(1);
		set.add(2);
		expected = (int) Math.pow(2.0, set.size());
		list = q4.generatePowerSet(set);
		assertEquals(expected, list.size());
		System.out.println(list);
	}
	@Test
	public void testGeneratePowerSet3(){
		List<Integer> set = new ArrayList<Integer>();
		List<ArrayList<Integer>> list;
		
		set.add(1);
		set.add(2);
		set.add(3);
		expected = (int) Math.pow(2.0, set.size());
		list = q4.generatePowerSet(set);
		assertEquals(expected, list.size());
		System.out.println(list);
	}
	
	
	

}
