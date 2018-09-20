package com.hlx.algorithm.linklist;

public class LinkStack {
	private LinkList1 theList;
	
	public LinkStack(){
		theList = new LinkList1();
	}
	
	public void push(int id){
		theList.insertFirst(id);
	}
	
	public Link pop(){
		return theList.deleteFirst();
	}
	
	public boolean isEmpty(){
		return (theList.isEmpty());
	}
	
	public void displayStack(){
		System.out.print("Stack (top --> bootm): ");
		theList.displayList();
	}
}
