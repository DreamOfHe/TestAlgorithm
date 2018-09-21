package com.hlx.algorithm.array;

public class QuickSortArray2 {

	private long[] array;
	private int nElems;
	
	public QuickSortArray2(int max){
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
	
	public void quickSort(){
		recQuickSort(0, nElems-1);
	}
	
	private void recQuickSort(int left, int right){
		int size = right - left + 1;
		if(size<3){ // manual sort if small
			manualSort(left, right);
		} else {
			long median = medianOf3(left, right);
			int partition = partitionIt(left, right, median);
			recQuickSort(left, partition-1);
			recQuickSort(partition+1, right);
		}
	}
	
	public long medianOf3(int left, int right){ // 三数据项取中
		
		int center = (left+right)/2;
		
		if(array[left] > array[center]){ // order left & center
			swap(left, center);
		}
		
		if(array[left] > array[right]){ // order left & right
			swap(left, right);
		}
		
		if(array[center] > array[right]){ // order center & right
			swap(center, right);
		}
		
		swap(center, right-1); // put pivot on right
		return array[right-1]; // return median value
	}
	
	public int partitionIt(int left, int right, long pivot){
		int leftPtr = left;  // right of first elem
		int rightPtr = right - 1; // left of pivot
		while(true){
			while(array[++leftPtr] < pivot) // find bigger item
				; // nop
			while(array[--rightPtr] > pivot) // find smaller item
				;
			if(leftPtr >= rightPtr){ // if pointers cross, partition done
				break;
			} else {
				swap(leftPtr, rightPtr); // swap elements
			}
		}
		swap(leftPtr, right-1);  // restore pivot
		return leftPtr;
	}
	
	private void manualSort(int left, int right){
		int size = right-left+1;
		if(size <= 1){
			return;
		}
		if(size == 2){
			if(array[left] > array[right]){
				swap(left, right);
			}
			return;
		} else {
			if(array[left]>array[right-1]){ // left, center
				swap(left, right-1);
			}
			if(array[left]>array[right]){   // left, right
				swap(left, right);
			}
			if(array[right-1]>array[right]){// center, right
				swap(right-1, right);
			}
		}
	}
	
	private void swap(int dex1, int dex2){
		long temp = array[dex1];
		array[dex1] = array[dex2];
		array[dex2] = temp;
	}
}
