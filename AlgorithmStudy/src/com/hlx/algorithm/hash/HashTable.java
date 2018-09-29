package com.hlx.algorithm.hash;

public class HashTable {
	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;                     // for deleted items
	
	public HashTable(int size){
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);               //  deleted item key is -1
	}
	
	public void displayTable(){
		System.out.print("Table: ");
		for(int j=0; j<arraySize; j++){
			if(hashArray[j]!=null){
				System.out.print(hashArray[j].getKey() + " ");
			} else {
				System.out.print("** ");
			}
		}
		System.out.println("");
	}
	
	public int hashFunc(int key){
		return key % arraySize;                       // hash function
	}
	
	public void insert(DataItem item){
		// assumes table not full
		int key = item.getKey();
		int hashVal = hashFunc(key);
		
		while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
			++hashVal;
			hashVal %= arraySize;                     // wrap around if necessary
		}
		hashArray[hashVal] = item;
	}
	
	public DataItem delete(int key){
		int hashVal = hashFunc(key);
		while(hashArray[hashVal] != null){
			if(hashArray[hashVal].getKey() == key){
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;        // delete item
				return temp;
			}
			++hashVal;
			hashVal %= arraySize;
		}
		return null;                                 // can't find item 
	}
	
	public DataItem find(int key){
		int hashVal = hashFunc(key);
		while(hashArray[hashVal] != null){
			if(hashArray[hashVal].getKey() == key){
				return hashArray[hashVal];
			}
			++hashVal;
			hashVal %= arraySize;
		}
		return null;
	}
}
