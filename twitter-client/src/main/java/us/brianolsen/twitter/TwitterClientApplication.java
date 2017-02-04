package us.brianolsen.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwitterClientApplication {

	@Autowired
	@Qualifier("twitterConsumer")
	private TwitterConsumer _twitterConsumer;


	public static void main(String[] args) {
		SpringApplication.run(TwitterClientApplication.class, args);
		
	}
}
