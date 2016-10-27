package us.brianolsen.spring.model;

public class DBWriter implements LogWriter{

	public void write(String text) {
		System.out.println("Write to File: " + text);
	}

}
