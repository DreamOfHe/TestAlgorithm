package com.hlx.algorithm.array;

public class QuickSortArray1 {

	private long[] array;
	private int nElems;
	
	private long compareCount; // compare count
	private long copyCount;    // copy count
	
	public QuickSortArray1(int max){
		array = new long[max];
		nElems = 0;
		compareCount = 0;
		copyCount = 0;
	}
	
	public long getCompareCount() {
		return compareCount;
	}

	public long getCopyCount() {
		return copyCount;
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
	
	public void quickSort(){
		recQuickSort(0, nElems-1);
	}
	
	private void recQuickSort(int left, int right){
		if(right-left <= 0){ // if size <= 1, already sorted
			return;
		} else {  // size is 2 or larger
			long pivot = array[right];
			
			int partition = partitionIt(left, right, pivot);
			recQuickSort(left, partition-1);
			recQuickSort(partition+1, right);
		}
	}
	
	public int partitionIt(int left, int right, long pivot){
		int leftPtr = left - 1;
		int rightPtr = right;
		while(true){
			do{
				compareCount++;
			}while(array[++leftPtr] < pivot);
			
			do{
				compareCount++;
			}while(rightPtr > 0 && array[--rightPtr] > pivot);

			if(leftPtr >= rightPtr){ // if pointers cross, partition done
				break;
			} else {
				swap(leftPtr, rightPtr); // swap elements
			}
			
			compareCount++;
		}
		swap(leftPtr, right);  // restore pivot
		return leftPtr;
	}
	
	private void swap(int dex1, int dex2){
		long temp = array[dex1];
		array[dex1] = array[dex2];
		array[dex2] = temp;
		copyCount += 3;
	}
}
