package DataStructures;

public class LinkedListNode<T>{

	private LinkedListNode<T> next = null;
	private LinkedListNode<T> prev = null;
	private T data;

	public LinkedListNode(T data){
		this.data = data;	
	}

	public LinkedListNode<T> getNext(){
		return this.next;
	}

	public void setNext(LinkedListNode<T> newNext){
		this.next = newNext;
	}

	public LinkedListNode<T> getPrev(){
		return this.prev;
	}

	public void setPrev(LinkedListNode<T> newPrev){
		this.prev = newPrev;
	}

	public T getData(){
		return this.data;
	}

	public void setData(T newData){
		this.data = newData;
	}
	
	public String toString(){
		return this.data.toString();
	}
}
