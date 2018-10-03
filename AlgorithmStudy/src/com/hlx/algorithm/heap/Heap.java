package com.hlx.algorithm.heap;

public class Heap {
	private HeapNode[] heapArray;
	private int maxSize;
	private int currentSize;
	
	public Heap(int mx){
		maxSize = mx;
		currentSize = 0;
		heapArray = new HeapNode[maxSize];
	}
	
	public boolean isEmpty(){
		return currentSize == 0;
	}
	
	public boolean isFull(){
		return currentSize == maxSize;
	}
	
	public boolean insert(int key){
		if(currentSize == maxSize){
			return false;
		}
		HeapNode newNode = new HeapNode(key);
		heapArray[currentSize]  = newNode;
		trickleUp(currentSize++);
		return true;
	}
	
	public void insertAt(int index, HeapNode newNode){
		heapArray[index] = newNode;
	}
	
	private void trickleUp(int index){
		int parent = (index-1)/2;
		HeapNode bottom = heapArray[index];
		while(index > 0 && heapArray[parent].getKey() < bottom.getKey()){
			heapArray[index] = heapArray[parent];   // move it down
			index = parent;
			parent = (parent - 1)/2;
		}
		heapArray[index] = bottom;
	}
	
	// delete item with max key (assumes non-empty list)
	public HeapNode remove(){       
		HeapNode root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return root;
	}
	
	private void trickleDown(int index){
		int largerChild;
		HeapNode top = heapArray[index];    // save root
		while(index < currentSize/2){       // while node has at least one child
			int leftChild = 2*index + 1;
			int rightChild = leftChild + 1;
			
			// find larger child
			if(rightChild < currentSize &&  // (rightChild exist ?)
					heapArray[leftChild].getKey() < heapArray[rightChild].getKey()){
				largerChild = rightChild;
			} else {
				largerChild = leftChild;
			}
			
			// top >= largerChild ?
			if(top.getKey() >= heapArray[largerChild].getKey()){
				break;
			}
			
			// shift child up
			heapArray[index] = heapArray[largerChild];
			// go down
			index = largerChild;
		}
		// root to index
		heapArray[index] = top;
	}
	
	// make random array into heap
	public void makeArrayToHeap(){
		for(int j=currentSize/2-1; j>=0; j--){
			trickleDown(j);
		}
	}
	
	public boolean change(int index, int newValue){
		if(index<0 || index>=currentSize){
			return false;
		}
		int oldValue = heapArray[index].getKey();    // remember old
		heapArray[index].setKey(newValue);           // change to new
		
		if(oldValue < newValue){   // if raised, trickle it up
			trickleUp(index);
		} else {
			trickleDown(index);    // if lowered, trickle it down
		}
		return true;
	}
	
	public void incrementSize(){
		currentSize++;
	}
	
	// programming work 12.3
	public HeapNode peek(){
		return heapArray[0];
	}
	
	public void displayHeap(){
		System.out.print("\nheapArray: ");   // array format
		for(int m=0; m<currentSize; m++){
			if(heapArray[m] != null){
				System.out.print(heapArray[m].getKey() + " ");
			} else {
				System.out.print("-- ");
			}
		}
		System.out.println();
		
		// heap format
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0;     // current item
		String dots = "...............................................";
		System.out.println(dots + dots);   // dotted top line
		
		while(currentSize > 0){            // for each heap item
			if(column == 0){                       // first item in row ?
				for(int k=0; k<nBlanks; k++){      // preceding blanks
					System.out.print(' ');
				}
			}
			System.out.print(heapArray[j].getKey());   // display item
			if(++j == currentSize){                    // done ?
				break;
			}
			
			if(++column == itemsPerRow){               // end of row ?
				nBlanks /= 2;                          // half the blanks
				itemsPerRow *= 2;					   // twice the items
				column = 0;                            // start over on new row
				System.out.println();
			} else {                                   // next item on row
				for(int k=0; k<nBlanks*2 - 2; k++){
					System.out.print(' ');             // interim blanks
				}
			}
		}
		System.out.println("\n" + dots + dots);        // dotted bottom line
	}
	
	public void displayArray(){
		for(int j=0; j<maxSize; j++){
			System.out.print(heapArray[j].getKey() + " ");
		}
	}
}
