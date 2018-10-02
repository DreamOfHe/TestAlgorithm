package com.hlx.test.hash;

import java.io.IOException;

import com.hlx.algorithm.hash.HashTree;
import com.hlx.algorithm.tree.TreeNode;
import com.hlx.common.MyMethod;

public class HashTreeTest {
	public static void main(String[] args) throws IOException {
		TreeNode aDataItem;
		int aKey, size, n, keysPerCell = 100;
		
		System.out.print("Enter size of hash table: ");
		size = MyMethod.getInt();
		System.out.print("Enter initial number items: ");
		n = MyMethod.getInt();
		
		HashTree theHashTable = new HashTree(size);
		
		for(int j=0; j<n; j++){
			aKey = (int) (Math.random() * keysPerCell * size);
			theHashTable.insert(aKey);
		}
		
		while(true){
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, delete, or find: ");
			char choice = MyMethod.getChar();
			switch(choice){
			case 's':
				theHashTable.displayTable();
				break;
			case 'i':
				System.out.print("Enter key value to insert: ");
				aKey = MyMethod.getInt();
				theHashTable.insert(aKey);
				break;
			case 'd':
				System.out.print("Enter key value to delete: ");
				aKey = MyMethod.getInt();
				theHashTable.delete(aKey);
				break;
			case 'f':
				System.out.print("Enter key value to find: ");
				aKey = MyMethod.getInt();
				aDataItem = theHashTable.find(aKey);
				if(aDataItem != null){
					System.out.println("Found " + aKey);
				} else {
					System.out.println("Could not find " + aKey);
				}
				break;
			default:
				System.out.print("Invalid entry\n");
			}
		}
	}
}
