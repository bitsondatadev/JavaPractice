package us.brianolsen.spring.model;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomText {
	private static String[] texts = {
			"I'll be back!",
			"Get Out!!",
			"I want your clothes, boots, and motorcycle!"
	};
	
	public String getText(){
		Random random = new Random();
		return texts[random.nextInt(texts.length)];
	}
}
