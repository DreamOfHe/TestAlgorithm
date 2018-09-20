package com.hlx.algorithm.linklist;

public class LinkQueue {
	private FirstLastLinkList theList;
	
	public LinkQueue(){
		theList = new FirstLastLinkList();
	}
	
	public boolean isEmpty(){
		return theList.isEmpty();
	}
	
	public void insert(int id){
		theList.insertLast(id);
	}
	
	public Link remove(){
		return theList.deleteFirst();
	}
	
	public void displayQueue(){
		System.out.print("Queue (front-->rear): ");
		theList.displayList();
	}
}
