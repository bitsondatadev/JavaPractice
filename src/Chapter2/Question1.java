package Chapter2;

import java.util.HashSet;
import DataStructures.*; 

public class Question1{

	Question1(){
	}

	public LinkedListNode removeDuplicates(LinkedListNode<Integer> head){
		HashSet<Integer> hashSet = new HashSet<Integer>();
		LinkedListNode<Integer> runner = head;
		while(runner != null){
			if(hashSet.contains(runner.getData())){
				if(runner.getNext() != null){
					runner.getNext().setPrev(runner.getPrev());
				}
				
				if(runner.getPrev() != null){
					runner.getPrev().setNext(runner.getNext());
				}
			}else{
				hashSet.add((Integer)runner.getData());
			}
			runner = runner.getNext();
		}
		return head;
	}
}
