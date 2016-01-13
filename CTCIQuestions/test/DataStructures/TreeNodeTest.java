package DataStructures; 

import org.junit.*;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TreeNodeTest{

	TreeNode<Integer> root;
	ArrayList<Integer> arrayRandom;

	@BeforeClass
	public static void initialSetUp(){
	}

	@AfterClass
	public static void finalTearDown(){
	}
	
	@Before
	public void setUp(){
		arrayRandom = new ArrayList<Integer>(25);
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		for (int i=0; i<25; i++)
		{
		    Integer r = rand.nextInt() % 256;
		    r = r < 0 ? r * -1 : r;
		    arrayRandom.add(r);
		}
		root = new TreeNode<Integer>(arrayRandom.get(0));
		for (int i=1; i<25; i++)
		{
			root.insertInOrder(arrayRandom.get(i));
		}
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testTreeNodeInsertAndTraversal(){
		Collections.sort(arrayRandom);

		root.printTree();
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		
		//TreeNode.inOrderTraversal(root, TreeNode.PRINT_TASK);
		TreeNode.inOrderTraversal(root, q);
		int i = 0;
		while(!q.isEmpty()){
			assertEquals(arrayRandom.get(i), q.remove());
			i++;
		}
	}


}
