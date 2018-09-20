package com.hlx.test.linklist;

import com.hlx.linklist.SortedListPriorityQueue;

public class SortedListPriorityQueueTest {
	public static void main(String[] args){
		SortedListPriorityQueue theList = new SortedListPriorityQueue();
		theList.insert(22);
		theList.insert(55);
		theList.insert(44);
		theList.insert(66);
		
		theList.display();
		
		theList.remove();
		
		theList.display();
	}
}
