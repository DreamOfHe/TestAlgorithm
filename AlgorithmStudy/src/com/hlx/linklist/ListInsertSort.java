package com.hlx.linklist;

public class ListInsertSort {
	
	private Link first;
	
	public ListInsertSort(){
		first = null;
	}
	
	public ListInsertSort(Link[] linkArr){ // constructor (arrary as argument)
		first = null;
		for(int j=0; j<linkArr.length; j++){
			insert(linkArr[j]);
		}
	}
	
	public boolean isEmpty(){
		return (first==null);
	}
	
	public void insert(Link k){
		Link previous = null;
		Link current = first;
		
		while(current != null && k.getId() > current.getId()){
			previous = current;
			current = current.getNext();
		}
		
		if(previous == null){ // at beginning of list
			first = k;
		} else {
			previous.setNext(k);
		}
		
		k.setNext(current);
		
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
