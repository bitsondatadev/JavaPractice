package DataStructures;

import java.util.*;

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

		this.size++;

		if(head==null){
			setHead(newNode);
			setTail(newNode);
			return newNode;	
		}
		
		newNode.setPrev(this.tail);
		this.tail.setNext(newNode);
		setTail(newNode);

		return this.head;
	}
	
	public LinkedListNode appendToHead(T data){
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

	public LinkedListNode search(T data){
		LinkedListNode<T> runner = this.head;

		while(runner != null && !runner.getData().equals(data)){
			runner = runner.getNext();
		}

		return runner;
	}

	public LinkedListNode remove(T data){
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

	public int size(){
		return this.size;
	}
}
