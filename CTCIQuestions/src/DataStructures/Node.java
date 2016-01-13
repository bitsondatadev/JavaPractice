package DataStructures;

import java.util.List;

public class Node {
	private int id;
	private List<Node> neighbors;
	
	Node(){
		this.setId(-1);
		this.neighbors = null;
	}
	
	Node(int id){
		this.setId(id);
		this.neighbors = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public List<Node> getNeighbors(){
		return this.neighbors;
	}
	
}