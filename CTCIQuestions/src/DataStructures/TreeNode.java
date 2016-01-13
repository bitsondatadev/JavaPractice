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
	private int size = 0;
	public static final PrintTask<?> PRINT_TASK = new PrintTask();
	
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

	protected void setLeft(TreeNode<T> left) {
		this.left = left;
		if (left != null) {
			left.parent = this;
		}
	}

	public TreeNode<T> getRight() {
		return right;
	}

	protected void setRight(TreeNode<T> right) {
		this.right = right;
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
			visit.run((T) node.getData());
			inOrderTraversal(node.getRight(), visit);
		}
	}
	public static <T> void preOrderTraversal(TreeNode<?> node, TreeTask<T> visit){
		if(node != null){
			visit.run((T) node.getData());
			preOrderTraversal(node.getLeft(), visit);
			preOrderTraversal(node.getRight(), visit);
		}
	}
	public static <T> void postOrderTraversal(TreeNode<?> node, TreeTask<T> visit){
		if(node != null){
			postOrderTraversal(node.getLeft(), visit);
			postOrderTraversal(node.getRight(), visit);
			visit.run((T) node.getData());
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
}

/**
 * Generic task to define the functions run over traversals.
 * @author Brian
 *
 * @param <T>
 */

interface TreeTask<T extends Object>{
	public void run(T data);
}

class PrintTask<T extends Object> implements TreeTask<T>{
	public void run(T data) {
		System.out.println(data);
	}
}
