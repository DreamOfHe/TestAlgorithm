package com.hlx.test.linklist;

import com.hlx.linklist.DoublyLinkListDeque;

public class DoublyLinkListDequeTest {
	public static void main(String[] args){
		DoublyLinkListDeque theList = new DoublyLinkListDeque();
		
		theList.insertLeft(22);
		theList.insertLeft(55);
		theList.insertLeft(44);

		theList.insertRight(11);
		theList.insertRight(66);
		theList.insertRight(33);
		
		theList.display();
		
		theList.removeLeft();
		theList.removeRight();
		
		theList.display();
	}
}
