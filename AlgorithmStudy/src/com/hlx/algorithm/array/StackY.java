package com.hlx.algorithm.array;

public class StackY { // programming work 4.3
	
	private Deque stackDeque;
	
	public StackY(int max){
		stackDeque = new Deque(max);
	}
	
	public void push(Object item){
		stackDeque.insertRight(item);
	}
	
	public Object pop(){
		return stackDeque.removeRight();
	}
	
	public Object peek(){
		return stackDeque.peekRight();
	}
	
	public boolean isEmpty(){
		return stackDeque.isEmpty();
	}
	
	public boolean isFull(){
		return stackDeque.isFull();
	}
	
	public int size(){
		return stackDeque.size();
	}
	
	public void displayStack(){
		stackDeque.displayQueue();
	}
}
