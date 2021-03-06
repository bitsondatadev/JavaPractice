package DataStructures;

public class Queue<T>{

	private LinkedList<T> linkedList;

	public Queue(){
		this.linkedList = new LinkedList<T>();	
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
	
	public T remove(){
		if(this.empty()){
			return null;
		}
		LinkedListNode<T> val = this.linkedList.removeTail();
		return val.getData();
	}
	
	public T add(T item){
		if(item == null){
			return null;
		}
		
		this.linkedList.appendToHead(item);
		
		return item;
	}
	
	public int size(){
		return this.linkedList.size();
	}
}
