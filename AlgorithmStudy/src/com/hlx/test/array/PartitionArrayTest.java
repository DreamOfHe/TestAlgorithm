package com.hlx.test.array;

import com.hlx.algorithm.array.PartitionArray;

public class PartitionArrayTest {

	public static void main(String[] args){
		int maxSize = 9;
		PartitionArray arr = new PartitionArray(maxSize);
		
		for(int j=0; j<maxSize; j++){
			long n = (int)(Math.random()*199);
			arr.insert(n);
		}
			
		arr.display();
		long indexElem = 0;
		
		indexElem = arr.findByIndex(0, arr.size() - 1, 1);
		System.out.println("Find median is " + indexElem );
	}
}
