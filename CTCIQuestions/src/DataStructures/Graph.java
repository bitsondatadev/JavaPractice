package DataStructures;

import java.util.List;

public class Graph<T extends Comparable<? super T>> {
	private List<Node<T>> nodes;

	public List<Node<T>> getNodes() {
		return this.nodes;
	}
	
}
