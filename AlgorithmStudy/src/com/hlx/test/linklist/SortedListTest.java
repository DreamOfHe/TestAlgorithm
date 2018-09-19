package com.hlx.test.linklist;

import com.hlx.linklist.SortedList;

public class SortedListTest {
	public static void main(String[] args){
		SortedList theList = new SortedList();
		theList.insert(22);
		theList.insert(55);
		theList.insert(44);
		theList.insert(66);
		
		theList.displayList();
		
		theList.remove();
		
		theList.displayList();
	}
}
