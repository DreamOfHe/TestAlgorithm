package com.hlx.test.tree;

import java.io.IOException;

import com.hlx.algorithm.tree.BinarySearchTreePriorityQ;

//programming work 12.4
public class BinarySearchTreePriorityQTest {
	public static void main(String[] args) throws IOException {
		BinarySearchTreePriorityQ thePQ = new BinarySearchTreePriorityQ();
		
		thePQ.insert(10);
		thePQ.insert(20);
		thePQ.insert(30);
		thePQ.insert(40);
		thePQ.insert(50);
		
		System.out.println(thePQ.remove());
		System.out.println(thePQ.peek());
		
		while(!thePQ.isEmpty()){
			System.out.print(thePQ.remove() + " ");
		}
	}
}
