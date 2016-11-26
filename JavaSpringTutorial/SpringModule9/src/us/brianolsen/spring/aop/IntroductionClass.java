package us.brianolsen.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class IntroductionClass {
	public void pointcutMethod(){
		System.out.println("Calling: IntroductionClass.pointcutMethod()");
	}
}
