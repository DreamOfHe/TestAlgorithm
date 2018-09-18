package com.hlx.test;

import com.hlx.array.PriorityQueue1;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue1 theQueue = new PriorityQueue1(5);
		
		theQueue.insert(30);
		theQueue.insert(50);
		theQueue.insert(10);
		theQueue.insert(40);
		theQueue.insert(20);
		
		while(!theQueue.isEmpty()){
			long item = theQueue.remove();
			System.out.print(item + " ");
		}
		System.out.println("");
	}
}
