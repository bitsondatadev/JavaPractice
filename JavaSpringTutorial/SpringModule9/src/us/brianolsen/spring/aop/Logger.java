package us.brianolsen.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
	
	@DeclareParents(value = "us.brianolsen.spring.aop.*", defaultImpl=us.brianolsen.spring.aop.IntroductionMethodClass.class)
	private IIntroductionMethodInterface _introductionMethodInterface;

	/*************************************
	 * POINTCUTS
	 *************************************
	 */

	// basic aop pointcut

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

	// @Pointcut("within(@org.springframework.stereotype.Component
	// us.brianolsen.spring..*)")
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

	// @Pointcut("bean(*DesignatorClass)") //also works to match this bean
	@Pointcut("bean(pointcutDesignatorClass)")
	public void beanPoincutDesignatorClassPointcut() {
	}

	// @Pointcut("args()") match all methods with no arguments
	// @Pointcut("args(int)")
	// @Pointcut("args(long, double)")
	// @Pointcut("args(long, *)") //matches 2 argments where the first one is a
	// long
	// @Pointcut("args(long, ..)") //matches 1 to infinite argments where the
	// first one is a long

	// matches 1 to infinite argments where the last one is a double. Also will
	// match any type that can be autoboxed to it (like primitive int).
	// @Pointcut("args(.., double)")

	// matches 1 to infinite argments where thelast one is a double. Also will
	// match any type that can be autoboxed to it (but int will not).
	@Pointcut("args(.., Double)")
	public void argsValuesPointcut() {
	}
	
	@Pointcut("args(Double)")
	public void argsDoubleValuePointcut() {
	}
	
	@Pointcut("args(value1, value2)")
	public void argsLongDoubleValuesPointcut(long value1, double value2) {
	}
	
	// Combining Pointcut examples
	
	@Pointcut("target(us.brianolsen.spring.aop.CombiningPointcutClass)")
	public void targetCombiningPointcutClassPointcut() {
	}

	/*************************************
	 * ADVICE METHODS
	 *************************************
	 */
	
	@Before("executionBasicAOPClassPointcutMethodPointcut()")
	// @Before("execution(void us.brianolsen.spring.aop.Camera.snap())")
	// ^^^we can define pointcut designator if we define pointcut in
	public void executionBasicAOPClassPointcutMethodAdvice() {
		printAdvice("Before", "execution", "BasicAOPClass pointcut method Advice...");
	}

	// Different advice annotation examples

	@After("executionDifferentAdviceClassPointcutMethodPointcut()")
	public void executionCameraSnapMethodAfterAdvice() {
		printAdvice("After", "execution", "DifferentAdviceClass PointcutMethod...");
	}

	@AfterReturning("executionDifferentAdviceClassPointcutMethodPointcut()")
	public void executionCameraSnapMethodAfterReturningAdvice() {
		// verify that method hasn't thrown exception
		printAdvice("AfterReturning", "execution", " DifferentAdviceClass PointcutMethod...");
	}

	@AfterThrowing("executionDifferentAdviceClassPointcutMethodPointcut()")
	public void executionCameraSnapMethodAfterThrowingAdvice() {
		// verify that method has thrown exception
		printAdvice("AfterThrowing", "execution", " DifferentAdviceClass PointcutMethod...");
	}

	@Around("executionDifferentAdviceClassPointcutMethodPointcut()")
	public void executionCameraSnapMethodAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		printAdvice("Around", "execution", "DifferentAdviceClass PointcutMethod method (before)...");
		try {
			proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			printException("In around advice: " + e.getMessage());
		}
		printAdvice("Around ", "execution", " DifferentAdviceClass PointcutMethod method (after)...");
	}

	// Specific Parameter pointcuts

	@Before("executionDifferentAdviceClassPointcutMethodStringPointcut()")
	public void cameraSnapStringParameterAdvice() {
		printAdvice("Before", "execution", "DifferentAdviceClass PointcutMethod with string parameter...");
	}

	// Wildcard advice examples

	@Before("executionWildCardClassPointcutMethodPointcut()")
	public void executionWildCardClassPointcutMethodAdvice() {
		printAdvice("Before", "execution", "WildCard pointcut method Advice...");
	}

	@Before("executionAnyReturnTypesPackagesAndMethodsWithAnyParameterPointcut()")
	public void executionAnyReturnTypesPackagesAndMethodsWithAnyParameterAdvice() {
		printAdvice("Before", "execution", "any return types all packages and all methods with any parameter...");
	}

	// Poincut designators advice examples

	@Before("withinClassesUnderSpringPointcut()")
	public void withinClassesUnderSpringAdvoce() {
		printAdvice("Before", "within", "classes under Spring Advice...");
	}

	@Before("withinDeprecatedClassesUnderSpringPointcut()")
	public void withinDeprecatedClassesUnderSpringAdvice() {
		printAdvice("Before ", "within", "deprecated classes under Spring Advice...");
	}

	@Before("targetPoincutDesignatorClassPointcut()")
	public void targetPoincutDesignatorClassAdvice() {
		printAdvice("Before", "target ", "PoincutDesignatorClass Advice...");
	}

	@Before("targetAllComponentTypesPointcut()")
	public void targetAllComponentTypesAdvice() {
		printAdvice("Before", "target", "Component Type Advice...");
	}

	@Before("annotationAllDeprecatedTypesPointcut()")
	public void annotationAllDeprecatedTypesAdvice() {
		printAdvice("Before", "annotation ", "Deprecated Type Advice...");
	}

	@Before("argsAllComponentTypesPointcut()")
	public void argsAllComponentTypesAdvice() {
		printAdvice("Before", "args", "Component Type Advice...");
	}

	@Before("thisPoincutDesignatorClassPointcut()")
	public void thisPoincutDesignatorClassAdvice() {
		printAdvice("Before", "this", "PoincutDesignatorClass Advice...");
	}

	@Before("beanPoincutDesignatorClassPointcut()")
	public void beanPoincutDesignatorClassAdvice() {
		printAdvice("Before", "bean", "PoincutDesignatorClass Advice...");
	}

	@Before("argsValuesPointcut()")
	public void argsValuesAdvice() {
		printAdvice("Before", "args", "Values Advice...");
	}
	
	@Before("argsDoubleValuePointcut()")
	public void argsDoubleValueAdvice(JoinPoint jp) {
		printAdvice("Before", "args", "Double Value Advice...");
		for(Object obj: jp.getArgs()){
			System.out.println("\t\t⊢Arg: " + obj);
		}
	}
	
	@Before("argsLongDoubleValuesPointcut(value1, value2)")
	public void argsLongDoubleValuesAdvice(JoinPoint jp, long value1, double value2) {
		printAdvice("Before", "args", "Long/Double Values Advice...");
		System.out.println("\t\t⊢Value1: " + value1);
		System.out.println("\t\t⊢Value2: " + value2);
	}
	
	// Combining Pointcut examples
	
	@Before("targetCombiningPointcutClassPointcut() && argsLongDoubleValuesPointcut(value1, value2)")
	public void argsValuesCombiningPointcutClassAdvice(long value1, double value2) {
		printAdvice("Before", "target && args", "Double CombiningPointcutClass Advice...");
		System.out.println("\t\t⊢Value1: " + value1);
		System.out.println("\t\t⊢Value2: " + value2);
	}
	
	//@After("within(us.brianolsen.spring.aop.*) && !@annotation(Deprecated)")
	//@After("within(us.brianolsen.spring.aop.*) ||& @annotation(Deprecated)")
	@After("within(us.brianolsen.spring.aop.*) && @annotation(Deprecated)")
	public void argsValuesCombiningPointcutClassAdvice(){
		printAdvice("After", "within && annotation", "combined with no pointcut Deprecated Advice...");
	}

	public void printAdvice(String adviceType, String poincutDesignator, String advice) {
		// ⊢⊩⊨⊪⊫
		System.out.println("\t⊨[ " + adviceType + " ]=> " + poincutDesignator + " <= " + advice);
	}

	public void printException(String exception) {
		System.out.println("\t!![ EXCEPTION ]!!--> " + exception + " <-- ");
	}
}
