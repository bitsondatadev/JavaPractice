package us.brianolsen.spring.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fileWriter")
public class FileWriter implements LogWriter{

	public void write(String text) {
		System.out.println("Write to File: " + text);
	}

}
