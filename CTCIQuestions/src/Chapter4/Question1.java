package Chapter4;

import java.util.List;

import Algorithms.GraphSearch;
import DataStructures.Node;

public class Question1{
	Question1(){

	}

	public boolean isRouteBetweenNodes(Node<Integer> n1, Node<Integer> n2){
		if(n1 == null || n2 == null){
			return false;
		}
		List<Node> travList = GraphSearch.dfs(n1);
		return travList.contains(n2);
	}
}
