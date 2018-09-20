package com.hlx.algorithm.linklist;

public class Link {
	private int id;
	private Link next;
	
	public Link(int id){
		this.id = id;
	}
	
	public void displayLink(){
		System.out.print(id + " ");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Link getNext() {
		return next;
	}

	public void setNext(Link next) {
		this.next = next;
	}
}
