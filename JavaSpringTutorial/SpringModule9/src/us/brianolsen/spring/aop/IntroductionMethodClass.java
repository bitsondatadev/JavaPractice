package us.brianolsen.spring.aop;

public class IntroductionMethodClass implements IIntroductionMethodInterface {

	@Override
	public void introducedPointcutMethod() {
		System.out.println("Calling IntroductionMethodClass.introducedPointcutMethod()");
	}

}
