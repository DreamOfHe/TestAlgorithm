package com.hlx.algorithm.array;

public class Queue2 {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	
	public Queue2(int max){
		maxSize = max + 1;   // array is 1 cell larger
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
	}
	
	public void insert(long value){ // put item at rear of queue
		if(rear == maxSize-1){  // deal with wraparound
			rear = -1;
		}
		queArray[++rear] = value;
	}
	
	public long remove(){ // take item from front of queue
		long temp = queArray[front++]; // get value and incr front
		if(front==maxSize){  // deal with wraparound
			front = 0;
		}
		return temp;
	}
	
	public long peekFront(){
		return queArray[front];
	}
	
	public boolean isEmpty(){
		return ((rear+1==front) || (front+maxSize-1==rear));
	}
	
	public boolean isFull(){
		return ((rear+2==front) || (front+maxSize-2==rear));
	}
	
	public int size(){
		if(rear >= front){
			return rear-front+1;
		} else {
			return (maxSize-front) + (rear+1);
		}
	}
}
