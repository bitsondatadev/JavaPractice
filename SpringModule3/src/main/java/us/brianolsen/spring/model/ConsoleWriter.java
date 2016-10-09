package us.brianolsen.spring.model;

public class ConsoleWriter implements LogWriter{

	public void write(String text) {
		System.out.println("Write to Console: " + text);
		
	}

}
