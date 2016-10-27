package us.brianolsen.spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {

	private String id = "0";
	private String speech = "hello";
	
	public void speak(){
		System.out.println(id + ":" + speech);
	}

	//See SPEL description in beans.xml
	@Autowired
	public void setId(@Value("#{randomText.text?.length()}") String id) {
		this.id = id;
	}

	//http://docs.spring.io/spring/docs/current/spring-framework-reference/html/expressions.html
	//List of other SPEL operators
	// #{new java.util.Date().toString()} => Thu Oct 27 00:04:04 CDT 2016
	// #{T(Math).PI} -> 3.141592653589793 (access static fields using T)
	// #{T(Math).sin(T(Math).PI/4)} -> 0.7071067811865475
	// #{4 le 4} -> true
	// #{4 le 3.9} -> false
	// #{4 gt 3.9} -> true
	// #{4 eq 4 ? 'hi' : 'bye'} -> hi
	// #{4 eq 3 ? 'hi' : 'bye'} -> bye
	@Autowired
	public void setSpeech(@Value("#{'randomText: ' + randomText.getText()}") String speech) {
		this.speech = speech;
	}
}
