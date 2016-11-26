package us.brianolsen.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class WildCardClass {
	public void pointcutMethod(){
		System.out.println("Calling: WildCardClass.pointcutMethod()");
	}
	
	public void pointcutMethod(int value){
		System.out.println("Calling: DifferentAdviceClass.pointcutMethod(int) with value ->" + value);
	}
	
	public String pointcutMethod(String value){
		System.out.println("Calling: DifferentAdviceClass.pointcutMethod(String) with value " + value);
		return value;
	}
	public void anotherPointcutMethod(){
		System.out.println("Calling: DifferentAdviceClass.anotherPointcutMethod()");
	}
}
