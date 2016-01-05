package Chapter2;

import DataStructures.*; 

public class Question3{

	Question3(){
	}

	public void deleteMiddleNode(LinkedListNode<Integer> u){
		if(u == null){
			return;
		}
		if(u.getNext() != null){
			u.setData(u.getNext().getData());
			u.setNext(u.getNext().getNext());
		}
	}
}
