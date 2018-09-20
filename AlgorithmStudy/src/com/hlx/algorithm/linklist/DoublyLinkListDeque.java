package com.hlx.algorithm.linklist;

public class DoublyLinkListDeque { // programming work 5.2
	private DoublyLinkList theList;
	
	public DoublyLinkListDeque(){
		theList = new DoublyLinkList();
	}
	
	public void insertLeft(int id){
		theList.insertFirst(id);
	}
	
	public void insertRight(int id){
		theList.insertLast(id);
	}
	
	public DoublyLink removeLeft(){ 
		return theList.deleteFirst();
	}
		
	public DoublyLink removeRight(){
		return theList.deleteLast();
	}
	
	public boolean isEmpty(){
		return theList.isEmpty();
	}
	
	public void display(){
		theList.displayForward();
	}
}
