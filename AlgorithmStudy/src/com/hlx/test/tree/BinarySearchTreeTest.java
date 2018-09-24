package com.hlx.test.tree;

import java.io.IOException;

import com.hlx.algorithm.tree.BinarySearchTree;
import com.hlx.algorithm.tree.TreeNode;
import com.hlx.common.MyMethod;

public class BinarySearchTreeTest {
	public static void main(String[] args) throws IOException {
		int value;
		BinarySearchTree theTree = new BinarySearchTree();
		
		theTree.insert(50);
		theTree.insert(25);
		theTree.insert(75);
		theTree.insert(12);
		theTree.insert(37);
		theTree.insert(43);
		theTree.insert(30);
		theTree.insert(33);
		theTree.insert(87);
		theTree.insert(93);
		theTree.insert(97);
		
		while(true){
			System.out.print("Enter fisrt letter of show, ");
			System.out.print("insert, find, delete, or traverse: ");
			int choice = MyMethod.getChar();
			
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
				TreeNode found = theTree.find(value);
				if(found != null){
					System.out.print("Found: ");
					found.displayNode();
					System.out.println();
				} else {
					System.out.println("Could not find value");
				}
				break;
			case 'd':
				System.out.print("Enter value to delete: ");
				value = MyMethod.getInt();
				boolean didiDelete = theTree.delete(value);
				if(didiDelete){
					System.out.println("Deleted " + value);
				} else {
					System.out.println("Could not delete " + value);
				}
				break;
			case 't':
				System.out.print("Enter type 1, 2 or 3: ");
				value = MyMethod.getInt();
				theTree.traverse(value);
				break;
			default:
				System.out.println("Invalid entry");
			}
		}
	}
}
