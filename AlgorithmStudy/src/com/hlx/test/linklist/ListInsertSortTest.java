package com.hlx.test.linklist;

import com.hlx.linklist.Link;
import com.hlx.linklist.ListInsertSort;

public class ListInsertSortTest {

	public static void main(String[] args) {
		int size = 10;
		
		Link[] linkArray = new Link[size];
		
		for(int j=0; j<size; j++){
			int n = (int)(Math.random()*99);
			Link newLink = new Link(n);
			linkArray[j] = newLink;
		}
		
		System.out.print("Unsorted array: ");
		for(int j=0; j<size; j++){
			System.out.print(linkArray[j].getId() + " ");
		}
		System.out.println("");
		
		ListInsertSort theSortedList = new ListInsertSort(linkArray);
		
		for(int j=0; j<size; j++){ // links from list to array
			linkArray[j] = theSortedList.remove();
		}
		
		System.out.print("Sorted array: ");
		for(int j=0; j<size; j++){
			System.out.print(linkArray[j].getId() + " ");
		}
		System.out.println("");
		
	}

}
