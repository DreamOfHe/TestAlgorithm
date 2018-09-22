package com.hlx.test.array;

import com.hlx.algorithm.array.QuickSortArray2;


public class QuickSortArray2Test {

	public static void main(String[] args){
		int maxSize = 20;
		QuickSortArray2 arr = new QuickSortArray2(maxSize);
		
		/*
		for(int j=0; j<maxSize; j++){
			long n = (int)(Math.random()*99);
			arr.insert(n);
		}*/
	
		arr.insert(6);
		arr.insert(5);
		arr.insert(4);
		arr.insert(3);
		arr.insert(2);
		arr.insert(1);
		
		arr.display();
		arr.quickSort();
		arr.display();
		
		System.out.println("compare count = " + arr.getCompareCount());
		System.out.println("copy count = " + arr.getCopyCount());
	}
}
