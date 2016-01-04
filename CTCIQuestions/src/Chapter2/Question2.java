package Chapter2;

import DataStructures.*; 

public class Question2{

	Question2(){
	}

	public LinkedListNode<Integer> getKthToLastNode(LinkedListNode<Integer> head, int k){
		LinkedListNode<Integer> runner1 = head, runner2 = head;
		for(int i=0; i <= k; i++){
			if(runner1 == null){
				return null;
			}
			runner1 = runner1.getNext();
		}

		while(runner1 != null){
			runner1 = runner1.getNext();
			runner2 = runner2.getNext();
		}

		return runner2;
	}
}
