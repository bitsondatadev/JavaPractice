package us.brianolsen.spring.model;

//@Component isn't needed because the beans are defined in beans.xml
public class ConsoleWriter implements LogWriter{

	public void write(String text) {
		System.out.println("Write to Console: " + text);
		
	}

}
