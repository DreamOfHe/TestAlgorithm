package com.hlx.array;

public class Deque { // programming work 4.2
	private int maxSize;
	private Object[] queArray;
	private int front;
	private int rear;
	private int nItems;
	
	public Deque(int max){
		maxSize = max;
		queArray = new Object[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void insertLeft(Object value){
		if(front == 0){
			front = maxSize;
		}
		queArray[--front] = value;
		nItems++;
	}
	
	public void insertRight(Object value){
		if(rear == maxSize-1){
			rear = -1;
		}
		queArray[++rear] = value;
		nItems++;
	}
	
	public Object removeLeft(){ 
		Object temp = queArray[front++];
		if(front==maxSize){
			front = 0;
		}
		nItems--;
		return temp;
	}
		
	public Object removeRight(){
		Object temp = queArray[rear--];
		if(rear==-1){
			rear = maxSize -1;
		}
		nItems--;
		return temp;
	}
	
	public Object peekLeft(){
		return queArray[front];
	}
	
	public Object peekRight(){
		return queArray[rear];
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
	
	public void displayQueue(){
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
