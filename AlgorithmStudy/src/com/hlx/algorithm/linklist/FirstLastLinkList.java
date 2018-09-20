package com.hlx.algorithm.linklist;

public class FirstLastLinkList {

	private Link first;
	private Link last;
	
	public FirstLastLinkList(){
		first = null;
		last = null;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public void insertFirst(int id){ // insert at front of list
		Link newLink = new Link(id);
		
		if(this.isEmpty()){
			last = newLink;
		}
		newLink.setNext(first);
		first = newLink;
	}
	
	public void insertLast(int id){ // insert at front of list
		Link newLink = new Link(id);
		
		if(this.isEmpty()){
			first = newLink;
		} else {
			last.setNext(newLink);
		}
		last = newLink;
	}
	
	public Link deleteFirst(){
		Link temp = first;
		if(first.getNext() == null){ // if only one item
			last = null;
		}
		first = first.getNext();
		return temp;
	}
	
	public void displayList(){
		System.out.print("List (first --> last): ");
		Link current = first;
		while(current !=null ){
			current.displayLink();
			current = current.getNext();
		}
		System.out.println("");
	}
}
