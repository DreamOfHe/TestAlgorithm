package com.hlx.test;

import com.hlx.array.BubbleSortArray;

public class BubbleSortArrayTest {
	public static void main(String[] args) {
		
		int maxSize = 20;
		BubbleSortArray array = new BubbleSortArray(maxSize);
			
		for(int j=0; j<maxSize; j++){
			long n = (long)(Math.random()*(maxSize -1));
			array.insert(n);
		}
			
		array.display();
		array.oddEvenSort();
		array.display();
		
	}
}
