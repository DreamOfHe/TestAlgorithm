package com.hlx.algorithm.heap;

public class HeapNode {
	private int iData;
	
	public HeapNode(int key){
		iData = key;
	}
	
	public int getKey(){
		return iData;
	}
	
	public void setKey(int id){
		iData = id;
	}
}
