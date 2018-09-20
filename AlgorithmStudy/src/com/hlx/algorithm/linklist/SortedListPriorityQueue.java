package com.hlx.algorithm.linklist;

public class SortedListPriorityQueue {  // programming work 5.1
	private SortedList theList;
	
	public SortedListPriorityQueue(){
		theList = new SortedList();
	}
	
	public void insert(int id){
		theList.insert(id);
	}
	
	public Link remove(){
		return theList.remove();
	}
	
	public boolean isEmpty() {
		return theList.isEmpty();
	}

	public void display() {
		theList.displayList();
	}
}
