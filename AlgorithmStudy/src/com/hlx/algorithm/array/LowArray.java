package com.hlx.algorithm.array;

public class LowArray {
	
	private long[] array;
	
	public LowArray(int size){
		array = new long[size];
	}
	
	public void setElem(int index, long value){
		array[index] = value;
	}
	
	public long getElem(int index){
		return array[index];
	}
}
