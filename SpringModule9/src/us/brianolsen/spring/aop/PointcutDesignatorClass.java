package us.brianolsen.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class PointcutDesignatorClass {
	public void pointcutMethod(){
		System.out.println("Calling: PointcutDesignatorClass.pointcutMethod()");
	}
	
	public void pointcutMethod(int value){
		System.out.println("Calling: PointcutDesignatorClass.pointcutMethod(int) => value: " + value);
	}
	
	public void pointcutMethod(double value){
		System.out.println("Calling: PointcutDesignatorClass.pointcutMethod(int) => value: " + value);
	}
	
	public void pointcutMethod(long value1, double value2){
		System.out.println("Calling: PointcutDesignatorClass.pointcutMethod(int) => value1: " + value1 + " value2: " + value2);
	}
	
	public void pointcutMethod(PointcutDesignatorClass pdc){
		System.out.println("Calling: PointcutDesignatorClass.pointcutMethod(PointcutDesignatorClass)");
	}
}
