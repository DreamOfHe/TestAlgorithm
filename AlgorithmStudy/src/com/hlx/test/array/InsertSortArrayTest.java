package com.hlx.test.array;

import com.hlx.array.InsertSortArray;

public class InsertSortArrayTest {

	public static void main(String[] args){
		InsertSortArray array = new InsertSortArray(9);
		
		array.insert(10);
		array.insert(10);
		array.insert(9);
		array.insert(8);
		array.insert(9);
		array.insert(8);
		array.insert(6);
		array.insert(5);
		array.insert(10);
		
		
		array.display();
		
		array.noDups();
		
		array.display();
		

	}
}
