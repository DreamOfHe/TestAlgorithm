package com.hlx.algorithm.linklist;

public class LinkListIterator {

	private Link current;
	private Link previous;
	private LinkList2 ourList;
	
	public LinkListIterator(LinkList2 list){
		ourList = list;
		reset();
	}
	
	public void reset(){ // start at 'first'
		current = ourList.getFirst();
		previous = null;
	}
	
	public boolean atEnd(){ // true if last link
		return (current.getNext() == null);
	}
	
	public void nextLink(){ // go to next link
		previous = current;
		current = current.getNext();
	}
	
	public Link getCurrent(){ // get current link
		return current;
	}
	
	public void insertAfter(int id){ // insert after current link
		Link newLink = new Link(id);
		
		if(ourList.isEmpty()){
			ourList.setFirst(newLink);
			current = newLink;
		} else {
			newLink.setNext(current.getNext());
			current.setNext(newLink);
			nextLink();
		}
	}
	
	public void insertBefore(int id){ // insert before current link
		Link newLink = new Link(id);
		
		if(previous == null){  // beginning of list (or empty list)
			newLink.setNext(ourList.getFirst());
			ourList.setFirst(newLink);
		} else {
			newLink.setNext(previous.getNext());
			previous.setNext(newLink);
			current = newLink;
		}
	}
	
	public int deleteCurrent(){ // delete item at current
		int value = current.getId();
		if(previous == null){ // beginning of list
			ourList.setFirst(current.getNext());
			reset();
		} else {
			previous.setNext(current.getNext());
			if(atEnd()){
				reset();
			} else {
				current = current.getNext();
			}
		}
		return value;
	}
	
}
