package com.hlx.algorithm.array;

public class StackX {

	private int maxSize;
	private Object[] stackArray;
	private int top;
	
	public StackX(int max){
		maxSize = max;
		stackArray = new Object[maxSize];
		top = -1;
	}
	
	public void push(Object item){
		stackArray[++top] = item;
	}
	
	public Object pop(){
		return stackArray[top--];
	}
	
	public Object peek(){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return (top==-1);
	}
	
	public boolean isFull(){
		return (top == maxSize-1);
	}
	
	public int size(){
		return top+1;
	}
	
	public Object peekN(int n){
		return stackArray[n];
	}
	
	public void displayStack(String s){
		System.out.print(s);
		System.out.print("Stack (bottom-->top): ");
		for(int j=0; j<size(); j++){
			System.out.print(peekN(j) + " ");
		}
		System.out.println("");
	}
}
