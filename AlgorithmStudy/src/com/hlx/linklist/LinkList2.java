package com.hlx.linklist;

public class LinkList2 {
	
	private Link first;
	
	public LinkList2(){
		first = null;
	}
	
	public boolean isEmpty(){
		return (first==null);
	}
	
	public Link getFirst() {
		return first;
	}

	public void setFirst(Link first) {
		this.first = first;
	}

	public LinkListIterator getIterator(){
		return new LinkListIterator(this);
	}
	
	public void displayList(){
		Link current = first;
		while(current !=null ){
			current.displayLink();
			current = current.getNext();
		}
		System.out.println("");
	}
}
