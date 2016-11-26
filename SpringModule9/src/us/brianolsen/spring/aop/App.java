package us.brianolsen.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.brianolsen.spring.aop.differentPackage.AnotherWildCardClass;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("us/brianolsen/spring/aop/beans.xml");
		_testBasicAOP(context);

		try {
		_testVariousTypesOfAdvice(context);
		} catch (Exception e) {
			System.out.println("Encountered error: " + e.getMessage());
		}
		_testWildCardPointcuts(context);
		_testProxiesAndInterfaces(context);
		_testVariousPointcutDesignators(context);

		context.close();

	}
	
	private static void _testBasicAOP(ApplicationContext context){
		_beforeTest("Test Basic AOP");
		BasicAOPClass basicAOPClass = (BasicAOPClass) context.getBean("basicAOPClass");
		basicAOPClass.pointcutMethod();
	}
	
	private static void _testVariousTypesOfAdvice(ApplicationContext context) throws Exception{
		_beforeTest("Test Various Types Of Advice");
		
		DifferentAdviceClass differentAdviceClass = (DifferentAdviceClass) context.getBean("differentAdviceClass");
		differentAdviceClass.pointcutMethod();
		
		System.out.println("###################About to throw error###################");
		System.out.println();
		boolean throwException = true;
		differentAdviceClass.pointcutMethod(throwException);
	}
	
	private static void _testWildCardPointcuts(ApplicationContext context){
		_beforeTest("Test WildCard Pointcuts");
		
		WildCardClass wildCardClass = (WildCardClass) context.getBean("wildCardClass");
		AnotherWildCardClass anotherWildCardClass = (AnotherWildCardClass) context.getBean("anotherWildCardClass");
		
		wildCardClass.pointcutMethod();
		wildCardClass.pointcutMethod(1000);
		wildCardClass.pointcutMethod("Prague Castle");
		wildCardClass.anotherPointcutMethod();
		
		anotherWildCardClass.pointcutMethod(5);
	}
	
	private static void _testProxiesAndInterfaces(ApplicationContext context){
		_beforeTest("Test Proxies and Interfacess");
		DifferentAdviceClass camera = (DifferentAdviceClass) context.getBean("differentAdviceClass");
		
		System.out.println("Class of camera bean: " + camera.getClass());
		System.out.println(camera instanceof DifferentAdviceClass);
		camera.pointcutMethod();
	}
	
	private static void _testVariousPointcutDesignators(ApplicationContext context){
		_beforeTest("Test Various Pointcut Designators");
		
		PointcutDesignatorClass pointcutDesignatorClass = (PointcutDesignatorClass) context.getBean("pointcutDesignatorClass");
		DeprecatedClass deprecatedClass = (DeprecatedClass) context.getBean("deprecatedClass");
		
		pointcutDesignatorClass.pointcutMethod();
		pointcutDesignatorClass.pointcutMethod(100);
		pointcutDesignatorClass.pointcutMethod(44.43);
		pointcutDesignatorClass.pointcutMethod(100l, 43.21);
		
		deprecatedClass.pointcutMethod();
		pointcutDesignatorClass.pointcutMethod(pointcutDesignatorClass);
	}
	
	
	private static void _beforeTest(String label) {
		System.out.print("---------------------");
		System.out.print(label);
		System.out.println("---------------------");
	}

}
