package us.brianolsen.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class CombiningPointcutClass {
	public void pointcutMethod(){
		System.out.println("Calling: CombiningPointcutClass.pointcutMethod()");
	}
	
	public void pointcutMethod(long value1, double value2){
		System.out.println("Calling: CombiningPointcutClass.pointcutMethod(long, double) => value1: " + value1 + " value2: " + value2);
	}
}
