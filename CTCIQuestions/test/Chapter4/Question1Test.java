package Chapter4;

import org.junit.*;

import DataStructures.Graph;
import DataStructures.Node;

import static org.junit.Assert.*;

public class Question1Test{
	Graph<Integer> g;
	Question1 q1;

	@Before
	public void setUp(){
		q1 = new Question1();
	}

	@After
	public void tearDown(){
		
	}
	
	/* 8---->6                     9
	 * |     ^
	 * |     |
	 * |->7->3
	 * |  ^
	 * |  |
	 * |->5->0
	 */

	@Test
	public void testIsRouteBetweenNodes(){
		g = new Graph<Integer>();
		
		Node<Integer> eight = new Node<Integer>(8);
		Node<Integer> six = new Node<Integer>(6);
		Node<Integer> oh = new Node<Integer>(0);
		Node<Integer> nine = new Node<Integer>(9);
		
		g.getNodes().add(eight);
		g.getNodes().add(six);
		g.getNodes().add(new Node<Integer>(7));
		g.getNodes().add(new Node<Integer>(5));
		g.getNodes().add(new Node<Integer>(3));
		g.getNodes().add(oh);
		g.getNodes().add(new Node<Integer>(9));
		
		g.addEdge(8, 6, true);
		g.addEdge(8, 7, true);
		g.addEdge(8, 5, true);
		g.addEdge(5, 0, true);
		g.addEdge(5, 7, true);
		g.addEdge(7, 3, true);
		g.addEdge(3, 6, true);
		
		assertTrue(q1.isRouteBetweenNodes(eight,six));
		g.setNodesStatusTo(false);
		assertTrue(q1.isRouteBetweenNodes(eight,oh));
		g.setNodesStatusTo(false);
		
		assertFalse(q1.isRouteBetweenNodes(six, oh));
		g.setNodesStatusTo(false);
		assertFalse(q1.isRouteBetweenNodes(eight, nine));
		g.setNodesStatusTo(false);
		assertFalse(q1.isRouteBetweenNodes(six, nine));
		g.setNodesStatusTo(false);
		assertFalse(q1.isRouteBetweenNodes(oh, nine));
		
	}
	
	
	


}
