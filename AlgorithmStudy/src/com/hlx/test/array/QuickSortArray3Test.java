package com.hlx.test.array;

import com.hlx.algorithm.array.QuickSortArray3;


public class QuickSortArray3Test {

	public static void main(String[] args){
		int maxSize = 20;
		QuickSortArray3 arr = new QuickSortArray3(maxSize);
		
		for(int j=0; j<maxSize; j++){
			long n = (int)(Math.random()*99);
			arr.insert(n);
		}
	
		arr.display();
		arr.quickSort();
		arr.display();
	}
}
