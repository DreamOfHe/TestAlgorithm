package com.hlx.test.heap;

import java.io.IOException;

import com.hlx.algorithm.heap.Heap;
import com.hlx.algorithm.heap.HeapNode;
import com.hlx.common.MyMethod;

public class HeapSortTest {
	public static void main(String[] args) throws IOException {
		int size, j;
		System.out.print("Enter number of items: ");
		size = MyMethod.getInt();
		Heap theHeap = new Heap(size);
		
		// fill array with random nodes
		for(j=0; j<size; j++){
			int random = (int) (Math.random() * 100);
			HeapNode newNode = new HeapNode(random);
			theHeap.insertAt(j, newNode);
			theHeap.incrementSize();
		}
		
		System.out.print("Random: ");
		theHeap.displayArray();
		
		// make random array into heap
		theHeap.makeArrayToHeap();
		
		System.out.print("\nHeap: ");
		theHeap.displayArray();
		theHeap.displayHeap();
		
		// remove from heap and store at array end
		for(j=size-1; j>=0; j--){
			HeapNode biggestNode = theHeap.remove();
			theHeap.insertAt(j, biggestNode);
		}
		
		System.out.print("Sorted: ");
		theHeap.displayArray();
	}
}
