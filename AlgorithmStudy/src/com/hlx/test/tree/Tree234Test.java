package com.hlx.test.tree;

import java.io.IOException;

import com.hlx.algorithm.tree.Tree234;
import com.hlx.common.MyMethod;

public class Tree234Test {
	public static void main(String[] args) throws IOException {
		long value;
		Tree234 theTree = new Tree234();
		
		theTree.insert(50);
		theTree.insert(40);
		theTree.insert(60);
		theTree.insert(30);
		theTree.insert(70);
		
		while(true){
			System.out.print("Enter first letter of show, insert, order, min or find: ");
			char choice = MyMethod.getChar();
			switch(choice){
			case 's':
				theTree.displayTree();
				break;
			case 'i':
				System.out.print("Enter value to insert: ");
				value = MyMethod.getInt();
				theTree.insert(value);
				break;
			case 'f':
				System.out.print("Enter value to find: ");
				value = MyMethod.getInt();
				int found = theTree.find(value);
				if(found != -1){
					System.out.println("Found " + value);
				} else {
					System.out.println("Could not find " + value);
				}
				break;
			case 'm':
				long minValue = theTree.getMinValue();
				System.out.println("Min value is: " + minValue);
				break;
			case 'o':
				theTree.traverse(2);
				break;
			default:
				System.out.println("Invalid entry\n");
			}
		}
	}
}
