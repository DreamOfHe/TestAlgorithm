package com.hlx.test.linklist;

import com.hlx.algorithm.linklist.Link;
import com.hlx.algorithm.linklist.LinkList1;

public class LinkListTest {
	public static void main(String[] args) {
		LinkList1 theList = new LinkList1();
		theList.insertFirst(22);
		theList.insertFirst(33);
		theList.insertFirst(44);
		theList.insertFirst(55);
		
		theList.displayList();
		
		Link f = theList.find(11);
		if(f != null){
			System.out.println("Found link with key " + f.getId());
		} else {
			System.out.println("Can't find link");
		}
		
		Link d = theList.delete(23);
		if(d != null){
			System.out.println("Deleted link with key " + d.getId());
		} else {
			System.out.println("Can't delete link");
		}
		
		theList.displayList();
	}
}
