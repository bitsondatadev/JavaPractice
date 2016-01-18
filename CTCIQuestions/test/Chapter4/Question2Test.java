package Chapter4;

import org.junit.*;

import DataStructures.TreeNode;

import static org.junit.Assert.*;

public class Question2Test{
	int[] A;
	Question2 q2;

	@Before
	public void setUp(){
		q2 = new Question2();
		A = new int[10];
		for(int i = 0; i < A.length; i++){
			A[i] = i * 31;
		}
	}

	@After
	public void tearDown(){
		
	}
	
	@Test
	public void testbuildMinimalTree(){
		TreeNode<Integer> root = q2.buildMinimalTree(A);
		root.printTree();
		TreeNode.inOrderTraversal(root, TreeNode.PRINT_TASK);
	}

}
