package com.hlx.test.array;

import com.hlx.algorithm.array.InsertSortPerson;

public class InsertSortPersonTest {

	public static void main(String[] args){
		int maxSize = 9;
		InsertSortPerson arr = new InsertSortPerson(maxSize);
		
		arr.insert("I", "A1", 11);
		arr.insert("H", "B1", 22);
		arr.insert("G", "C1", 33);
		arr.insert("F", "D1", 44);
		arr.insert("E", "E1", 55);
		arr.insert("D", "F1", 66);
		arr.insert("C", "G1", 77);
		arr.insert("B", "H1", 88);
		arr.insert("A", "I1", 99);

		
		arr.displayArray();
		
		System.out.println("\n--------------------");
		
		arr.insertSort();
		
		arr.displayArray();
		
		
	}
}
