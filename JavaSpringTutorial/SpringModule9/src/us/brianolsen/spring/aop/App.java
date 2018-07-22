package us.brianolsen.spring.aop;

import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.brianolsen.spring.aop.differentPackage.AnotherWildCardClass;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("us/brianolsen/spring/aop/beans.xml");
//		_testBasicAOP(context);
//
//		try {
//		_testVariousTypesOfAdvice(context);
//		} catch (Exception e) {
//			System.out.println("Encountered error: " + e.getMessage());
//		}
//		_testWildCardPointcuts(context);
		_testProxiesAndInterfaces(context);
//		_testVariousPointcutDesignators(context);
//		_testCominingPointcuts(context);
//		_testIntroductions(context);

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
	
	private static void _testCominingPointcuts(ApplicationContext context){
		_beforeTest("Test Combining Pointcuts");
		
		CombiningPointcutClass combiningPointcutClass = (CombiningPointcutClass) context.getBean("combiningPointcutClass");
		
		combiningPointcutClass.pointcutMethod();
		combiningPointcutClass.pointcutMethod(100l, 43.21);
	}
	
	private static void _testIntroductions(ApplicationContext context){
		_beforeTest("Test Introductions");
		
		IntroductionClass introductionClass = (IntroductionClass) context.getBean("introductionClass");
		introductionClass.pointcutMethod();
		
		//crazy because IntroductionClass doesn't implement IIntroductionMethodInterface but can call this due to @DeclareParents tag in Logger.
		((IIntroductionMethodInterface)introductionClass).introducedPointcutMethod();
	}
	
	
	private static void _beforeTest(String label) {
		System.out.print("---------------------");
		System.out.print(label);
		System.out.println("---------------------");
	}

}
