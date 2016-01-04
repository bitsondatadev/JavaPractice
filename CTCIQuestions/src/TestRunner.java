import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
   
	public static void main(String[] args) {
		runTest(DataStructures.LinkedListNodeTest.class);
		runTest(DataStructures.LinkedListTest.class);
   	runTest(DataStructures.HashTableTest.class);
   	runTest(Chapter1.Question1Test.class);
   	runTest(Chapter1.Question2Test.class);
   	runTest(Chapter1.Question3Test.class);
   	runTest(Chapter1.Question4Test.class);
   	runTest(Chapter2.Question1Test.class);
   	runTest(Chapter2.Question2Test.class);
	}

	public static void runTest(Class c){
		System.out.println(ANSI_CYAN + "Running Tests for " + c.getName() + " class."  + ANSI_RESET);
		Result result = JUnitCore.runClasses(c);
		if(result.wasSuccessful()){
			System.out.println(ANSI_GREEN + "All " + Integer.toString(result.getRunCount())  + " test(s) were successful!" + ANSI_RESET);
		}else{
			System.out.println(ANSI_RED + Integer.toString(result.getFailureCount()) + " test(s) failed! " + 
			Integer.toString(result.getRunCount()) + " test(s) run."  + ANSI_RESET);
			for (Failure failure : result.getFailures()) {
   			System.out.println(ANSI_RED + failure.toString() + ANSI_RESET);
			}
		}
	}
} 
