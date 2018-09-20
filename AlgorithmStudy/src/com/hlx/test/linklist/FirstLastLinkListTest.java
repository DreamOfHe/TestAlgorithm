package com.hlx.test.linklist;

import com.hlx.algorithm.linklist.FirstLastLinkList;

public class FirstLastLinkListTest {
	
	public static void main(String[] args) {
		
		FirstLastLinkList theList = new FirstLastLinkList();
		
		theList.insertFirst(22);
		theList.insertFirst(33);
		theList.insertFirst(44);

		theList.insertLast(66);
		theList.insertLast(88);
		theList.insertLast(99);
		
		theList.displayList();
		
		theList.deleteFirst();
		theList.deleteFirst();
		
		theList.displayList();
	}
}
