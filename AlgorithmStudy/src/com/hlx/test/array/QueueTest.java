package com.hlx.test.array;

import com.hlx.array.Queue1;

public class QueueTest {
	public static void main(String[] args) {
		Queue1 theQueue = new Queue1(5);
		
		theQueue.insert(10);
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(40);
		theQueue.insert(50);
		
		theQueue.remove();
		theQueue.remove();
		theQueue.remove();
		
		theQueue.insert(56);
		theQueue.insert(66);
		theQueue.insert(46);
		
		theQueue.displayQueue();
	}
}
