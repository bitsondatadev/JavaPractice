package DataStructures;

public class LinkedList<T>{
	
	private LinkedListNode<T> head = null;
	private LinkedListNode<T> tail = null;

	public LinkedList(){}

	public LinkedList(T data){
		appendToTail(data);	
	}

	public LinkedListNode getHead(){
		return this.head;
	}

	public void setHead(LinkedListNode node){
		this.head = node;
	}

	public LinkedListNode getTail(){
		return this.tail;
	}

	public void setTail(LinkedListNode node){
		this.tail = node;
	}

	public LinkedListNode appendToTail(T data){
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);

		if(head==null){
			setHead(newNode);
			setTail(newNode);
			return newNode;	
		}
		
		this.tail.setNext(newNode);
		setTail(newNode);

		return this.head;
	}

	public LinkedListNode search(T data){
		LinkedListNode<T> runner = head;

		while(runner.getData() != data){
			runner = runner.getNext();
		}

		return runner;
	}

}
