package com.hlx.test.linklist;

import com.hlx.algorithm.linklist.LinkQueue;

public class LinkQueueTest {
	public static void main(String[] args) {
		
		LinkQueue theList = new LinkQueue();
		theList.insert(22);
		theList.insert(33);
		theList.displayQueue();
		
		theList.insert(44);
		theList.insert(55);
		
		theList.displayQueue();
		
		theList.remove();
		theList.remove();
		
		
		theList.displayQueue();
	}
}
