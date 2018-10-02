package com.hlx.test.heap;

import java.io.IOException;

import com.hlx.algorithm.heap.Heap;
import com.hlx.common.MyMethod;

public class HeapTest {
	public static void main(String[] args) throws IOException {
		int value, value2;
		Heap theHeap = new Heap(31);
		boolean success;
		
		theHeap.insert(70);
		theHeap.insert(40);
		theHeap.insert(50);
		theHeap.insert(20);
		theHeap.insert(60);
		theHeap.insert(100);
		theHeap.insert(80);
		theHeap.insert(30);
		theHeap.insert(10);
		theHeap.insert(90);
		
		while(true){
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, delete, or find: ");
			char choice = MyMethod.getChar();
			switch(choice){
			case 's':
				theHeap.displayHeap();
				break;
			case 'i':
				System.out.print("Enter key value to insert: ");
				value = MyMethod.getInt();
				success = theHeap.insert(value);
				if(!success){
					System.out.println("Can't insert; heap full");
				}
				break;
			case 'r':
				if(!theHeap.isEmpty()){
					theHeap.remove();
				} else {
					System.out.println("Can't remove; heap empty");
				}
				break;
			case 'c':
				System.out.print("Enter current index of item: ");
				value = MyMethod.getInt();
				System.out.print("Enter new key: ");
				value2 = MyMethod.getInt();
				success = theHeap.change(value, value2);
				if(!success){
					System.out.println("Invalid index");
				}
				break;
			default:
				System.out.print("Invalid entry\n");
			}
		}
	}
}
