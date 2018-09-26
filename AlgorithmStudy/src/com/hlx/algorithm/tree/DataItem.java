package com.hlx.algorithm.tree;

public class DataItem {
	private long dData;
	
	public DataItem(long dd){
		dData = dd;
	}
	
	public long getdData() {
		return dData;
	}

	public void setdData(long dData) {
		this.dData = dData;
	}

	public void displayItem(){
		System.out.print("/" + dData);
	}
}
