package com.hlx.test.array;

import com.hlx.array.SelectSortArray;

public class SelectSortArrayTest {
	public static void main(String[] args) {
		SelectSortArray array = new SelectSortArray(10);
		
		array.insert(12);
		array.insert(56);
		array.insert(9);
		array.insert(454);
		array.insert(987);
		array.insert(1245);
		array.insert(654);
		array.insert(45);
		array.insert(6);
		array.insert(100);
		
		array.display();
		
		array.selectSort();
		
		array.display();
		
		System.out.println(array.find(12));
		System.out.println(array.find(13));
		
	}
}
