package us.brianolsen.spring.aop.differentPackage;

import org.springframework.stereotype.Component;

@Component
public class AnotherWildCardClass {
	public void pointcutMethod(int value){
		System.out.println("Calling: DifferentAdviceClass.pointcutMethod(int) with value ->" + value);
	}
}
