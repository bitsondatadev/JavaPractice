package Chapter1;

import org.junit.*;

public class Question1Test{
	
	Question1 q1;

	@Before
	public void setUp(){
		q1 = new Question1();
	}

	@After
	public void tearDown(){

	}

	@Test
	public void test1(){
		System.out.println("test1");	
	}
}
