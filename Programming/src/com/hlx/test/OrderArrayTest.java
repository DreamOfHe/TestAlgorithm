package com.hlx.test;

import com.hlx.Array.OrderArray;

public class OrderArrayTest {

	public static void main(String[] args){
		int maxSize = 9;
		OrderArray arr = new OrderArray(maxSize);
		
		arr.insertByBinary(11);
		arr.insertByBinary(22);
		arr.insertByBinary(15);
		arr.insertByBinary(16);
		arr.insertByBinary(10);
		arr.insertByBinary(12);
		
		arr.display();
		
		
		int maxSizeMerge = 6;
		OrderArray arrMerge = new OrderArray(maxSizeMerge);
		arrMerge.insertByBinary(456);
		arrMerge.insertByBinary(6);
		arrMerge.insertByBinary(20);
		
		arrMerge.display();
		
		OrderArray resultArr = arrMerge.merge(arr);
		
		resultArr.display();
		
		resultArr.delete(11);
		
		resultArr.display();
		
	}
}
