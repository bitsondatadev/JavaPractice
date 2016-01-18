package Chapter4; 

import org.junit.*;
import static org.junit.Assert.*;

import DataStructures.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class Question3Test{

	TreeNode<Integer> root;
	int[] arr;
	Question2 q2;
	Question3 q3;

	@BeforeClass
	public static void initialSetUp(){
	}

	@AfterClass
	public static void finalTearDown(){
	}
	
	@Before
	public void setUp(){
		q2 = new Question2();
		q3 = new Question3();
		arr = new int[25];
		root = new TreeNode<Integer>(12);
		for (int i=0; i<25; i++){
			arr[i] = i;
		}
		root = q2.buildMinimalTree(arr);
		
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testGetListAtDepth(){
		//root.printTree();
		List<LinkedList<TreeNode<Integer>>> list = q3.getListOfDepths(root);
		/*int i = 0;
		for(LinkedList<TreeNode<Integer>> sub: list){
			System.out.println("Depth " + i++ + ":");
			for(TreeNode<Integer> node: sub){
				System.out.print(node.getData() + "->");
			}
			System.out.println();
		}*/
		
		assertEquals(1,list.get(0).size());
		assertEquals(2,list.get(1).size());
		assertEquals(4,list.get(2).size());
		assertEquals(8,list.get(3).size());
		assertEquals(10,list.get(4).size());
		
		
	}


}
