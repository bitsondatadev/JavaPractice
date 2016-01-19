package Chapter16;

import org.junit.*;

import Chapter8.Point;

import static org.junit.Assert.*;

public class Question3Test{
	
	Question3 q3;

	@Before
	public void setUp(){
		q3 = new Question3();
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testFindIntersection(){
		assertNull(q3.findIntersection(new Point(3,3), new Point(3,3), new Point(3,3), new Point(3,3)));
		assertEquals(new Point(3.0, 3.0), q3.findIntersection(new Point(1,1), new Point(3,3), new Point(3,3), new Point(5,5)));
		assertEquals(new Point(2.0, 2.0), q3.findIntersection(new Point(1,1), new Point(3,3), new Point(1,3), new Point(3,1)));
	}
}
