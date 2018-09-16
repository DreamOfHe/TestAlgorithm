package com.hlx.Array;

public class HighArray {

	private long[] array;
	private int nElems;
	
	public HighArray(int max){
		array = new long[max + 1];
		nElems = 0;
	}
	
	public boolean find(long searchKey){
		int j;
		for(j=0; j<nElems; j++){
			if(array[j]==searchKey){
				break;
			}
		}
		return (j==nElems) ? false:true;
	}
	
	public void insert(long value){
		array[nElems] = value;
		nElems++;
	}
	
	public long delete(long value){
		int j;
		for(j=0; j<nElems; j++){
			if(array[j] == value){
				break;
			}
		}
		if(j == nElems){
			return -1;
		} else {
			long deleteElem = array[j];
			for(int k=j; k<nElems; k++){
				array[k] = array[k+1];
			}
			nElems--;
			return deleteElem;
		}
	}
	
	public void display(){
		for(int j=0; j<nElems; j++){
			System.out.print(array[j] + " ");
		}
		System.out.println("");
	}
	
	public long getMax(){  // programming work 2.1
			long max = -1;
			for(int j=0; j<nElems; j++){
				if(max < array[j]){
					max = array[j];
				}
			}
			return max;
	}
	
	public long removeMax(){  // programming work 2.2
		return (getMax() == -1) ? -1 : delete(getMax());
	}
	

	// begin programming work 2.6
	// the first method
	public void noDup1() {
		int NULL = -1;
		for (int j = 0; j < nElems; j++) {
			for (int i = j + 1; i < nElems; i++) {
				if (array[j] != NULL && array[j] == array[i]) {
					array[i] = NULL;
				}
			}
		}
 
		for (int i = 0; i < nElems;) {
			if (array[i] == NULL) { // 注意:移动完成后不要i++，再次检查当前位置是否为NULL
				for (int j = i + 1; j < nElems; j++) {
					array[j - 1] = array[j];
				}
				nElems--;
			} else {
				i++; // 不是NULL，直接i++;
			}
		}
	}
 
	// the second method
	public void noDup2() {
		int NULL = -1;
		for (int j = 0; j < nElems; j++) {
			for (int i = j + 1; i < nElems; i++) {
				if (array[j] != NULL && array[j] == array[i]) {
					array[i] = NULL;
				}
			}
		}
 
		int order = 0;
		for (int temp = 0; temp < nElems; temp++) {
			if (array[temp] != NULL) {// 因为a[0]不可能等于NULL所以才可以用这种方法
				if (temp > order) {
					array[order] = array[temp];
				}
				order++;
			}
		}
		nElems = order;
	}
	// end programming work 2.6
}
