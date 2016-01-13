package DataStructures;

public class LinkedList<T>{
	
	private LinkedListNode<T> head = null;
	private LinkedListNode<T> tail = null;
	private int size;

	public LinkedList(){
		this.size = 0;
	}

	public LinkedList(T data){
		appendToTail(data);
		this.size = 1;
	}

	public LinkedListNode<T> getHead(){
		return this.head;
	}

	public void setHead(LinkedListNode<T> node){
		this.head = node;
	}

	public LinkedListNode<T> getTail(){
		return this.tail;
	}

	public void setTail(LinkedListNode<T> node){
		this.tail = node;
	}

	public LinkedListNode<T> appendToTail(T data){
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);

		this.size++;

		if(this.head==null){
			setHead(newNode);
			setTail(newNode);
			return newNode;	
		}
		
		newNode.setPrev(this.tail);
		this.tail.setNext(newNode);
		setTail(newNode);

		return this.head;
	}
	
	public LinkedListNode<T> appendToHead(T data){
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);

		this.size++;

		if(head==null){
			setHead(newNode);
			setTail(newNode);
			return newNode;
		}

		newNode.setNext(this.head);
		this.head.setPrev(newNode);
		setHead(newNode);

		return this.head;
	}

	public LinkedListNode<T> search(T data){
		LinkedListNode<T> runner = this.head;

		while(runner != null && !runner.getData().equals(data)){
			runner = runner.getNext();
		}

		return runner;
	}

	public LinkedListNode<T> removeTail(){
		if(this.tail == null){
			return null;
		}
		LinkedListNode<T> oldTail = this.tail;
		
		this.tail = oldTail.getPrev();
		if(this.tail != null){
			this.tail.setNext(null);
		}else{
			this.head = null;
		}
		
		oldTail.setPrev(null);
		this.size--;
		
		return oldTail;
	}

	public LinkedListNode<T> remove(T data){
		LinkedListNode<T> node = search(data);
	
		if(node==null){
			return null;
		}

		if(this.head == node){
			this.head = node.getNext();
		}

		if(this.tail == node){
			this.tail = node.getPrev();
		}

		if(node.getPrev() != null){
			node.getPrev().setNext(node.getNext());
		}

		if(node.getNext() != null){
			node.getNext().setPrev(node.getPrev());
		}
		
		this.size--;

		return node;
	}
	
	public String toString(){
		LinkedListNode<T> runner = this.head;
		String str = "";

		while(runner != null){
			str += "|" + runner.getData().toString() + "|";
			runner = runner.getNext();
			if(runner != null){
				str += "-->";
			}
		}
		str += "\n";

		return str;
	}

	public boolean equals(LinkedList<T> rList){
		LinkedListNode<T> runner = this.head;
		LinkedListNode<T> rRunner = rList.head;
		
		if(this.size != rList.size()){
			return false;
		}

		while(runner != null){
			if(runner.getData() != rRunner.getData()){
				return false;
			}
			runner = runner.getNext();
			rRunner = rRunner.getNext();
		}
		return true;
	}
	//only used for testing
	public void updateSize(){
		LinkedListNode<T> runner = this.head;
		this.size = 0;

		while(runner != null){
			this.size++;
			runner = runner.getNext();
		}
	}

	public int size(){
		return this.size;
	}
	
	public boolean empty(){
		return this.size == 0;
	}
}
