package com.hlx.test;

import com.hlx.array.ClassDataArray;
import com.hlx.array.Person;

public class ClassDataArrayTest {

	public static void main(String[] args){
		int maxSize = 9;
		ClassDataArray arr = new ClassDataArray(maxSize);
		
		arr.insert("A", "A1", 11);
		arr.insert("B", "B1", 22);
		arr.insert("C", "C1", 33);
		arr.insert("D", "D1", 44);
		arr.insert("E", "E1", 55);
		arr.insert("F", "F1", 66);
		arr.insert("G", "G1", 77);
		arr.insert("H", "H1", 88);
		arr.insert("I", "I1", 99);

		
		arr.displayArray();
		
		System.out.println("\n--------------------");
		
		arr.delete("A");
		
		arr.displayArray();
		
		String searchName = "H1";
		
		Person found = arr.find(searchName);
		if(found == null){
			System.out.println("\nCan't find " + searchName);
		} else {
			System.out.println("\nFound ");
			found.displayPerson();
		}
	}
}
