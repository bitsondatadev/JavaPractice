package DataStructures;

import java.util.ArrayList;
import java.util.List;

public class Graph<T extends Comparable<? super T>> {
	private List<Node<T>> nodes;
	
	public Graph(){
		nodes = new ArrayList<Node<T>>();
	}

	public List<Node<T>> getNodes() {
		return this.nodes;
	}
	
	public void setNodesStatusTo(boolean visited){
		for(Node<T> n:nodes){
			n.setVisited(visited);
		}
	}
	
	public boolean addEdge(T id1, T id2, boolean directed){
		if(id1 == null || id2 == null){
			return false;
		}
		Node<T> n1 = null, n2 = null;
		for(Node<T> n:nodes){
			if(id1.equals(n.getId())){
				n1 = n;
			}else if(id2.equals(n.getId())){
				n2 = n;
			}
		}
		if(n1 != null && n2 != null){
			n1.getNeighbors().add(n2);
			if(!directed){
				n2.getNeighbors().add(n1);
			}
			return true;
		}
		return false;
	}
	
}
