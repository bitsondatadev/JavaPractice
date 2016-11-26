package us.brianolsen.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

	/*************************************
	 * POINTCUTS
	 *************************************
	 */
	
	//basic aop pointcut
	
	@Pointcut("execution(* us.brianolsen.spring.aop.BasicAOPClass.pointcutMethod(..))")
	public void executionBasicAOPClassPointcutMethodPointcut() {
	}

	// Specific Parameter and Return type pointcuts

	@Pointcut("execution(String us.brianolsen.spring.aop.DifferentAdviceClass.pointcutMethod(String))")
	public void executionDifferentAdviceClassPointcutMethodStringPointcut() {
	}

	@Pointcut("execution(void us.brianolsen.spring.aop.DifferentAdviceClass.pointcutMethod(int))")
	public void executionDifferentAdviceClassPointcutMethodIntPointcut() {
	}
	
	// Different Advice Pointcut
	
	@Pointcut("execution(* us.brianolsen.spring.aop.DifferentAdviceClass.pointcutMethod(..))")
	public void executionDifferentAdviceClassPointcutMethodPointcut() {
	}

	// Wildcards pointcut examples

	@Pointcut("execution(* us.brianolsen.spring.aop.DifferentAdviceClass.pointcutMethod(..))")
	public void executionWildCardClassPointcutMethodPointcut() {
	}
	
	@Pointcut("execution(* *.*(..))")
	public void executionAnyReturnTypesPackagesAndMethodsWithAnyParameterPointcut() {
	}
	
	// Pointcut designators examples
	
	@Pointcut("within(us.brianolsen.spring..*)")
	public void withinClassesUnderSpringPointcut() {
	}
	
	
	@Pointcut("within(@Deprecated us.brianolsen.spring..*)")
	public void withinDeprecatedClassesUnderSpringPointcut() {
	}

	
	@Pointcut("target(us.brianolsen.spring.aop.PointcutDesignatorClass)")
	public void targetPoincutDesignatorClassPointcut() {
	}
	
	//@Pointcut("within(@org.springframework.stereotype.Component us.brianolsen.spring..*)")
	@Pointcut("@target(org.springframework.stereotype.Component)")
	public void targetAllComponentTypesPointcut() {
	}
	
	@Pointcut("@annotation(java.lang.Deprecated)")
	public void annotationAllDeprecatedTypesPointcut() {
	}
	
	@Pointcut("@args(org.springframework.stereotype.Component)")
	public void argsAllComponentTypesPointcut() {
	}
	
	@Pointcut("this(us.brianolsen.spring.aop.PointcutDesignatorClass)")
	public void thisPoincutDesignatorClassPointcut() {
	}
	
	//@Pointcut("bean(*DesignatorClass)") //also works to match this bean
	@Pointcut("bean(pointcutDesignatorClass)")
	public void beanPoincutDesignatorClassPointcut() {
	}
	
	//@Pointcut("args()") match all methods with no arguments
	//@Pointcut("args(int)")
	//@Pointcut("args(long, double)")
	//@Pointcut("args(long, *)") //matches 2 argments where the first one is a long
	//@Pointcut("args(long, ..)") //matches 1 to infinite argments where the first one is a long
	//@Pointcut("args(.., double)") //matches 1 to infinite argments where the last one is a double. Also will match any type that can be autoboxed to it (like primitive int).
	@Pointcut("args(.., Double)") //matches 1 to infinite argments where the last one is a double. Also will match any type that can be autoboxed to it (but int will not).
	public void argsPoincutDesignatorClassPointcut() {
	}

	/*************************************
	 * ADVICE METHODS
	 *************************************
	 */

	@Before("executionBasicAOPClassPointcutMethodPointcut()")
	// @Before("execution(void us.brianolsen.spring.aop.Camera.snap())")
	// ^^^we can define pointcut designator if we define pointcut in
	public void executionBasicAOPClassPointcutMethodAdvice() {
		System.out.println("Before BasicAOPClass pointcut method Advice...");
	}

	// Different advice annotation examples

	@After("executionDifferentAdviceClassPointcutMethodPointcut()")
	public void executionCameraSnapMethodAfterAdvice() {
		System.out.println("After DifferentAdviceClass PointcutMethod...");
	}

	@AfterReturning("executionDifferentAdviceClassPointcutMethodPointcut()")
	public void executionCameraSnapMethodAfterReturningAdvice() {
		// verify that method hasn't thrown exception
		System.out.println("After Returning DifferentAdviceClass PointcutMethod...");
	}

	@AfterThrowing("executionDifferentAdviceClassPointcutMethodPointcut()")
	public void executionCameraSnapMethodAfterThrowingAdvice() {
		// verify that method has thrown exception
		System.out.println("After Throwing DifferentAdviceClass PointcutMethod...");
	}

	@Around("executionDifferentAdviceClassPointcutMethodPointcut()")
	public void executionCameraSnapMethodAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("Around DifferentAdviceClass PointcutMethod method (before)...");
		try {
			proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			System.out.println("In around advice: " + e.getMessage());
		}
		System.out.println("Around DifferentAdviceClass PointcutMethod method (after)...");
	}

	// Specific Parameter pointcuts

	@Before("executionDifferentAdviceClassPointcutMethodStringPointcut()")
	public void cameraSnapStringParameterAdvice() {
		System.out.println("Before DifferentAdviceClass PointcutMethod with string parameter...");
	}

	// Wildcard advice examples
	
	@Before("executionWildCardClassPointcutMethodPointcut()")
	public void executionWildCardClassPointcutMethodAdvice() {
		System.out.println("Before WildCard pointcut method Advice...");
	}

	@Before("executionAnyReturnTypesPackagesAndMethodsWithAnyParameterPointcut()")
	public void executionAnyReturnTypesPackagesAndMethodsWithAnyParameterAdvice() {
		System.out.println("Before any return types all packages and all methods with any parameter...");
	}

	// Poincut designators advice examples

	@Before("withinClassesUnderSpringPointcut()")
	public void withinClassesUnderSpringAdvoce() {
		System.out.println("Before within classes under Spring Advice...");
	}
	
	@Before("withinDeprecatedClassesUnderSpringPointcut()")
	public void withinDeprecatedClassesUnderSpringAdvice() {
		System.out.println("Before within deprecated classes under Spring Advice...");
	}
	
	@Before("targetPoincutDesignatorClassPointcut()")
	public void targetPoincutDesignatorClassAdvice() {
		System.out.println("Before target PoincutDesignatorClass Advice...");
	}
	
	@Before("targetAllComponentTypesPointcut()")
	public void targetAllComponentTypesAdvice() {
		System.out.println("Before target Component Type Advice...");
	}
	
	@Before("annotationAllDeprecatedTypesPointcut()")
	public void annotationAllDeprecatedTypesAdvice() {
		System.out.println("Before annotation Deprecated Type Advice...");
	}
	
	@Before("argsAllComponentTypesPointcut()")
	public void argsAllComponentTypesAdvice() {
		System.out.println("Before args Component Type Advice...");
	}
	
	@Before("thisPoincutDesignatorClassPointcut()")
	public void thisPoincutDesignatorClassAdvice() {
		System.out.println("Before this PoincutDesignatorClass Advice...");
	}
	
	@Before("beanPoincutDesignatorClassPointcut()")
	public void beanPoincutDesignatorClassAdvice() {
		System.out.println("Before bean PoincutDesignatorClass Advice...");
	}
	@Before("argsPoincutDesignatorClassPointcut()")
	public void argsPoincutDesignatorClassAdvice() {
		System.out.println("Before args PoincutDesignatorClass Advice...");
	}
}
