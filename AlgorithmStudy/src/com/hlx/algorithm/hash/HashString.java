package com.hlx.algorithm.hash;

public class HashString { // programming work 11.2
	private StringDataItem[] hashArray;
	private int arraySize;
	private StringDataItem nonItem;                     // for deleted items
	
	public HashString(int size){
		arraySize = size;
		hashArray = new StringDataItem[arraySize];
		nonItem = new StringDataItem("--");               //  deleted item key is -1
	}
	
	public void displayTable(){
		System.out.print("Table: ");
		for(int j=0; j<arraySize; j++){
			if(hashArray[j]!=null){
				System.out.print(hashArray[j].getsData() + " ");
			} else {
				System.out.print("** ");
			}
		}
		System.out.println("");
	}
	
	public int hashFunc(String key){
		int hashVal = 0;
		for(int j=0; j<key.length(); j++){
			int letter = key.charAt(j);
			hashVal = (hashVal * 26 + letter) % arraySize;
		}
		return hashVal;
	}
	
	public void insert(StringDataItem item){
		// assumes table not full
		String key = item.getsData();
		int hashVal = hashFunc(key);
		
		while(hashArray[hashVal] != null 
				&& hashArray[hashVal].getsData().equals("--")){
			++hashVal;
			hashVal %= arraySize;                     // wrap around if necessary
		}
		hashArray[hashVal] = item;
	}
	
	public StringDataItem delete(String key){
		int hashVal = hashFunc(key);
		while(hashArray[hashVal] != null){
			if(hashArray[hashVal].getsData().equals(key)){
				StringDataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;        // delete item
				return temp;
			}
			++hashVal;
			hashVal %= arraySize;
		}
		return null;                                 // can't find item 
	}
	
	public StringDataItem find(String key){
		int hashVal = hashFunc(key);
		while(hashArray[hashVal] != null){
			if(hashArray[hashVal].getsData().equals(key)){
				return hashArray[hashVal];
			}
			++hashVal;
			hashVal %= arraySize;
		}
		return null;
	}
}
