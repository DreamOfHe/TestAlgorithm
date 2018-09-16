package com.hlx.test;

import com.hlx.Array.BubbleSortArray;

public class BubbleSortArrayTest {
	public static void main(String[] args) {
			BubbleSortArray array = new BubbleSortArray(10);
			
			array.insert(99);
			array.insert(11);
			array.insert(22);
			array.insert(15);
			array.insert(36);
			array.insert(456);
			array.insert(5);
			array.insert(1234);
			array.insert(999);
			array.insert(26);
			
			array.display();
			
			array.bubbleSort();
			
			array.display();
			
			System.out.println(array.find(99));
			System.out.println(array.find(98));
	}
}
