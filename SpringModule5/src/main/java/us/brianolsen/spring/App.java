package us.brianolsen.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.brianolsen.spring.model.Robot;


/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		ApplicationContext classPathContext = new ClassPathXmlApplicationContext("us/brianolsen/spring/beans.xml");

		testSPEL(classPathContext);
		
		System.out.println("-------------------CLOSE CONTEXTS-------------------");
		((ClassPathXmlApplicationContext) classPathContext).close();
	}
	public static void testSPEL(ApplicationContext context) {
		beforeTest("testSPEL");
		Robot robot = (Robot)context.getBean("robot");
		robot.speak();
	}


	public static void beforeTest(String label) {
		System.out.print("---------------------");
		System.out.print(label);
		System.out.println("---------------------");
	}
}
