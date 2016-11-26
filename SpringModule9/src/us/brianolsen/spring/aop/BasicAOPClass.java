package us.brianolsen.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class BasicAOPClass {
	public void pointcutMethod(){
		System.out.println("Calling: BasicAOPClass.pointcutMethod()");
	}
}
