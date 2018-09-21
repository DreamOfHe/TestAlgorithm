package com.hlx.test.array;

import com.hlx.algorithm.array.PartitionArray;

public class PartitionArrayTest {

	public static void main(String[] args){
		int maxSize = 20;
		PartitionArray arr = new PartitionArray(maxSize);
		
		for(int j=0; j<maxSize; j++){
			long n = (int)(Math.random()*199);
			arr.insert(n);
		}
	
		arr.display();
		
		long pivot = 99;
		int partDex = arr.partitionIt(0, arr.size() - 1, pivot);
		System.out.println("Partition is at index " + partDex);
		arr.display();
	}
}
