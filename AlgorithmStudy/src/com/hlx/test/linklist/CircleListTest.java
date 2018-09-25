package com.hlx.test.linklist;

import com.hlx.algorithm.linklist.CircleList;
import com.hlx.algorithm.linklist.Link;

public class CircleListTest {
	public static void main(String[] args){
		CircleList theList = new CircleList();
		theList.insert(10); // insert four items
		theList.insert(20); // insert four items
		theList.insert(40); // insert four items
		theList.insert(30); // insert four items
		theList.display(); // display list
		System.out.println("队头元素是" + theList.peek());
		Link link = theList.find(40);
		if (link != null) {
			System.out.println("find 40!");
		} else {
			System.out.println("not find 40!");
		}
		Link aLink = theList.remove(); // delete link
		System.out.print("Deleted " ); // display it
		aLink.displayLink();
		System.out.println();
		theList.display(); // display list
	}
}
