package com.hlx.test.heap;

import com.hlx.algorithm.heap.HeapPriorityQ;

public class HeapPriorityQTest {
	public static void main(String[] args) {
		HeapPriorityQ thePQ = new HeapPriorityQ(5);
		thePQ.insert(50);
		thePQ.insert(40);
		thePQ.insert(30);
		thePQ.insert(20);
		thePQ.insert(10);
		
		System.out.println(thePQ.remove());
		System.out.println(thePQ.peek());
		
		while(!thePQ.isEmpty()){
			System.out.print(thePQ.remove() + " ");
		}
		System.out.println();
	}
}
