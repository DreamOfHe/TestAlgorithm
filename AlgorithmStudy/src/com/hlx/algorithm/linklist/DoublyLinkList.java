package com.hlx.algorithm.linklist;

public class DoublyLinkList {
	private DoublyLink first;
	private DoublyLink last;
	
	public DoublyLinkList(){
		first = null;
		last = null;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public void insertFirst(int id){ // insert at front of list
		DoublyLink newLink = new DoublyLink(id);
		
		if(this.isEmpty()){
			last = newLink;
		} else {
			first.setPrevious(newLink);
		}
		newLink.setNext(first);
		first = newLink;
	}
	
	public void insertLast(int id){
		DoublyLink newLink = new DoublyLink(id);
		
		if(this.isEmpty()){
			first = newLink;
		} else {
			last.setNext(newLink);
			newLink.setPrevious(last);
		}
		last = newLink;
	}
	
	public DoublyLink deleteFirst(){
		DoublyLink temp = first;
		if(first.getNext() == null){
			last = null;
		} else {
			first.getNext().setPrevious(null);
		}
		first = first.getNext();
		return temp;
	}
	
	public DoublyLink deleteLast(){
		DoublyLink temp = last;
		if(first.getNext() == null){
			first = null;
		} else {
			last.getPrevious().setNext(null);
		}
		last = last.getPrevious();
		return temp;
	}
	
	public boolean insertAfter(int key, int id){ // insert id just after key
		DoublyLink current = first;
		while(current.getId() != key){
			current = current.getNext();
			if(current == null){
				return false;
			}
		}
		
		DoublyLink newLink = new DoublyLink(id);
		
		if(current == last){
			newLink.setNext(null);
			last = newLink;
		} else {
			newLink.setNext(current.getNext());
			current.getNext().setPrevious(newLink);
		}
		newLink.setPrevious(current);
		current.setNext(newLink);
		return true;
	}
	
	public DoublyLink deleteKey(int key){
		DoublyLink current = first;
		while(current.getId() != key){
			current = current.getNext();
			if(current == null){
				return null;
			}
		}
		
		if(current == first){
			first = current.getNext();
		} else {
			current.getPrevious().setNext(current.getNext());
		}
		
		if(current == last){
			last = current.getPrevious();
		} else {
			current.getNext().setPrevious(current.getPrevious());
		}
		
		return current;
	}
	
	public void displayForward(){
		System.out.print("List (first-->last): ");
		DoublyLink current = first;
		while(current != null){
			current.displayLink();
			current = current.getNext();
		}
		System.out.println("");
	}
	
	public void displayBackward(){
		System.out.print("List (last-->first): ");
		DoublyLink current = last;
		while(current != null){
			current.displayLink();
			current = current.getPrevious();
		}
		System.out.println("");	
	}
}
