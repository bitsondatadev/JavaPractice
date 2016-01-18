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
		/*
		 * Run Data Structures Tests
		 */
		runTest(DataStructures.LinkedListNodeTest.class);
		runTest(DataStructures.LinkedListTest.class);
		runTest(DataStructures.HashTableTest.class);
	   	runTest(DataStructures.StackTest.class);
	   	runTest(DataStructures.QueueTest.class);
	   	runTest(DataStructures.TreeNodeTest.class);
	   	runTest(DataStructures.TrieNodeTest.class);
	   	
		/*
		 * Run Algorithms Tests
		 */
		runTest(Algorithms.BinarySearchTest.class);
		runTest(Algorithms.SortingTest.class);
	   	
	   	/*
		 * Run Chapter1 Tests
		 */
	   	runTest(Chapter1.Question1Test.class);
	   	runTest(Chapter1.Question2Test.class);
	   	runTest(Chapter1.Question3Test.class);
	   	runTest(Chapter1.Question4Test.class);
	   	runTest(Chapter1.Question5Test.class);
	   	
	   	/*
		 * Run Chapter2 Tests
		 */
	   	runTest(Chapter2.Question1Test.class);
	   	runTest(Chapter2.Question2Test.class);
	   	runTest(Chapter2.Question3Test.class);
	   	
	   	/*
		 * Run Chapter3 Tests
		 */
	   	runTest(Chapter3.Question1Test.class);
	   	runTest(Chapter3.Question2Test.class);
	   	runTest(Chapter3.Question3Test.class);
	   	runTest(Chapter3.Question4Test.class);
	   	
	   	/*
		 * Run Chapter4 Tests
		 */
	   	runTest(Chapter4.Question1Test.class);
	   	runTest(Chapter4.Question2Test.class);
	   	runTest(Chapter4.Question3Test.class);

	   	/*
		 * Run Chapter8 Tests
		 */
	   	runTest(Chapter8.Question1Test.class);
	   	runTest(Chapter8.Question2Test.class);
	   	runTest(Chapter8.Question3Test.class);
	   	runTest(Chapter8.Question4Test.class);
	   	
	   	/*
		 * Run Chapter16 Tests
		 */
	   	runTest(Chapter16.Question1Test.class);
	}

	public static void runTest(Class<?> c){
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
