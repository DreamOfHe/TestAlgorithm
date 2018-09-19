package com.hlx.test.linklist;

import com.hlx.linklist.DoublyLinkList;

public class DoublyLinkListTest {
	public static void main(String[] args){
		DoublyLinkList theList = new DoublyLinkList();
		
		theList.insertFirst(22);
		theList.insertFirst(55);
		theList.insertFirst(44);

		theList.insertLast(11);
		theList.insertLast(66);
		theList.insertLast(33);
		
		theList.displayForward();
		theList.displayBackward();
		
		theList.deleteFirst();
		theList.deleteLast();
		theList.deleteKey(11);
		
		theList.displayForward();
		
		theList.insertAfter(22, 77);
		theList.insertAfter(55, 99);
		
		theList.displayForward();
	}
}
