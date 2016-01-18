package DataStructures;

import java.util.Collection;

/**
 * Binary Tree
 *  n - number of nodes
 * 
 * Build Tree:
 *  - Time Complexity: O(n)
 *  - Space Complexity: O(n)
 * 
 * Search:
 *  - Time Complexity: O(log(n))
 *  - Space Complexity: O(1)
 * 
 * Insert:
 *  - Time Complexity: O(log(n))
 *  - Space Complexity: O(1)
 *  
 *  Remove:
 *  - Time Complexity: O(log(n))
 *  - Space Complexity: O(1)
 * 
 * @author Brian
 *
 * @param <T>
 */
public class TreeNode<T extends Comparable<? super T>>{
	protected T data;
	protected TreeNode<T> parent = null;
	private TreeNode<T> left = null;    
	private TreeNode<T> right = null;
	private boolean visited;
	private int size = 0;
	public static final PrintTask<?> PRINT_TASK = new PrintTask();
	public static final ResetVisited<?> RESET_VISITED_TASK = new ResetVisited();
	
	public TreeNode(){
		this.setData(null);	
	}
	
	public TreeNode(T data){
		this.setData(data);	
	}
	
	public TreeNode<T> getParent(){
		return this.parent;
	}
	
	public void setParent(TreeNode<T> node){
		this.parent = node;
	}
	
	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left  = left;
		if (left != null) {
			left.parent = this;
		}
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right  = right;
		if (right != null) {
			right.parent = this;
		}
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}
	

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public void insertInOrder(T data){
		if(this.data == null){
			this.left = new TreeNode<T>(data);
		}
		if(data.compareTo(this.data) <= 0){
			if(this.left == null){
				this.left = new TreeNode<T>(data);
			}else{
				left.insertInOrder(data);
			}
		}else{
			if(this.right == null){
				this.right = new TreeNode<T>(data);
			}else{
				right.insertInOrder(data);
			}
		}
		this.size++;
	}
	
	public TreeNode<T> find(T data) {
		if (data.compareTo(data) == 0) {
			return this;
		} else if (data.compareTo(data) <= 0) {
			return left != null ? left.find(data) : null;
		} else if (data.compareTo(data) > 0) {
			return right != null ? right.find(data) : null;
		}
		return null;
	}
	
	public static <T> void inOrderTraversal(TreeNode<?> node, TreeTask<T> visit){
		if(node != null){
			inOrderTraversal(node.getLeft(), visit);
			visit.run(node);
			inOrderTraversal(node.getRight(), visit);
		}
	}
	public static <T> void preOrderTraversal(TreeNode<?> node, TreeTask<T> visit){
		if(node != null){
			visit.run(node);
			preOrderTraversal(node.getLeft(), visit);
			preOrderTraversal(node.getRight(), visit);
		}
	}
	public static <T> void postOrderTraversal(TreeNode<?> node, TreeTask<T> visit){
		if(node != null){
			postOrderTraversal(node.getLeft(), visit);
			postOrderTraversal(node.getRight(), visit);
			visit.run(node);
		}
	}
	
	public static <T> void inOrderTraversal(TreeNode<?> node, Collection<T> collection){
		if(node != null){
			inOrderTraversal(node.getLeft(), collection);
			collection.add((T) node.getData());
			inOrderTraversal(node.getRight(), collection);
		}
	}
	public static <T> void preOrderTraversal(TreeNode<?> node, Collection<T> collection){
		if(node != null){
			collection.add((T) node.getData());
			preOrderTraversal(node.getLeft(), collection);
			preOrderTraversal(node.getRight(), collection);
		}
	}
	public static <T> void postOrderTraversal(TreeNode<?> node, Collection<T> collection){
		if(node != null){
			postOrderTraversal(node.getLeft(), collection);
			postOrderTraversal(node.getRight(), collection);
			collection.add((T) node.getData());
		}
	}
	
	
	public void printTree() {
		BTreePrinter.printNode(this);
	}
	
	public int getSize(){
		return size;
	}
}

/**
 * Generic task to define the functions run over traversals.
 * @author Brian
 *
 * @param <T>
 */

interface TreeTask<T extends Object>{
	public void run(TreeNode node);
}

class PrintTask<T extends Object> implements TreeTask<T>{
	public void run(TreeNode node) {
		System.out.println(node.getData());
	}
}

class ResetVisited<T extends Object> implements TreeTask<T>{
	public void run(TreeNode node) {
		node.setVisited(false);
	}
}
