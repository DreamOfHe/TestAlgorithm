package com.hlx.test.hash;

import java.io.IOException;

import com.hlx.algorithm.hash.HashString;
import com.hlx.algorithm.hash.StringDataItem;
import com.hlx.common.MyMethod;

public class HashStringTest {
	public static void main(String[] args) throws IOException {
		StringDataItem aDataItem;
		String aKey;
		int size, n;
		
		System.out.print("Enter size of hash table: ");
		size = MyMethod.getInt();
		System.out.print("Enter initial number items: ");
		n = MyMethod.getInt();
		
		HashString theHashTable = new HashString(size);
		
		for(int j=0; j<n; j++){
			StringBuffer sb = new StringBuffer();
			int length = (int) (Math.random() * 5 + 1);
			for(int i=0; i<length; i++){
				sb.append((char)(Math.random() * 26 + 97));
			}
			aDataItem = new StringDataItem(sb.toString());
			theHashTable.insert(aDataItem);
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
				aKey = MyMethod.getString();
				aDataItem = new StringDataItem(aKey);
				theHashTable.insert(aDataItem);
				break;
			case 'd':
				System.out.print("Enter key value to delete: ");
				aKey = MyMethod.getString();
				theHashTable.delete(aKey);
				break;
			case 'f':
				System.out.print("Enter key value to find: ");
				aKey = MyMethod.getString();
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
