package com.hlx.algorithm.linklist;

public class DoublyLink {
	public long id;
	public DoublyLink next;
	public DoublyLink previous;
	
	public DoublyLink(int id){
		this.id = id;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DoublyLink getNext() {
		return next;
	}

	public void setNext(DoublyLink next) {
		this.next = next;
	}

	public DoublyLink getPrevious() {
		return previous;
	}

	public void setPrevious(DoublyLink previous) {
		this.previous = previous;
	}

	public void displayLink(){
		System.out.print(id + " ");
	}
}
