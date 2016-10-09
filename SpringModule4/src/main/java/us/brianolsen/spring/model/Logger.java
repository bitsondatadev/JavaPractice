package us.brianolsen.spring.model;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Can set autowired in any commented location below.
 * 
 * @author bolsen
 *
 */
public class Logger {
	@Autowired
	private ConsoleWriter consoleWriter;
	@Autowired
	private FileWriter fileWriter;

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
		fileWriter.write(text);
	}

}
