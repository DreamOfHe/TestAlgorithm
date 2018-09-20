package com.hlx.algorithm.linklist;

public class LinkList1 {
	private Link first;
	
	public LinkList1(){
		first = null;
	}
	
	public boolean isEmpty(){
		return (first==null);
	}
	
	public void insertFirst(int id){ // insert at start of list
		Link newLink = new Link(id);
		newLink.setNext(first);
		first = newLink;
	}
	
	public Link deleteFirst(){  // delete first item
		Link temp = first;
		first = first.getNext();
		return temp;
	}
	
	public Link delete(int key){
		Link current = first;
		Link previous = first;
		while(current.getId() != key){
			if(current.getNext() == null){
				return null;
			} else {
				previous = current;
				current = current.getNext();
			}
		}
		if(current == first){
			first = first.getNext();
		} else {
			previous.setNext(current.getNext());
		}
		return current;
	}
	
	public Link find(int key){
		Link current = first;
		while(current.getId() != key){
			if(current.getNext() == null){
				return null;
			} else {
				current = current.getNext();
			}
		}
		return current;
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
