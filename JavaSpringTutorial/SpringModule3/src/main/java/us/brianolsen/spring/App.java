package us.brianolsen.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.brianolsen.spring.model.Logger;
import us.brianolsen.spring.model.Logger2;
import us.brianolsen.spring.model.Logger3;

public class App {
	public static void main(String[] args) {
		ApplicationContext classPathContext = new ClassPathXmlApplicationContext("us/brianolsen/spring/beans.xml");

		testAutowiringByType(classPathContext);
		testAutowiringByName(classPathContext);
		testAutowiringByConstructor(classPathContext);

		System.out.println("-------------------CLOSE CONTEXTS-------------------");
		((ClassPathXmlApplicationContext) classPathContext).close();
	}

	public static void testAutowiringByType(ApplicationContext context) {
		beforeTest("testAutowiringByType");
		Logger logger = (Logger) context.getBean("logger");

		logger.writeFile("Hello there");
		logger.writeConsole("Hello Again");
	}

	public static void testAutowiringByName(ApplicationContext context) {
		beforeTest("testAutowiringByName");
		Logger2 logger2 = (Logger2) context.getBean("logger2");

		logger2.writeFile("Hello there");
		logger2.writeConsole("Hello Again");
	}
	
	public static void testAutowiringByConstructor(ApplicationContext context) {
		beforeTest("testAutowiringByConstructor");
		Logger3 logger3 = (Logger3) context.getBean("logger3");
		//constructor auto-wiring is detected byType

		logger3.writeFile("Hello there");
		logger3.writeConsole("Hello Again");
	}

	public static void beforeTest(String label) {
		System.out.print("---------------------");
		System.out.print(label);
		System.out.println("---------------------");
	}
}
