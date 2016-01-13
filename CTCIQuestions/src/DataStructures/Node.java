package DataStructures;

import java.util.List;

public class Node<T extends Comparable<? super T>>{
	private T id;
	private List<Node<T>> neighbors;
	
	Node(){
		this.setId(null);
		this.neighbors = null;
	}
	
	Node(T id){
		this.setId(id);
		this.neighbors = null;
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
	
}