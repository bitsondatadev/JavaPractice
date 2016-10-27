package us.brianolsen.spring.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Can set autowired in any commented location below.
 * 
 * @author bolsen
 *
 */
@Component
public class Logger {
	// this qualifier deciphers between 2 ConsoleWriters defined in beans.xml
	@Autowired
	@Qualifier("chooseMe")
	private ConsoleWriter consoleWriter;

	// this Qualifier helps deciphers between the 2 ConsoleWriters and FileWriter that
	// all extend from LogWriter. 
	@Autowired
	@Qualifier("fileWriter")
	private LogWriter myFileWriter;

	// This bean is optional and there is no bean that exists to initialize it
	// but it won't
	// cause the program to crash with required=false.
	// However if we do add a bean for it then it will print out as expected.
	@Autowired(required = false)
	private DBWriter dbWriter;

	// @Autowired
	// public Logger(ConsoleWriter consoleWriter, FileWriter fileWriter) {
	// this.consoleWriter = consoleWriter;
	// this.fileWriter = fileWriter;
	// }

	// set methods are optional if you autowire private vars above
	// @Autowired
	// public void setConsoleWriter(ConsoleWriter writer) {
	// this.consoleWriter = writer;
	// }
	//
	// // @Autowired
	// public void setFileWriter(FileWriter writer) {
	// this.fileWriter = writer;
	// }

	public void writeConsole(String text) {
		consoleWriter.write(text);
	}

	public void writeFile(String text) {
		myFileWriter.write(text);
	}

	public void writeDB(String text) {
		if (dbWriter != null){
			dbWriter.write(text);
		}
	}
	
	@PostConstruct
	public void init(){
		System.out.println("init");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("destroy");
	}

}
