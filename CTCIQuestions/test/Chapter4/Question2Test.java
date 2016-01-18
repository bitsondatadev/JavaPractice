package Chapter4;

import org.junit.*;

import DataStructures.TreeNode;

import static org.junit.Assert.*;

import java.util.ArrayDeque;

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
	
	//Just verified the order but just
	//printed to verify it was minimal
	@Test
	public void testbuildMinimalTree(){
		TreeNode<Integer> root = q2.buildMinimalTree(A);
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();

		TreeNode.inOrderTraversal(root, q);
		
		Integer cur = q.remove(), prev; 
		
		while(!q.isEmpty()){
			prev = cur;
			cur = q.remove();
			assertTrue(prev <= cur);
		}
	}

}
