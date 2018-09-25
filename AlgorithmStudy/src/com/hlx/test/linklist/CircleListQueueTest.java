package com.hlx.test.linklist;

import com.hlx.algorithm.linklist.CircleListQueue;
import com.hlx.algorithm.linklist.Link;

public class CircleListQueueTest {
	public static void main(String[] args) {
		CircleListQueue theQueue = new CircleListQueue(5); // queue holds 5 items

		theQueue.insert(10); // insert 4 items
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(40);

		theQueue.remove(); // remove 3 items
		theQueue.remove(); // (10, 20, 30)
		theQueue.remove();

		theQueue.insert(50); // insert 4 more items
		theQueue.insert(60); // (wraps around)
		theQueue.insert(70);
		theQueue.insert(80);

		theQueue.display();
		Link n = theQueue.remove(); // (40, 50, 60, 70, 80)
		System.out.print("删掉" );
		n.displayLink();
		System.out.println("\n队头元素是" + theQueue.peek());
		theQueue.display();

	} 
}
