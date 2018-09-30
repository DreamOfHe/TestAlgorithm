package com.hlx.algorithm.linklist;

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
	
	public void insertLink(Link newLink){
		int id = newLink.getId();
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
	
	public void delete(int key){
		Link previous = null;
		Link current = first;
		
		while(current != null && key != current.getId()){
			previous = current;
			current = current.getNext();
		}
		
		if(previous==null){
			first = first.getNext();
		} else {
			previous.setNext(current.getNext());
		}
	}
	
	public Link remove(){
		Link temp = first;
		first = first.getNext();
		return temp;
	}
	
	public Link find(int key){
		Link current = first;
		
		while(current != null && current.getId() <= key){
			if(current.getId() == key){
				return current;
			}
			current = current.getNext();
		}
		return null;
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
