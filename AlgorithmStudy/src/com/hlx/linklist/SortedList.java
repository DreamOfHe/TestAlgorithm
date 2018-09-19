package com.hlx.linklist;

public class SortedList {
	private Link first;
	
	public SortedList(){
		first = null;
	}
	
	public boolean isEmpty(){
		return (first==null);
	}
	
	public void insert(int id){
		Link newLink = new Link(id);
		Link previous = null;
		Link current = first;
		
		while(current != null && id > current.getId()){
			previous = current;
			current = current.getNext();
		}
		
		if(previous == null){ // at beginning of list
			first = newLink;
		} else {
			previous.setNext(newLink);
		}
		
		newLink.setNext(current);
		
	}
	
	public Link remove(){
		Link temp = first;
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
