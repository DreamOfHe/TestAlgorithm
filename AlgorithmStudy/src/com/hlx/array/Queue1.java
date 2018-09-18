package com.hlx.array;

public class Queue1 {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;
	
	public Queue1(int max){
		maxSize = max;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void insert(long value){ // put item at rear of queue
		if(rear == maxSize-1){  // deal with wraparound
			rear = -1;
		}
		queArray[++rear] = value;
		nItems++;
	}
	
	public long remove(){ // take item from front of queue
		long temp = queArray[front++]; // get value and incr front
		if(front==maxSize){  // deal with wraparound
			front = 0;
		}
		nItems--;
		return temp;
	}
	
	public long peekFront(){
		return queArray[front];
	}
	
	public boolean isEmpty(){
		return (nItems==0);
	}
	
	public boolean isFull(){
		return (nItems==maxSize);
	}
	
	public int size(){
		return nItems;
	}
	
	public void displayQueue(){ // programming work 4.1
		int j;
		if(this.isEmpty()){
			System.out.println("Queue is empty");
		} else {
			if(front <= rear){
				for(j=front; j<= rear; j++){
					System.out.print(queArray[j] + " ");
				}
			} else {
				for(j=front; j<= maxSize-1; j++){
					System.out.print(queArray[j] + " ");
				}
				for(j=0; j<= rear; j++){
					System.out.print(queArray[j] + " ");
				}
			}
		}
		System.out.println("");
	}
}
