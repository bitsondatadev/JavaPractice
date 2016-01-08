package DataStructures;

import java.util.List;
import java.util.ArrayList;

/**
 * Generic Tree Node that contains the static methods for all trees to perform traversal.
 * 
 * @author Brian
 *
 * @param <T>
 */
public class TreeNode<T extends Object> implements Node<T>{

	protected Node<T> parent = null;
	protected List<Node<T>> children = null;
	protected T data;
	protected final int branchingFactor;
	public static final int BINARY_BRANCHING_FACTOR = 2;
	

	public TreeNode(T data){
		this.children = new ArrayList<Node<T>>();
		this.branchingFactor = BINARY_BRANCHING_FACTOR;
		this.setData(data);	
	}
	
	public TreeNode(T data, int numChildren){
		this.children = new ArrayList<Node<T>>();
		this.branchingFactor = numChildren;
		this.setData(data);	
	}
	
	public TreeNode(Node<T> parent, T data){
		this.parent = parent;
		this.children = new ArrayList<Node<T>>();
		this.branchingFactor = BINARY_BRANCHING_FACTOR;
		this.setData(data);	
	}
	
	public TreeNode(Node<T> parent, T data, int numChildren){
		this.parent = parent;
		this.children = new ArrayList<Node<T>>();
		this.branchingFactor = numChildren;
		this.setData(data);	
	}

	public List<Node<T>> getChildren() {
		return this.children;
	}

	public boolean appendChild(Node<T> child) {
		if(this.children.size() == this.branchingFactor ){
			return false;
		}
		
		return this.children.add(child);
	}
	
	public boolean removeChild(Node<T> child) {
		if(this.children.size() == 0 ){
			return false;
		}
		
		return this.children.remove(this.children.size() - 1) != null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public static void inOrderTraversal(Node<Object> node, TreeTask<Object> visit){
		if(node != null){
			for(Node<Object> child: node.getChildren()){
				inOrderTraversal(child, visit);
				visit.run(child.getData());
			}
		}
	}
	
	public static void inOrderTraversal(Node<Object> node){
		if(node != null){
			for(Node<Object> child: node.getChildren()){
				inOrderTraversal(child);
				System.out.println(node.getData());
			}
		}
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

class PrintNode<T extends Object> implements TreeTask<T>{
	public void run(T data) {
		System.out.println(data);
	}
}