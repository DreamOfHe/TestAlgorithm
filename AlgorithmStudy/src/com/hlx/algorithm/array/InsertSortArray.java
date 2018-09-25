package com.hlx.algorithm.array;

public class InsertSortArray {
	
	private long[] array;
	private int nElems;
	
	public InsertSortArray(int max){
		array = new long[max];
		nElems = 0;
	}
	
	public void insert(long value){
		array[nElems] = value;
		nElems++;
	}
	
	public int find(long value){
		int j;
		for(j=0; j<nElems; j++){
			if(array[j]==value){
				break;
			}
		}
		return (j==nElems) ? -1 : j;
	}
	
	public int delete(long value){
		int j = find(value);
		if(j!=-1){
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
	
	// thinking by myself
	public void insertSort1(){
		int in, out;
		for(out=1; out<nElems; out++){
			long temp = array[out];
			for(in=out; in>0 && (array[in-1]>=temp); in--){
				array[in] = array[in-1];
			}
			array[in] = temp;
		}
	}
	
	// according book
	public void insertSort2(){
		int in, out;
		for(out=1; out<nElems; out++){
			long temp = array[out];
			in = out;
			while(in>0 && array[in-1] >=temp){
				array[in]=array[in-1];
				--in;
			}
			array[in] = temp;
		}
	}
	
	// // programming work 3.6
	public void insertSort3() {
		int in, out, count = 0;
		for (out = 1; out < nElems; out++) // out is dividing line
		{
			long temp = array[out]; // remove marked item
			in = out; // start shifts at out
			while (in > 0 && array[in - 1] >= temp && array[in - 1] != -1) // until one is smaller,
			{
				if (array[in - 1] == temp) {
					temp = -1;
					count++;
				}
				array[in] = array[in - 1]; // shift item to right
				--in; // go left one position
			}
			array[in] = temp; // insert marked item
		} // end for
		nElems -= count;
		for (int i = 0; i < nElems; i++) {
			array[i] = array[i + count];  // 把排好序的元素向前移动count个位置
		}
	} // end insertionSort()
	
	public long median(){ // programming work 3.2
		this.insertSort1();
		return array[nElems/2];
	}
	
	public void noDups(){ // programming work 3.3
		this.insertSort1();
		final long NULL = -1;
		for(int j=0; j<nElems-1; j++){
			if(array[j]==array[j+1]){
				array[j]=NULL;
			}
		}
		int order = 0;
		for (int temp = 0; temp < nElems; temp++) {
			if (array[temp] != NULL) {// // 因为a[0]不可能等于NIL所以才可以用这种方法
				if (temp > order) {
					array[order] = array[temp];
				}
				order++;
			}
		}
		nElems = order;
	}
}
