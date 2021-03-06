package Chapter3;

import DataStructures.*;

public class Question4<T>{

	private Stack<T> pushStack;
	private Stack<T> popStack;
	private int size;

	public Question4(){
		this.pushStack = new Stack<T>();
		this.popStack  = new Stack<T>();
		this.size = 0;
	}
	
	public boolean empty(){
		return this.size == 0;
	}
	
	public T peek(){
		if(this.empty()){
			return null;
		}
		if(!empty() && this.popStack.size() == 0){
			swapStacks();
		}

		return this.popStack.peek();
	}
	
	public T remove(){
		if(this.empty()){
			return null;
		}
		if(!empty() && this.popStack.size() == 0){
			swapStacks();
		}
		this.size--;
		return this.popStack.pop();
	}
	
	public T add(T item){
		if(item == null){
			return null;
		}
		
		this.size++;
		this.pushStack.push(item);
		
		return item;
	}
	
	private void swapStacks(){
		if(this.pushStack.size() > 0 && this.popStack.empty()){
			T val = this.pushStack.pop();
			while(val != null){
				this.popStack.push(val);
				val = this.pushStack.pop();
			}
		}
	}
	
	public int size(){
		return this.size;
	}
}
