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
	
	public int partitionIt1(int left, int right, long pivot){
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
	
	public int partitionIt2(int left, int right){ // programming work 7.1 
		int leftPtr = left - 1;
		int rightPtr = right;
		
		long pivot = array[right];
		while(true){
			while(array[++leftPtr] < pivot) // find bigger item
				; // nop
			while(rightPtr > left && array[--rightPtr] > pivot) // find smaller item
				;
			if(leftPtr >= rightPtr){ // if pointers cross, partition done
				break;
			} else {
				swap(leftPtr, rightPtr); // swap elements
			}
		}
		
		swap(leftPtr, right);
		return leftPtr; // return partition
	}
	
	public long findMedian(int left, int right){ // programming work 7.3
		
		int center = size() / 2;
		int pivot = partitionIt2(left, right);
		
		if(pivot == center){
			return array[pivot];
		} else if(pivot > center){
			return findMedian(left , pivot - 1);
		} else{
			return findMedian(pivot + 1, right);
		}
	}
	
	public long findByIndex(int left, int right, int index){
		if(index >= size()){
			System.out.println("Index is out of array");
			return -1;
		}
		
		return findIndex(left, right, index);
	}
	
	public long findIndex(int left, int right, int index){ // programming work 7.4
		
		int pivot = partitionIt2(left, right);
		
		if(pivot == index){
			return array[pivot];
		} else if(pivot > index){
			return findIndex(left , pivot - 1, index);
		} else{
			return findIndex(pivot + 1, right, index);
		}
	}
	
	private void swap(int dex1, int dex2){
		long temp = array[dex1];
		array[dex1] = array[dex2];
		array[dex2] = temp;
	}
}
