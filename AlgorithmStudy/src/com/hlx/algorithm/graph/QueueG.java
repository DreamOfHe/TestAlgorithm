package com.hlx.algorithm.graph;

public class QueueG {
	private final int SIZE = 20;
	private int[] queArray;
	private int front;
	private int rear;
	
	public QueueG(){
		queArray = new int[SIZE];
		front = 0;
		rear = -1;
	}
	
	public void insert(int j){ // put item at rear of queue
		if(rear == SIZE-1){
			rear = -1;
		}
		queArray[++rear] = j;
	}
	
	public int remove(){        // take item from front of queue
		int temp = queArray[front++];
		if(front==SIZE){
			front = 0;
		}
		return temp;
	}
	
	public boolean isEmpty(){
		return ((rear+1==front) || (front+SIZE-1==rear));
	}
}
