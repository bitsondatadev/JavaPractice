package us.brianolsen.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class DifferentAdviceClass implements DifferentAdviceInterface{

	public void pointcutMethod(){
		System.out.println("Calling: DifferentAdviceClass.pointcutMethod()");
	}
	
	public void pointcutMethod(boolean throwException) throws Exception{
		System.out.println("Calling: DifferentAdviceClass.pointcutMethod(boolean) throws Exception");
		throw new Exception("void poinCutMethod(boolean) exception");
	}

	
}
