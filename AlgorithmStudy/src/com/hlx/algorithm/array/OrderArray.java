package com.hlx.algorithm.array;

public class OrderArray {

	private long[] array;
	private int nElems;

	public OrderArray(int max) {
		array = new long[max];
		nElems = 0;
	}

	public int size() {
		return nElems;
	}

	public int find1(long searchKey) { // 循环查找
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curIn;

		while (true) {
			curIn = (lowerBound + upperBound) / 2;
			if (array[curIn] == searchKey) {
				return curIn; // find it
			} else if (lowerBound > upperBound) {
				return nElems; // can't find it
			} else {
				if (array[curIn] < searchKey) {
					lowerBound = curIn + 1;
				} else {
					upperBound = curIn - 1;
				}
			}
		}
	}
	
	public int find2(long searchKey){ // 递归查找
		return recFind(searchKey, 0, nElems-1);
	}
	
	private int recFind(long searchKey, int lowerBound, int upperBound){
		int curIn;
		curIn = (lowerBound + upperBound)/2;
		if(array[curIn] == searchKey){
			return curIn;
		} else if(lowerBound > upperBound){
			return nElems;
		} else {
			if(array[curIn] < searchKey){
				return recFind(searchKey, curIn+1, upperBound);
			} else {
				return recFind(searchKey, lowerBound, curIn-1);
			}
		}
	}

	public void insert(long value) {
		int j;
		for (j = 0; j < nElems; j++) { // 1. find where it goes
			if (array[j] > value) { // linear search
				break;
			}
		}
		for (int k = nElems; k > j; k--) { // 2. move bigger ones up
			array[k] = array[k - 1];
		}
		array[j] = value; // 3. insert it
		nElems++;
	}

	public void insertByBinary(long value) { // programming work 2.4
		if (nElems == 0) {
			array[0] = value;
			nElems++;
			return;
		}

		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curIn;
		while (true) {  // binary search
			curIn = (lowerBound + upperBound) / 2;
			if (lowerBound > upperBound) {
				break;
			}
			if (array[curIn] == value)
				break;  // found it
			else if (array[curIn] < value)
			{
				if (curIn == nElems - 1) {
					curIn = curIn + 1;
					break;
				} else if (array[curIn + 1] >= value) {
					curIn = curIn + 1;
					break;
				} else {
					lowerBound = curIn + 1;
				}
			} else {
				if (curIn == 0) {
					break;
				} else if (array[curIn - 1] <= value) {
					break;
				} else {
					upperBound = curIn - 1;
				}
			}
		}
		for (int k = nElems; k > curIn; k--){
			array[k] = array[k - 1];  // move bigger ones up
		}
		array[curIn] = value; // insert it
		nElems++; // increment size
	}

	public boolean delete(long value) {
		int j = find1(value); // programming work 2.4, binary search
		if (j == nElems) {
			return false;
		} else {
			for (int k = j; k < nElems-1; k++) {
				array[k] = array[k + 1];
			}
			nElems--;
			return true;
		}
	}

	public void display() {
		for (int j = 0; j < nElems; j++) {
			System.out.print(array[j] + " ");
		}
		System.out.println("");
	}
	
	public OrderArray merge(OrderArray mergeArray){  // programming work 2.5
		OrderArray resultArray = new OrderArray(this.nElems + mergeArray.nElems);
		for(int j=0; j<this.nElems; j++){
			resultArray.insertByBinary(this.array[j]);
		}
		for(int j=0; j<mergeArray.nElems; j++){
			resultArray.insertByBinary(mergeArray.array[j]);
		}
		return resultArray;
	}
}
