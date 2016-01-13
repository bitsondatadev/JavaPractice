package DataStructures;

import java.util.ArrayList;
import java.util.List;

public class Node<T extends Comparable<? super T>>{
	private T id;
	private boolean visited;
	private List<Node<T>> neighbors;
	
	public Node(){
		this.setId(null);
		this.neighbors = new ArrayList<Node<T>>();
		this.setVisited(false);
	}
	
	public Node(T id){
		this.setId(id);
		this.neighbors = new ArrayList<Node<T>>();
		this.setVisited(false);
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}
	
	public List<Node<T>> getNeighbors(){
		return this.neighbors;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
}