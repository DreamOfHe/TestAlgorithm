package com.hlx.array;

public class BubbleSortArray {

	private long[] array;
	private int nElems;
	
	public BubbleSortArray(int max){
		array = new long[max];
		nElems = 0;
	}
	
	public void insert(long value){
		array[nElems] = value;
		nElems++;
	}
	
	public int find(long value){
		int j;
		for(j=0; j<nElems ; j++){
			if(array[j] == value){
				break;
			}
		}
		return (j==nElems) ? -1 : j;
	}
	
	public int delete(long value){
		int j = find(value);
		if(j != -1){
			for(int k=j; k<nElems-1; k++){
				array[k] = array[k+1];
			}
			nElems--;
		}
		return j;
	}
	
	public void display(){
		for(int j=0; j<nElems; j++){
			System.out.print(array[j] + " ");
		}
		System.out.println("");
	}
	
	public void bubbleSort(){
		int in, out;
		for(out=nElems-1; out>1; out--){
			for(in=0; in<out; in++){
				if(array[in]>array[in+1]){
					swap(in, in+1);
				}
			}
		}
	}
	
	private void swap(int one, int two){
		long temp = array[one];
		array[one] = array[two];
		array[two] = temp;
	}
}
