package us.brianolsen.spring.aop;

import org.springframework.stereotype.Component;

@Component
@Deprecated
public class DeprecatedClass {
	@Deprecated
	public void pointcutMethod(){
		System.out.println("Calling: DeprecatedClass.pointcutMethod()");
	}
}
