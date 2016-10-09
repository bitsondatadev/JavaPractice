package us.brianolsen.spring.model;

public class Logger3 {
	private LogWriter consoleWriter;
	private LogWriter fileWriter;
	
	//constructor auto-wiring is detected byType
	public Logger3(ConsoleWriter writer1, FileWriter writer2){
		this.consoleWriter = writer1;
		this.fileWriter = writer2;
	}

	public void writeConsole(String text) {
		consoleWriter.write(text);
	}

	public void writeFile(String text) {
		fileWriter.write(text);
	}

}
