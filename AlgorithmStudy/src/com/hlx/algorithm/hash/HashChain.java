package com.hlx.algorithm.hash;

import com.hlx.algorithm.linklist.Link;
import com.hlx.algorithm.linklist.SortedList;

public class HashChain {
	private SortedList[] hashArray;
	private int arraySize;
	
	public HashChain(int size){
		arraySize = size;
		hashArray = new SortedList[arraySize];
		
		for(int j=0; j<arraySize; j++){
			hashArray[j] = new SortedList();
		}
	}
	
	public int hashFunc(int key){
		return key % arraySize;
	}
	
	public void displayTable(){
		System.out.print("Table: \n");
		for(int j=0; j<arraySize; j++){
			System.out.print(j + ". ");
			hashArray[j].displayList();
		}
		System.out.println("");
	}

	public void insert(Link theLink){
		// assumes table not full
		int key = theLink.getId();
		int hashVal = hashFunc(key);
		hashArray[hashVal].insertLink(theLink);
	}
	
	public void delete(int key){
		int hashVal = hashFunc(key);
		hashArray[hashVal].delete(key);
	}
	
	public Link find(int key){
		int hashVal = hashFunc(key);
		Link theLink = hashArray[hashVal].find(key);
		return theLink;
	}
}
