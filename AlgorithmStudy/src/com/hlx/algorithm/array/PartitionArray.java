package com.hlx.algorithm.array;

public class PartitionArray {

	private long[] array;
	private int nElems;
	
	public PartitionArray(int max){
		array = new long[max];
		nElems = 0;
	}
	
	public void insert(long value){
		array[nElems] = value;
		nElems++;
	}
	
	public void display(){
		for(int j=0; j<nElems; j++){
			System.out.print(array[j] + " ");
		}
		System.out.println("");
	}
	
	public int size(){
		return nElems;
	}
	
	public int partitionIt(int left, int right, long pivot){
		int leftPtr = left - 1;
		int rightPtr = right + 1;
		
		while(true){
			while(leftPtr < right && array[++leftPtr] < pivot) // find bigger item
				; // nop
			while(rightPtr > left && array[--rightPtr] > pivot) // find smaller item
				;
			if(leftPtr >= rightPtr){ // if pointers cross, partition done
				break;
			} else {
				swap(leftPtr, rightPtr); // swap elements
			}
		}
		return leftPtr; // return partition
	}
	
	private void swap(int dex1, int dex2){
		long temp = array[dex1];
		array[dex1] = array[dex2];
		array[dex2] = temp;
	}
}
