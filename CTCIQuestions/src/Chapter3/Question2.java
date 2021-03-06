package Chapter3;

import DataStructures.*;

public class Question2<T extends Number & Comparable<? super T>>{

	private LinkedList<T> linkedList;
	private LinkedList<T> minList;

	public Question2(){
		this.linkedList = new LinkedList<T>();
		this.minList = new LinkedList<T>();
	}
	
	public boolean empty(){
		return this.linkedList.size() == 0;
	}
	
	public T peek(){
		if(this.linkedList.getTail() == null){
			return null;
		}
		return this.linkedList.getTail().getData();
	}
	
	public T min(){
		if(this.minList.getTail() == null){
			return null;
		}
		return this.minList.getTail().getData();
	}
	
	public T pop(){
		if(this.empty()){
			return null;
		}
		LinkedListNode<T> val = this.linkedList.removeTail();
		this.minList.removeTail();
		return val.getData();
	}
	
	public T push(T item){
		if(item == null){
			return null;
		}
		LinkedListNode<T> min = this.minList.getTail();
		if(min == null || min.getData().compareTo(item) > 0){
			this.minList.appendToTail(item);
		}else{
			this.minList.appendToTail(min.getData());
		}
		
		this.linkedList.appendToTail(item);
		
		return item;
	}
	
	public int size(){
		return this.linkedList.size();
	}
}
