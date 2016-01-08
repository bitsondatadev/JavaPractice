package DataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree that is composed of a generic tree node.
 * 
 * Left Node will always be at index 0 by convention.
 * Right Node will always be at index 1 by convention.
 * 
 * Each node can have no more than two children.
 * 
 * @author Brian
 *
 * @param <T>
 */
public class BinaryTreeNode<T extends Object> implements Node<T>{
	private TreeNode<T> node;
	private static final int LEFT_INDEX = 0;
	private static final int RIGHT_INDEX = 1;

	public BinaryTreeNode(T data){
		initNode(null, data);
	}
	
	public BinaryTreeNode(Node<T> parent, T data){
		initNode(parent, data);
	}
	
	private void initNode(Node<T> parent, T data){
		this.node = new TreeNode<T>(parent, data , TreeNode.BINARY_BRANCHING_FACTOR);
		this.node.appendChild(new BinaryTreeNode<T>(null));
		this.node.appendChild(new BinaryTreeNode<T>(null));
	}

	public List<Node<T>> getChildren() {
		return new ArrayList<Node<T>>(node.getChildren());
	}
	
	public Node<T> getLeftNode(){
		if(this.node == null || this.node.getChildren() == null){
			return null;
		}
		return this.node.getChildren().get(LEFT_INDEX);
	}
	
	public void setLeftNode(T data){
		if(this.node == null || this.node.getChildren() == null){
			return;
		}
		
		this.node.getChildren().get(LEFT_INDEX).setData(data);
	}

	public Node<T> getRightNode(){
		if(this.node == null || this.node.getChildren() == null){
			return null;
		}
		return this.node.getChildren().get(RIGHT_INDEX);
	}
	
	public void setRightNode(T data){
		if(this.node == null || this.node.getChildren() == null){
			return;
		}
		
		this.node.getChildren().get(RIGHT_INDEX).setData(data);
	}
	
	public T getData() {
		return node.getData();
	}

	public void setData(T data) {
		this.setData(data);
	}

}