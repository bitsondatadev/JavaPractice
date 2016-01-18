package Chapter4;

import DataStructures.TreeNode;

public class Question2{
	Question2(){

	}

	public TreeNode<Integer> buildMinimalTree(int[] A){
		if(A == null || A.length <= 0){
			return null;
		}
		return buildMinimalTree(A, 0, A.length - 1);
	}
	
	private TreeNode<Integer> buildMinimalTree(int[] A, int low, int high){
		if(low > high){
			return null;
		}
		int mid = (low + high) / 2;
		TreeNode<Integer> node = new TreeNode<Integer>(A[mid]);
		node.setLeft(buildMinimalTree(A, low, mid - 1));
		node.setRight(buildMinimalTree(A, mid + 1, high));
		return node;
	}
}
