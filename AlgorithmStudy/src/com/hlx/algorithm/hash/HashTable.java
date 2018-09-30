package com.hlx.algorithm.hash;

public class HashTable {
	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;                     // for deleted items
	private int number;                           // number of DataItem
	
	public HashTable(int size){
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);               //  deleted item key is -1
		number = 0;
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
	
	// programming work 11.3
	public int hashFunc1(int key){
		int hashVal = 0;
		int length = String.valueOf((arraySize -1)).length();
		String skey = String.valueOf(key);
		int i = 0;
		for(; i+length < skey.length(); i+=length){
			String str = skey.substring(i, i+length);
			hashVal += Integer.valueOf(str).intValue();
		}
		if(i < skey.length()){
			String str = skey.substring(i);
			hashVal += Integer.valueOf(str).intValue();
		}
		return hashVal % arraySize;
	}
	
	// programming work 11.4
	public void rehash(){
		int resize = getPrime(arraySize * 2);
		System.out.println(resize);
		HashTable ht = new HashTable(resize);
		for(int i=0; i<arraySize; i++){
			if(hashArray[i] != null && hashArray[i].getKey() != -1){
				ht.insert(hashArray[i]);
			}
		}
	}
	
	private int getPrime(int min){
		for(int j = min + 1; true; j++){
			if(isPrime(j)){
				return j;
			}
		}
	}
	
	private boolean isPrime(int j){
		for(int i=2; i*i < j; i+=2){
			if(j%i == 0){
				return false;
			}
		}
		return true;
	}
	
	public void insert(DataItem item){
		// assumes table not full
		if(number / (float)arraySize > 0.5){
			rehash();
		}
		
		int key = item.getKey();
		int hashVal = hashFunc(key);
		int i = 1, index = hashVal;
		
		while(hashArray[index] != null 
				&& hashArray[index].getKey() != -1){
			// programming work 11.1
			index = hashVal + i * i;
			i++;
			index %= arraySize;                     // wrap around if necessary
		}
		number++;
		hashArray[index] = item;
	}
	
	public DataItem delete(int key){
		int hashVal = hashFunc(key);
		
		int i = 1, index = hashVal;
		while(hashArray[index] != null){
			if(hashArray[index].getKey() == key){
				DataItem temp = hashArray[index];
				hashArray[index] = nonItem;        // delete item
				number--;
				return temp;
			}
			// programming work 11.1
			index = hashVal + i * i;
			i++;
			index %= arraySize;
		}
		return null;                                 // can't find item 
	}
	
	public DataItem find(int key){
		int hashVal = hashFunc(key);
		
		int i = 1, index = hashVal;
		while(hashArray[index] != null){
			if(hashArray[index].getKey() == key){
				return hashArray[index];
			}
			// programming work 11.1
			index = hashVal + i * i;
			i++;
			index %= arraySize;
		}
		return null;
	}
}
