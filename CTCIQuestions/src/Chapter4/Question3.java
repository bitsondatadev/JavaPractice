package Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import DataStructures.TreeNode;

public class Question3{
	Question3(){

	}

	public List<LinkedList<TreeNode<Integer>>> getListOfDepths(TreeNode<Integer> root){
		if(root == null){
			return null;
		}
		List<LinkedList<TreeNode<Integer>>> depths = new ArrayList<LinkedList<TreeNode<Integer>>>();
		depths.add(new LinkedList<TreeNode<Integer>>());
		int current = 0;
		
		depths.get(current).add(root);
		ListIterator<TreeNode<Integer>> lIter = depths.get(current).listIterator(0);
		
		while(lIter.hasNext() || depths.size() > current + 1){
			if(!lIter.hasNext()){
				lIter = depths.get(++current).listIterator(0);
			}
			
			TreeNode<Integer> node = lIter.next();
			TreeNode<Integer> left = node.getLeft();
			TreeNode<Integer> right = node.getRight();
			
			if(left != null || right != null){
				if(depths.size() == current + 1){
					depths.add(new LinkedList<TreeNode<Integer>>());
				}
				if(left != null){
					depths.get(current + 1).add(left);
				}
				if(right != null){
					depths.get(current + 1).add(right);
				}
			}
		}
		
		return depths;
	}
}
