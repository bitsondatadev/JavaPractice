package DataStructures;

import java.util.ArrayList;
import java.util.List;

public class LinkedListNode<T> implements Node<T>{

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

	public List<Node<T>> getChildren() {
		List<Node<T>> list = new ArrayList<Node<T>>();
		list.add(next);
		list.add(prev);
		return list;
	}
}
