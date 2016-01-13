package Algorithms;

import java.util.ArrayList;
import java.util.List;

import DataStructures.Node;
import DataStructures.Queue;
import DataStructures.Stack;

public class GraphSearch<T extends Object> {
	
	/**
	 * Returns a list in DFS Order.
	 * @param s
	 * @return
	 */
	public static <T> List<Node> dfs(Node<?> s){
		if(s == null || s.getNeighbors() == null){
			return null;
		}
		Stack<Node<?>> stack = new Stack<Node<?>>();
		List<Node> output = new ArrayList<Node>();
		stack.push(s);
		s.setVisited(true);
		
		while(!stack.empty()){
			Node<?> u = (Node<?>) stack.pop();
			output.add(u);
			List<?> neighbors = u.getNeighbors();
			if(neighbors != null){
				for(int i = 0; i < neighbors.size(); i++){
					Node<?> v = (Node<?>) neighbors.get(i);
					if(v != null && !v.isVisited()){
						v.setVisited(true);
						stack.push(v);
					}
				}
			}
				
			
		}
		
		return output;
	}
	
	
	/**
	 * Returns a list in BFS Order.
	 * @param s
	 * @return
	 */
	public static <T> List<Node> bfs(Node<?> s){
		if(s == null || s.getNeighbors() == null){
			return null;
		}
		Queue<Node<?>> queue = new Queue<Node<?>>();
		List<Node> output = new ArrayList<Node>();
		queue.add(s);
		s.setVisited(true);
		
		while(!queue.empty()){
			Node<?> u = (Node<?>) queue.remove();
			output.add(u);
			List<?> neighbors = u.getNeighbors();
			if(neighbors != null){
				for(int i = 0; i < neighbors.size(); i++){
					Node<?> v = (Node<?>) neighbors.get(i);
					if(v != null && !v.isVisited()){
						v.setVisited(true);
						queue.add(v);
					}
				}
			}
		}
		return output;
	}
}