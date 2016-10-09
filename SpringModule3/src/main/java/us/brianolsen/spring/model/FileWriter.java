package us.brianolsen.spring.model;

public class FileWriter implements LogWriter{

	public void write(String text) {
		System.out.println("Write to File: " + text);
	}

}
