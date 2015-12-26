package DataStructures;

public class LinkedList<T>{
	
	LinkedListNode<T> head = null;
	LinkedListNode<T> tail = null;

	public LinkedList(){}

	public LinkedList(T data){
		head = appendToTail(data);	
	}

	public LinkedListNode appendToTail(T data){
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);

		if(head==null){
			tail = newNode;
			return newNode;	
		}
		
		tail.setNext(newNode);
		tail = newNode;

		return head;
	}

	public LinkedListNode search(T data){
		LinkedListNode<T> runner = head;

		while(runner.getData() != data){
			runner = runner.getNext();
		}

		return runner;
	}

}
