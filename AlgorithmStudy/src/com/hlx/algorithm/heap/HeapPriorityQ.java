package com.hlx.algorithm.heap;

// programming work 12.3
public class HeapPriorityQ {
	private int maxSize;
	private Heap queHeap;
	
	public HeapPriorityQ(int s){
		maxSize = s;
		queHeap = new Heap(maxSize);
	}
	
	public void insert(int item){
		queHeap.insert(item);
	}
	
	public int remove(){
		return queHeap.remove().getKey();
	}
	
	public int peek(){
		return queHeap.peek().getKey();
	}
	
	public boolean isEmpty(){
		return queHeap.isEmpty();
	}
	
	public boolean isFull(){
		return queHeap.isFull();
	}
	
	public void display(){
		queHeap.displayHeap();
	}
}
